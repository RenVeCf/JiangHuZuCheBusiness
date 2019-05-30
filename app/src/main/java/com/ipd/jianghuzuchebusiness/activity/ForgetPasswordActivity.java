package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.CaptchaBean;
import com.ipd.jianghuzuchebusiness.bean.ForgetPwdBean;
import com.ipd.jianghuzuchebusiness.contract.ForgetPwdContract;
import com.ipd.jianghuzuchebusiness.presenter.ForgetPwdPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.CountDownUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.VerifyUtils;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

/**
 * Description ：忘记密码
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class ForgetPasswordActivity extends BaseActivity<ForgetPwdContract.View, ForgetPwdContract.Presenter> implements ForgetPwdContract.View {

    @BindView(R.id.et_forget_password_phone)
    EditText etForgetPasswordPhone;
    @BindView(R.id.et_forget_password_verification_code)
    EditText etForgetPasswordVerificationCode;
    @BindView(R.id.bt_get_verification_code)
    Button btGetVerificationCode;
    @BindView(R.id.et_register_pwd)
    EditText etRegisterPwd;
    @BindView(R.id.bt_confirm)
    Button btConfirm;

    private long firstTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_forget_password;
    }

    @Override
    public ForgetPwdContract.Presenter createPresenter() {
        return new ForgetPwdPresenter(this);
    }

    @Override
    public ForgetPwdContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    /**
     * 双击退出程序
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastUtil.showShortToast(getResources().getString(R.string.click_out_again));
            firstTime = secondTime;
        } else {
            ApplicationUtil.getManager().exitApp();
        }
    }

    @OnClick({R.id.bt_get_verification_code, R.id.bt_confirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_get_verification_code:
                if (etForgetPasswordPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etForgetPasswordPhone.getText().toString().trim())) {
                    TreeMap<String, String> captchaMap = new TreeMap<>();
                    //获取手机号码
                    captchaMap.put("telPhone", etForgetPasswordPhone.getText().toString().trim());
                    getPresenter().getCaptcha(captchaMap, true, false);
                } else {
                    ToastUtil.showShortToast(getString(R.string.error_phone_num));
                }
                break;
            case R.id.bt_confirm:
                if (isClickUtil.isFastClick()) {
                    //手机号码的长度判断，验证码的长度判断，复选框状态
                    if (etForgetPasswordPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etForgetPasswordPhone.getText().toString().trim()) && etForgetPasswordVerificationCode.getText().toString().trim().length() == 6 && VerifyUtils.isNumeric(etForgetPasswordVerificationCode.getText().toString().trim()) && etRegisterPwd.getText().toString().trim().length() >= 6 && etRegisterPwd.getText().toString().trim().length() <= 16) {
                        TreeMap<String, String> registerMap = new TreeMap<>();
                        registerMap.put("telPhone", etForgetPasswordPhone.getText().toString().trim());
                        registerMap.put("password", etRegisterPwd.getText().toString().trim());
                        registerMap.put("smsCode", etForgetPasswordVerificationCode.getText().toString().trim());
                        getPresenter().getForgetPwd(registerMap, true, false);
                    } else if (etForgetPasswordPhone.getText().toString().trim().length() != 11 || !VerifyUtils.isMobileNumber(etForgetPasswordPhone.getText().toString().trim())) {
                        ToastUtil.showShortToast(getString(R.string.error_phone_num));
                    } else if (etForgetPasswordVerificationCode.getText().toString().trim().length() != 6) {
                        ToastUtil.showLongToast(getResources().getString(R.string.six_length_captcha));
                    } else {
                        ToastUtil.showShortToast(getString(R.string.error_login));
                    }
                }
                break;
        }
    }

    @Override
    public void resultForgetPwd(ForgetPwdBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void resultCaptcha(CaptchaBean data) {
        ToastUtil.showLongToast(data.getMsg());
        //验证码倒计时60内不能重新发送
        new CountDownUtil(btGetVerificationCode)
                .setCountDownMillis(60_000L)//倒计时60000ms
                .setCountDownColor(R.color.white, R.color.white)//不同状态字体颜色
                .setOnClickListener(new View.OnClickListener() {
                    //重新获取验证码
                    @Override
                    public void onClick(View v) {
                        if (etForgetPasswordPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etForgetPasswordPhone.getText().toString().trim())) {
                            TreeMap<String, String> captchaMap = new TreeMap<>();
                            //获取手机号码
                            captchaMap.put("telPhone", etForgetPasswordPhone.getText().toString().trim());
                            getPresenter().getCaptcha(captchaMap, true, false);
                        } else {
                            ToastUtil.showShortToast(getString(R.string.error_phone_num));
                        }
                    }
                })
                .start();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
