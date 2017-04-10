package com.gp.bhi.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class ui_getBrailleDrawable {
	/*
	 * width : screen width 
	 * height : screen height 
	 * click_status : check if the point clicked 
	 * point_position : 1,3,5 or 2,4,6
	 */
	 
	/* 返回要填充格子用的 drawable */
	public static Drawable get_Drawable(int width, int height,
			Boolean click_status, Boolean point_position) {

		// 位图
		Bitmap newb = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		// 画布
		Canvas canvas = null;
		// 画笔
		Paint paint = new Paint();
		//画笔黑色
		paint.setColor(Color.BLACK);
		//画笔去锯齿
		paint.setAntiAlias(true);
		/* 使用maskfilter实现棋子滤镜效果 */
		//光线方向
		float[] dire = new float[]{1,1,1};
		//光线强度
		float light = 0.5f;
		//反射等级
		float specular = 6;
		//模糊级别
		float blur = 3.5f;
		//构建filter
		EmbossMaskFilter emboss = new EmbossMaskFilter(dire, light, specular, blur);
		//应用mask
		paint.setMaskFilter(emboss);
		
		/* 调整背景色 */
		if (point_position) {
			canvas = new Canvas(newb);
			canvas.drawARGB(255, 34, 177, 76);
		} else {
			canvas = new Canvas(newb);
			canvas.drawARGB(255, 255, 242, 0);
		}
		
		/* 判断是否画点 */
		if(click_status)
		{
			canvas.drawCircle(width/2, height/2, width/5, paint);
		}

		Drawable drawable = new BitmapDrawable(newb);

		return drawable;
	}

	/* 清楚所有drawable */
	public static Drawable clear_Drawable(int width, int height,
			Boolean point_position) {
		Log.i("ui_getBrailleDrawable", "test");
		// 位图
		Bitmap newb = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		// 画布
		Canvas canvas = new Canvas(newb);

		/* 调整背景色 */
		if (point_position) {
			canvas.drawARGB(255, 34, 177, 76);
		} else {
			canvas.drawARGB(255, 255, 242, 0);
		}

		Drawable drawable = new BitmapDrawable(newb);

		return drawable;
	}
}
