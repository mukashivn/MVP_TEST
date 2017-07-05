package com.core.ssvapp.ui.businessdetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.core.ssvapp.R;
import com.core.ssvapp.data.network.model.Business;
import com.core.ssvapp.data.network.model.Category;
import com.core.ssvapp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Package: com.core.ssvapp.ui.businessdetail
 * Created by: CuongCK
 * Date: 7/5/17
 */

public class DetailAcitivty extends BaseActivity implements IDetailView {
    @BindView(R.id.de_name)
    TextView nameView;
    @BindView(R.id.de_image)
    ImageView imageView;
    @BindView(R.id.de_address)
    TextView addressView;
    @BindView(R.id.de_phone)
    TextView phoneView;
    @BindView(R.id.de_web)
    TextView webView;
    @BindView(R.id.category_container)
    LinearLayout mContainerCate;

    public static final String EXTRA_DATA_KEY = "EXTRA_DATA_KEY";

    @Inject
    IDetailPresenter<IDetailView> mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(this);
        Business business = (Business)getIntent().getSerializableExtra(EXTRA_DATA_KEY);
        mPresenter.init(business);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void setUp() {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @OnClick(R.id.arrow_back_action)
    void back() {
        this.finish();
    }

    @Override
    public void showImage(String url) {
        Glide.with(this).load(url).into(imageView);
    }

    @Override
    public void showName(String name) {
        nameView.setText(name);
    }

    @Override
    public void showPhone(String phone) {
        phoneView.setText(phone);
    }

    @Override
    public void showWeb(String web) {
        webView.setText(web);
    }

    @Override
    public void showCategory(List<Category> categoryList) {
        for (Category category : categoryList) {
            View view = getLayoutInflater().inflate(R.layout.item_category, null);
            TextView cateName = (TextView) view.findViewById(R.id.category);
            cateName.setText(category.getTitle());
            mContainerCate.addView(view);
        }
    }

    @Override
    public void showAddress(String address) {
        addressView.setText(address);
    }
}
