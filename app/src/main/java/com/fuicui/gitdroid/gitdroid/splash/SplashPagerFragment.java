package com.fuicui.gitdroid.gitdroid.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fuicui.gitdroid.gitdroid.R;
import com.fuicui.gitdroid.gitdroid.splash.pager.Pager2;
import com.nineoldandroids.animation.ArgbEvaluator;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by lenovo on 2016/8/23.
 */
public class SplashPagerFragment extends Fragment implements ViewPager.OnPageChangeListener {
    private SplashPagerAdapter adapter;
    @BindView(R.id.ivPhoneFont) ImageView ivPhoneFont;
    @BindView(R.id.layoutPhone) FrameLayout layoutPhone;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.indicator) CircleIndicator indicator;
    @BindView(R.id.content) FrameLayout frameLayout;
    @BindColor(R.color.colorGreen) int colorGreen;
    @BindColor(R.color.colorRed) int colorRed;
    @BindColor(R.color.colorYellow) int colorYellow;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_splash_pager,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter=new SplashPagerAdapter(getContext());
        viewPager.setAdapter(adapter);
        indicator.setViewPager(viewPager);//第三方框架，使小点与ViewPAger联动
        //viewPager设置监听，改变pager的背景颜色
        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        ArgbEvaluator argbEvaluator=new ArgbEvaluator();//计算颜色的工具，系统自带,过渡颜色，设置的Position为lenth-1,当过度到最后一个页面时，就不需要在设置了
        if (position==0){
            int color= (int) argbEvaluator.evaluate(positionOffset,colorGreen,colorRed);
            frameLayout.setBackgroundColor(color);
            //手机视图缩放动画,positionOffset范围0—1
            float scale=0.3f+positionOffset*0.7f;
            layoutPhone.setScaleX(scale);
            layoutPhone.setScaleY(scale);

            //手机视图移动效果
            int scroll= (int) ((positionOffset-1)*360);
            layoutPhone.setTranslationX(scroll);

            //手机视图中字体图片透明度的改变,参数直接可使用偏移量positionOffset范围0—1
            ivPhoneFont.setAlpha(positionOffset);
            return;
        }
        //手机视图第二页面动画
        if (position==1){
            int color= (int) argbEvaluator.evaluate(positionOffset,colorRed,colorYellow);
            frameLayout.setBackgroundColor(color);
            layoutPhone.setTranslationX(-positionOffsetPixels);//偏移量像素
            return;
        }
        if (position==2){
//              new Pager2(getContext()).showAnimation();
            Pager2 pager2= (Pager2) adapter.getViews(position);
            pager2.showAnimation();
        }




    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
