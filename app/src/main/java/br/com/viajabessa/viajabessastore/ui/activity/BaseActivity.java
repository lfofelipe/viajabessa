package br.com.viajabessa.viajabessastore.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import br.com.viajabessa.viajabessastore.R;
import br.com.viajabessa.viajabessastore.common.SnackbarUtil;
import br.com.viajabessa.viajabessastore.presentation.view.BaseView;
import butterknife.BindView;


public class BaseActivity extends AppCompatActivity implements BaseView {

    @Nullable
    @BindView(R.id.root_view)
    View mRootView;

    @Nullable
    @BindView(R.id.progress)
    ProgressBar progress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
    @Override
    public void showRootView(boolean isShow){
        if( mRootView == null ){
            return;
        }

        if(isShow){
            mRootView.setVisibility(View.VISIBLE);
        }else{
            mRootView.setVisibility(View.GONE);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void showToastLongTime(String message){
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSnackbar(String mensagem) {
        if( getView() == null ){
            return;
        }
        SnackbarUtil.showError(getView(), mensagem);
    }

    @Override
    public void showSnackbar(String strMessage, String strAction, View.OnClickListener onClick){
        SnackbarUtil.showError(getView(), strMessage, Snackbar.LENGTH_INDEFINITE, strAction, onClick);
    }

    public void showProgress(boolean isShow) {
        if( progress == null ){
            return;
        }

        if(isShow){
            progress.setVisibility(View.VISIBLE);
        }else{
            progress.setVisibility(View.GONE);
        }
    }



    @Override
    public void esconderTeclado() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
    }

    public View getView(){
        return mRootView;
    }
}
