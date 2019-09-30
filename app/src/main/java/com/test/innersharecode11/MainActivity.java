package com.test.innersharecode11;

import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.test.innersharecode11.dialog.MyDialogFragment;
import com.test.innersharecode11.dialog.MyDialogFragment2;
import com.test.innersharecode11.dialog.MyDialogFragment3;
import com.test.innersharecode11.dialog.MyDialogFragment4;
import com.test.innersharecode11.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void testSimpleDialog(View view) {
        new MyDialogFragment().show(getSupportFragmentManager(), "TestSimpleDialog");
    }

    public void testSimpleAlertDialog(View view) {
        createAlertDialog().show();
    }

    private AlertDialog createAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("一个测试弹框")
                .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ToastUtils.showToast(MainActivity.this, "点击了确认");
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtils.showToast(MainActivity.this, "点击了取消");
            }
        });
        return builder.create();
    }

    public void testListAlertDialog(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标题").setMessage("选择一个颜色吧")
        .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setNeutralButton("纠结中", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .create().show();
    }

    public void testCustomAlertDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View dialogView = getLayoutInflater().inflate(R.layout.custome_dialog_view, null);
        builder.setView(dialogView);
        builder.create().show();
    }

    public void testDialogFragment(View view) {
        new MyDialogFragment2().show(getSupportFragmentManager(), "TestDialogFragment");
    }

    public void testDialogFragmentDataRecive(View view) {
        MyDialogFragment3 dialogFragment = new MyDialogFragment3();
        dialogFragment.setMyDialogListener(new MyDialogFragment3.OnMyDialogListener() {
            @Override
            public void editChanged(String content) {
                ToastUtils.showToast(MainActivity.this, content);
            }
        });
        dialogFragment.show(getSupportFragmentManager(), "TestDialogFragmentDataRecive");
    }

    boolean isLargeLayout = false;
    public void testDialogCanEmbeddedFragment(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialogFragment4 dialogFragment = new MyDialogFragment4();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (isLargeLayout) {
            dialogFragment.show(fragmentManager, "TestDialogCanEmbeddedFragment");
            dialogFragment.dismissAllowingStateLoss();
        } else {
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.add(R.id.fragment_container, dialogFragment)
                    .addToBackStack(null).commit();
        }
        isLargeLayout = !isLargeLayout;
    }
}
