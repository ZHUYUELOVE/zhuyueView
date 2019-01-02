package zhuyue.bwie.com.zhuyueview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {

    private Paint mPaint;//画笔
    private int circleX;//圆的x轴起始坐标
    private int circleY;//圆的Y轴起始坐标
    private int mRaduis=100;//圆的半径


    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初始化对象的方法
     */
    private void init() {
   mPaint=new Paint();
   mPaint.setColor(Color.RED);
   mPaint.setAntiAlias(true);
   //mPaint.setStyle(Paint.Style.FILL);//实心
   mPaint.setStyle(Paint.Style.STROKE);//空心
    mPaint.setStrokeWidth(20);
    }

    /**
     * 测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 绘制
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("重绘:"+"========");
       canvas.drawCircle(circleX,circleY,mRaduis,mPaint);
    }
    /**
     * 触摸事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_POINTER_DOWN://按下
            circleX= (int) event.getX();
            circleY= (int) event.getY();
            invalidate();//重绘
            break;
            case  MotionEvent.ACTION_MOVE://滑动
                circleX= (int) event.getX();
                circleY= (int) event.getY();
                invalidate();
                break;
                case MotionEvent.ACTION_POINTER_UP:

                    break;
        }


        return true;
    }
}
