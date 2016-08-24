package com.fuicui.gitdroid.gitdroid.splash.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.fuicui.gitdroid.gitdroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/8/23.
 */
public class Pager2 extends FrameLayout{

    @BindView(R.id.ivBubble1) ImageView ivBubble1;
    @BindView(R.id.ivBubble2) ImageView ivBubble2;
    @BindView(R.id.ivBubble3) ImageView ivBubble3;
    public Pager2(Context context) {
       this(context,null);
    }
    public Pager2(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public Pager2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.content_pager_2,this,true);
        ButterKnife.bind(this);//ButterKnife绑定一定在绑定View之后，否则会报错
        ivBubble1.setVisibility(INVISIBLE);
        ivBubble2.setVisibility(INVISIBLE);
        ivBubble3.setVisibility(INVISIBLE);
    }
    //显示动画的方法
    public void showAnimation(){
        if (ivBubble1.getVisibility()!=VISIBLE){
            postDelayed(new Runnable() {
                @Override
                public void run() {
                  ivBubble1.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInLeft).duration(300).playOn(ivBubble1);
                }
            },100);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble2.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInLeft).duration(300).playOn(ivBubble2);
                }
            },600);
            postDelayed(new Runnable() {
                @Override
                public void run() {
                    ivBubble3.setVisibility(VISIBLE);
                    YoYo.with(Techniques.BounceInLeft).duration(300).playOn(ivBubble3);
                }
            },1100);
        }
    }

}
