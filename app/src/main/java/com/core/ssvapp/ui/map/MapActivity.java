package com.core.ssvapp.ui.map;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Toast;

import com.core.ssvapp.R;
import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.ui.adapter.MarkerInfoAdapter;
import com.core.ssvapp.ui.base.BaseActivity;
import com.core.ssvapp.ui.businessdetail.DetailAcitivty;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

/**
 * Package: com.core.ssvapp.ui.map
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class MapActivity extends BaseActivity implements OnMapReadyCallback, IMapViews, GoogleMap.OnMarkerClickListener, GoogleMap.OnCameraMoveListener {
    private GoogleMap mMap;
    private List<Marker> mMarkers = new ArrayList<>();
    private static final int MESSAGE_ID_SAVE_CAMERA_POSITION = 1;
    private static final int MESSAGE_ID_READ_CAMERA_POSITION = 2;
    private CameraPosition lastCameraPosition;
    private Handler handler;
    private FusedLocationProviderClient mFusedLocationClient;

    @Inject
    IMapPresenter<IMapViews> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        setUp();
        mPresenter.init();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_maps;
    }

    @Override
    protected void setUp() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = getFusedLocationProviderClient(this);

    }

    void getLastLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissionsSafely(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001);
            return;
        }
        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, location -> {
                    // Got last known location. In some rare situations this can be null.
                    if (location != null) {
                        mPresenter.getRes(location.getLatitude(), location.getLongitude());
                    }
                });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new MarkerInfoAdapter(MapActivity.this));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(marker -> {
            Gson gson = new Gson();
            Business business = gson.fromJson(marker.getSnippet(), Business.class);
            Intent intent = new Intent(this, DetailAcitivty.class);
            intent.putExtra(DetailAcitivty.EXTRA_DATA_KEY, business);
            startActivity(intent);
        });
        /*
        mMap.setOnCameraMoveListener(this);
        // Add a marker in Sanfranciso and move the camera
        LatLng sydney = new LatLng(37.786882, -122.399972);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sanfranciso"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        */
        handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == MESSAGE_ID_SAVE_CAMERA_POSITION) {
                    lastCameraPosition = googleMap.getCameraPosition();
                } else if (msg.what == MESSAGE_ID_READ_CAMERA_POSITION) {
                    if (lastCameraPosition.equals(googleMap.getCameraPosition())) {
                        Log.d("Map", "Camera position stable");
                        mPresenter.getRes(lastCameraPosition.target.latitude, lastCameraPosition.target.longitude);
                    }
                }
            }
        };

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void showGetAccessToken() {
        showCommonMessage(R.string.get_access_token_success);
        //Todo: Cause this my place don't have so i debug with sanfranciso
        //In real, must get current location of device and fill it
        // mPresenter.getRes(37.786882, -122.399972);
        getLastLocation();
    }

    @Override
    public void showCommonMessage(int id) {
        Toast.makeText(this, getString(id), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRestaurants(List<Business> list) {
        for (Business business : list) {
            Marker temp = mMap.addMarker(mPresenter.createMarker(business));
            mMarkers.add(temp);
        }
    }

    @Override
    public void updateBoundCamera() {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (Marker marker : mMarkers) {
            builder.include(marker.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 0; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

        mMap.moveCamera(cu);

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        showCommonMessage(R.string.app_name);
        return false;
    }

    @Override
    public void onCameraMove() {
        mPresenter.onCameraMove(handler);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1001) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }
}
