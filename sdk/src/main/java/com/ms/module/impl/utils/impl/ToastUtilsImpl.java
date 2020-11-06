package com.ms.module.impl.utils.impl;

import android.widget.Toast;

import com.ms.module.supers.client.Modules;
import com.ms.module.supers.inter.utils.IToastUtils;

public class ToastUtilsImpl implements IToastUtils {

    private ToastUtilsImpl() {
    }

    private static final ToastUtilsImpl TOAST_UTILS_IMPL = new ToastUtilsImpl();

    public static ToastUtilsImpl getInstance() {
        return TOAST_UTILS_IMPL;
    }

    private static Toast toast;

    @Override
    public void show(final String s) {
        Modules.getUtilsModule().getThreadPoolUtils().runOnMainThread(new Runnable() {
            @Override
            public void run() {
                if (toast == null) {
                    toast = Toast.makeText(Modules.getDataModule().getAppData().getApplication(), s, Toast.LENGTH_LONG);
                } else {
                    toast.setText(s);
                }
                toast.show();
            }
        });
    }
}
