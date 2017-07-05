package com.core.ssvapp.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.core.ssvapp.R;
import com.core.ssvapp.data.network.model.Business;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Package: com.core.ssvapp.ui.adapter
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class MarkerInfoAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mContentsView;
    private Gson mGson;
    private Context mContext;

    public MarkerInfoAdapter(Activity context) {
        mContentsView = context.getLayoutInflater().inflate(R.layout.info_marker_windown, null);
        mGson = new Gson();
        mContext = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        Business business = mGson.fromJson(marker.getSnippet(), Business.class);
        VHMarker vhMarker = new VHMarker(mContentsView);
        vhMarker.resName.setText(business.getName());
        vhMarker.resAddr.setText(business.getLocation().getAddress1());
        vhMarker.resRate.setRating((float) business.getRating());
        Glide.with(mContext).load(business.getImageUrl()).placeholder(R.drawable.ic_pause).into(vhMarker.resImage);

        return mContentsView;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    class VHMarker {
        @BindView(R.id.res_image)
        ImageView resImage;
        @BindView(R.id.res_name)
        TextView resName;
        @BindView(R.id.res_address)
        TextView resAddr;
        @BindView(R.id.res_rating)
        RatingBar resRate;

        public VHMarker(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
