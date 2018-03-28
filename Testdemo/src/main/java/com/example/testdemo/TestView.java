package com.example.testdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 11234567 on 2018/3/12.
 */

public class TestView extends View{

    public TestView(Context context) {
        super(context);
    }

    public TestView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TestView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //这里需要通过bitmap创建canvas才能对Xfermode生效果,具体原因这里也不大清楚
        Bitmap bitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_4444);
        Canvas xFerCanvas = new Canvas(bitmap);
        //绘画半透明遮罩
        xFerCanvas.drawColor(Color.parseColor("#90000000"));
        Paint paint = new Paint();
        paint.setColor(Color.TRANSPARENT);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        //设置当前画笔的Xfermode模式,不同的模式效果可以参照Google提供的Demo-ApiDemos/Graphics/XferModes
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        int left = getWidth()/2;
        int top = getHeight()/2;
        //绘制透明预览框
        xFerCanvas.drawCircle(left, top, 300, paint);
        //最后将生成的bitmap绘制到我们的画布上
        canvas.drawBitmap(bitmap,0,0,null);
        bitmap.recycle();
        System.gc();
    }
}
