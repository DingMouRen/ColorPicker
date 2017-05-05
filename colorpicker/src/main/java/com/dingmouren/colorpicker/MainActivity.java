package com.dingmouren.colorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private boolean isSupportAlpha;
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button) findViewById(R.id.btn1);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isSupportAlpha = !isSupportAlpha;
                new ColorPickerDialog(MainActivity.this, Color.RED, isSupportAlpha,new ColorPickerDialog.OnColorPickerListener() {

                    @Override
                    public void onColorCancel(ColorPickerDialog dialog) {

                    }

                    @Override
                    public void onColorChange(ColorPickerDialog dialog, int color) {
                        Log.e(TAG,"onChange:"+color);
                        mButton.setBackgroundColor(color);
                    }

                    @Override
                    public void onColorConfirm(ColorPickerDialog dialog, int color) {
                        Log.e(TAG,"onColorConfirm:"+color);
                    }
                }).show();
            }
        });
    }


}
