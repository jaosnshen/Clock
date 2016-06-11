package shenhangye.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by shenhangye on 16/6/11.
 */
public class MyClock extends View{
    private Paint paintCircle;
    private Paint painDegree;
    public MyClock(Context context) {
        super(context);
        init();
    }

    public MyClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyClock(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public MyClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paintCircle =new Paint();
        paintCircle.setStyle(Paint.Style.STROKE);
        paintCircle.setAntiAlias(true);
        paintCircle.setStrokeWidth(5);
        painDegree=new Paint();
        painDegree.setStrokeWidth(3);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeigh(heightMeasureSpec));
    }
    private int measureWidth(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if (specMode==MeasureSpec.EXACTLY){
            result=specSize;
        }else{
            result=200;
            if (specMode==MeasureSpec.AT_MOST){
                result=Math.min(result,specSize);
            }
        }
        return result;
    }
    private int measureHeigh(int measureSpec){
        int result=0;
        int specMode=MeasureSpec.getMode(measureSpec);
        int specSize=MeasureSpec.getSize(measureSpec);
        if (specMode==MeasureSpec.EXACTLY){
            result=specSize;
        }else{
            result=200;
            if (specMode==MeasureSpec.AT_MOST){
                result=Math.min(result,specSize);
            }
        }
        return result;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int mWidth=getWidth();
        int mHeight=getHeight();
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,paintCircle);
        for(int i=0;i<24;++i){
            if (i==0|i==6||i==12||i==18){
                painDegree.setStrokeWidth(5);
                paintCircle.setTextSize(15);
                canvas.drawLine(mWidth/2,mHeight/2-mWidth/2,
                        mWidth/2,mHeight/2-mWidth/2+60,painDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree,mWidth/2-painDegree.measureText(degree)/2,
                        mHeight/2-mWidth/2+90,painDegree);
            }else {
                painDegree.setStrokeWidth(3);
                painDegree.setTextSize(25);
                canvas.drawLine(mWidth/2,mHeight/2-mWidth/2,mWidth/2,
                        mHeight/2-mWidth/2+30,painDegree);
                String degree=String.valueOf(i);
                canvas.drawText(degree,
                        mWidth/2-painDegree.measureText(degree)/2,
                        mHeight/2-mWidth/2+60,painDegree);
            }
            canvas.rotate(15,mWidth/2,mHeight/2);
        }

    }
}
