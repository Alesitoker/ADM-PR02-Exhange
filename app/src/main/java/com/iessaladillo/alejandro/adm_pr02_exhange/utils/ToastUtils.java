package com.iessaladillo.alejandro.adm_pr02_exhange.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private ToastUtils() {

    }

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
