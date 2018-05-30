package com.orientweather.util;

import android.app.ProgressDialog;
import android.content.Context;

public class ViewUtil {
    private static ProgressDialog progressDialog;
    /**
     * 显示进度对话框
     */
    public static void showProgressDialog(Context context,String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(message);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭进度对话框
     */
    public static void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
