package br.com.viajabessa.viajabessastore.presentation.view;

import android.view.View;

public interface BaseView {
    void showRootView(boolean isShow);

    void showToastLongTime(String message);

    void showSnackbar(String mensagem);

    void showSnackbar(String strMessage, String strAction, View.OnClickListener onClick);

    void showProgress(boolean isShow);

    void esconderTeclado();

}
