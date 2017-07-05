package com.core.ssvapp.ui.businessdetail;

import com.core.ssvapp.data.network.model.Category;
import com.core.ssvapp.ui.base.IView;

import java.util.List;

/**
 * Package: com.core.ssvapp.ui.businessdetail
 * Created by: CuongCK
 * Date: 7/5/17
 */

public interface IDetailView extends IView {
    void showImage(String url);

    void showName(String name);

    void showPhone(String phone);

    void showWeb(String web);

    void showCategory(List<Category> categoryList);

    void showAddress(String address);
}
