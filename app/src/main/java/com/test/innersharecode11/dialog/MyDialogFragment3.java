package com.test.innersharecode11.dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.test.innersharecode11.R;

/**
 * 描述：
 * 日期：2019/9/30
 * 作者：水寒
 * 邮箱：lxq_xsyu@163.com
 */
public class MyDialogFragment3 extends DialogFragment {

    private TextView mTextView;
    private EditText mEditTextView;
    private OnMyDialogListener mDialogListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = requireActivity().getLayoutInflater().inflate(R.layout.custome_dialog_edit_view, null);
        mEditTextView = view.findViewById(R.id.editText);
        mTextView = view.findViewById(R.id.textView2);
        mEditTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(mDialogListener != null){
                    mDialogListener.editChanged(getEditTextContent());
                }
            }
        });
        return view;
    }

    public interface OnMyDialogListener{
        public void editChanged(String content);
    }

    public void setMyDialogListener(OnMyDialogListener listener){
        mDialogListener = listener;
    }

    public String getEditTextContent(){
        if(mEditTextView == null) return "";
        return mEditTextView.getText().toString();
    }

    public void changeTextShow(String text){
        if(mTextView == null) return;
        mTextView.setText(text);
    }
}
