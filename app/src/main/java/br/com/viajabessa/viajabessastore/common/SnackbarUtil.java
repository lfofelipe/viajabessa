package br.com.viajabessa.viajabessastore.common;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.View;


public class SnackbarUtil {


    public static void showError(@NonNull View view, @NonNull String message){
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public static void showError(@NonNull View view, @NonNull String message, @IntRange(from = -2, to = 1) int duration){
        Snackbar.make(view, message, duration).show();
    }


    public static void showError(@NonNull View view, @NonNull String message, @IntRange(from = -2, to = 1) int duration, String strAction, View.OnClickListener action){
        Snackbar.make(view, message, duration)
                .setAction(strAction, action)
                .show();
    }
}

