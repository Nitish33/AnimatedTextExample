package devnitish.com.animatedtext;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class AnimatedTextView extends android.support.v7.widget.AppCompatTextView {

    private String text;
    private int animLen = 0;
    private int animSpeed = 200;
    private int animStartSpeed = 200;
    private int animEndSpeed = 200;
    private int stepSize;
    private boolean autoStart = true;
    private int animIndex = 0;

    private Handler speedHandler = new Handler();
    private Handler totalHandler = new Handler();

    private Runnable speedRunnable;
    private Runnable totalRunnable;

    // for the use to animate speed without pause...
    Runnable r1,r2;
    Runnable r3,r4;
    int animDelay = 0;

    StringBuffer buffer = new StringBuffer();

    // interfaces........................................................
    public interface AnimationCompletionListener{
        public void onAnimationComplete();
    }

    AnimationCompletionListener listener;

    public AnimatedTextView(Context context) {
        super(context);

        init();
        text = (String) getText();
        animateText();

    }

    public AnimatedTextView(Context context,boolean autoStart) {
        super(context);

        init();
        if(autoStart) {
            text = (String) getText();
            animateText();
        }
    }


    public AnimatedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        getAttributes(attrs);
        init();

        if(autoStart) {
            text = (String) getText();
            animateText();
        }

    }

    public AnimatedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        getAttributes(attrs);
        init();

        if(autoStart) {
            text = (String) getText();
            animateText();

        }
    }

    private void getAttributes(AttributeSet attrs){

        TypedArray array = getContext().obtainStyledAttributes(attrs,R.styleable.AnimatedTextView);

        animSpeed = array.getInt(R.styleable.AnimatedTextView_animInterval,200);
        autoStart = array.getBoolean(R.styleable.AnimatedTextView_autoStart,true);

        array.recycle();
    }


    private void init(){

        speedRunnable = new Runnable() {
            @Override
            public void run() {

                if(animLen<text.length()){

//                    buffer.append(text.charAt(animLen));
                    append(text.charAt(animLen)+"");
                    ++animLen;

                    speedHandler.postDelayed(this, animSpeed);

                    Log.e("animation Time", animSpeed +"");
                }
                else {

                    Toast.makeText(getContext(),"completed",Toast.LENGTH_SHORT);

                    if(listener!=null){

                        Toast.makeText(getContext(),"completed calling",Toast.LENGTH_SHORT);
                        listener.onAnimationComplete();
                    }
                }
            }
        };

    }

    public void animateText(){

        text = (String) getText();
        setText("");

        animateT();

    }

    private void animateT(){


        final int length = text.length();
        stepSize = (animEndSpeed- animStartSpeed)/length;


        speedHandler.postDelayed(speedRunnable, 0);
    }


    public void animateText(final ArrayList<String> allString,
                             final ArrayList<Integer> allSpeed){

        if(allString.size()!=allSpeed.size()){
            return;
        }


        setText("");

        final Handler handler = new Handler();
        int len;
        animIndex = 0;

        listener = new AnimationCompletionListener() {
            @Override
            public void onAnimationComplete() {

                Log.e("index",""+animIndex);
                ++animIndex;
                handler.post(r1);
            }
        };

        r1 = new Runnable() {
            @Override
            public void run() {
                if(animIndex<allString.size()) {
                    text = allString.get(animIndex);
                    animSpeed = allSpeed.get(animIndex);
                    animLen = 0;

                    handler.post(r2);
                }
            }
        };

        r2 = new Runnable() {
            @Override
            public void run() {

                text = allString.get(animIndex);
                animSpeed = allSpeed.get(animIndex);

                animateT();

            }
        };

        Handler h = new Handler();;
        h.post(r1);




    }


    public void animateText(final ArrayList<String> allString,
                            final ArrayList<Integer> allSpeed,
                            final ArrayList<Integer> allDelay){

        if(allString.size()!=allSpeed.size() && allDelay.size()!=allSpeed.size()){
            return;
        }


        setText("");

        final Handler handler = new Handler();
        int len;
        animIndex = 0;

        listener = new AnimationCompletionListener() {
            @Override
            public void onAnimationComplete() {

                Log.e("index",""+animIndex);
                ++animIndex;

                handler.postDelayed(r3,animDelay);
            }
        };

        r1 = new Runnable() {
            @Override
            public void run() {
                if(animIndex<allString.size()) {
                    text = allString.get(animIndex);
                    animSpeed = allSpeed.get(animIndex);
                    animDelay = allDelay.get(animIndex);
                    animLen = 0;

                    handler.post(r2);
                }
            }
        };

        r2 = new Runnable() {
            @Override
            public void run() {

                text = allString.get(animIndex);
                animSpeed = allSpeed.get(animIndex);

                animateT();

            }
        };

        r3 = new Runnable() {
            @Override
            public void run() {

                handler.post(r1);
            }
        };

        Handler h = new Handler();;
        h.post(r1);




    }


    public void animateText(final ArrayList<String> allString,
                            final ArrayList<Integer> allSpeed,
                            final boolean overlap){

        if(allString.size()!=allSpeed.size()){
            return;
        }


        setText("");

        final Handler handler = new Handler();
        int len;
        animIndex = 0;

        listener = new AnimationCompletionListener() {
            @Override
            public void onAnimationComplete() {

                Log.e("index",""+animIndex);
                ++animIndex;
                handler.post(r1);
            }
        };

        r1 = new Runnable() {
            @Override
            public void run() {
                if(animIndex<allString.size()) {
                    text = allString.get(animIndex);
                    animSpeed = allSpeed.get(animIndex);
                    animLen = 0;

                    handler.post(r2);
                }
            }
        };

        r2 = new Runnable() {
            @Override
            public void run() {

                text = allString.get(animIndex);
                animSpeed = allSpeed.get(animIndex);

                if(overlap) {
                    setText("");
                }

                animateT();

            }
        };

        Handler h = new Handler();;
        h.post(r1);




    }


    public void animateText(final ArrayList<String> allString,
                            final ArrayList<Integer> allSpeed,
                            final ArrayList<Integer> allDelay,
                            final boolean overlap){

        if(allString.size()!=allSpeed.size() && allDelay.size()!=allSpeed.size()){
            return;
        }


        setText("");

        final Handler handler = new Handler();
        int len;
        animIndex = 0;

        listener = new AnimationCompletionListener() {
            @Override
            public void onAnimationComplete() {

                Log.e("index",""+animIndex);
                ++animIndex;

                handler.postDelayed(r3,animDelay);
            }
        };

        r1 = new Runnable() {
            @Override
            public void run() {
                if(animIndex<allString.size()) {
                    text = allString.get(animIndex);
                    animSpeed = allSpeed.get(animIndex);
                    animDelay = allDelay.get(animIndex);
                    animLen = 0;

                    handler.post(r2);
                }
                else {
                    setText(allString.get(0));
                }
            }
        };

        r2 = new Runnable() {
            @Override
            public void run() {

                text = allString.get(animIndex);
                animSpeed = allSpeed.get(animIndex);

                if(overlap){
                    setText("");
                }
                animateT();

            }
        };

        r3 = new Runnable() {
            @Override
            public void run() {

                handler.post(r1);
            }
        };

        Handler h = new Handler();;
        h.post(r1);




    }

}
