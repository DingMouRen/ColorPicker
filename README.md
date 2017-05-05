# ColorPicker

ColorPicker是一款为android项目提供的取色器。Enjoy it  O(∩_∩)O<br><br>

![img](https://github.com/DingMouRen/ColorPicker/raw/master/imgs/img.gif)<br><br>

# 使用方法

	1.在modle的build.gradle中添加引用
```
	compile 'com.dingmouren.colorpicker:colorpicker:1.0.1'
```
	2.代码中使用
	
```
	 private boolean supportAlpha;//是否支持透明度
	 /**
       * 创建支持透明度的取色器
       * @param context 宿主Activity
       * @param defauleColor 默认的颜色
       * @param isSupportAlpha 颜色是否支持透明度
       * @param listener 取色器的监听器
       */
	   ColorPickerDialog mColorPickerDialog = new ColorPickerDialog(
	   MainActivity.this,
	   getResources().getColor(R.color.colorPrimary),
	   supportAlpha,
	   mOnColorPickerListener
	   ).show();
	 
	 //取色器的监听器
	 private OnColorPickerListener mOnColorPickerListener = new OnColorPickerListener() {
        @Override
        public void onColorCancel(ColorPickerDialog dialog) {//取消选择的颜色

        }

        @Override
        public void onColorChange(ColorPickerDialog dialog, int color) {//实时监听颜色变化
            
        }

        @Override
        public void onColorConfirm(ColorPickerDialog dialog, int color) {//确定的颜色
            
        }
    };
```
	3.注意：本控件支持修改“确定” “取消”按钮文本的颜色，必须是在ColorPicker.show()之后，
	  调用setButtonTextColor(int color)来设定。
	
	
	
	
	
	
	
	
	
	
