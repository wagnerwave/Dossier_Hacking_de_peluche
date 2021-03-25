package androidx.appcompat.view.menu;

import androidx.appcompat.view.menu.MenuPresenter;

public interface MenuHelper {
    void dismiss();

    void setPresenterCallback(MenuPresenter.Callback callback);
}
