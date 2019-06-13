package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.os.Handler;

import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.base.BasePresenter;
import com.ipd.jianghuzuchebusiness.base.BaseView;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.FIRST_APP;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.IS_LOGIN;

/**
 * Description ：启动页
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/6/12.
 */
public class SplashActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);

        // 判断是否是第一次开启应用
        boolean isFirstOpen = (boolean) SPUtil.get(this, FIRST_APP, true);
        // 如果是第一次启动，则先进入功能引导页
        if (isFirstOpen) {
            Intent intent = new Intent(this, LoadingActivity.class);
            startActivity(intent);
            finish();
            return;
        }

        // 如果不是第一次启动app，则正常显示启动屏
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (SPUtil.get(SplashActivity.this, IS_LOGIN, "").equals(""))
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                else
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }
}
