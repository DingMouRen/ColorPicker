package com.dingmouren.colorpicker;

/**
 * Created by dingmouren on 2017/5/5.
 */

public interface OnColorPickerListener {
    void onColorCancel(ColorPickerDialog dialog);
    void onColorChange(ColorPickerDialog dialog,int color);
    void onColorConfirm(ColorPickerDialog dialog,int color);
}
