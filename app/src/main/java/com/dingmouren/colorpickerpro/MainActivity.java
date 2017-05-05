package com.dingmouren.colorpickerpro;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.dingmouren.colorpicker.ColorPickerDialog;
import com.dingmouren.colorpicker.OnColorPickerListener;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private Button mButton;
    private ColorPickerDialog mColorPickerDialog;
    private boolean supportAlpha;//颜色是否支持透明度
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toobar);
        mButton = (Button) findViewById(R.id.btn);
        mToolbar.setTitle("DingMouRen--ColorPicker");
        setSupportActionBar(mToolbar);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mColorPickerDialog = new ColorPickerDialog(MainActivity.this,getResources().getColor(R.color.colorPrimary),supportAlpha,mOnColorPickerListener).show();
                supportAlpha = !supportAlpha;
            }
        });


    }
    private OnColorPickerListener mOnColorPickerListener = new OnColorPickerListener() {
        @Override
        public void onColorCancel(ColorPickerDialog dialog) {

        }

        @Override
        public void onColorChange(ColorPickerDialog dialog, int color) {
            if (mToolbar != null){
                mToolbar.setBackgroundColor(color);
                mColorPickerDialog.setButtonTextColor(color);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(color);
                }
            }
        }

        @Override
        public void onColorConfirm(ColorPickerDialog dialog, int color) {
            if (mButton != null){
                mButton.setBackgroundColor(color);
            }
        }
    };
}
