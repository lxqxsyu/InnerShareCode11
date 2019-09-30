package com.test.innersharecode11.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 描述：
 * 日期：2019/9/30
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
public class ToastUtils {

    public static void showToast(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
