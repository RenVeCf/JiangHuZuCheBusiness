package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.LoginBean;
import com.ipd.jianghuzuchebusiness.contract.LoginContract;
import com.ipd.jianghuzuchebusiness.presenter.LoginPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.VerifyUtils;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.AVATAR;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.IS_LOGIN;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.JPUSH_SEQUENCE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.NAME;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.PHONE;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：登录
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.bt_login)
    Button btLogin;

    private long firstTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //自动登录
        if (!SPUtil.get(this, IS_LOGIN, "").equals("")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
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

    @OnClick({R.id.tv_forget_pwd, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                finish();
                break;
            case R.id.bt_login:
                if (etLoginPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etLoginPhone.getText().toString().trim()) && etLoginPwd.getText().toString().trim().length() >= 6 && etLoginPwd.getText().toString().trim().length() <= 16) {
                    TreeMap<String, String> loginMap = new TreeMap<>();
                    //获取手机号码
                    loginMap.put("telPhone", etLoginPhone.getText().toString().trim());
                    //获取密码
                    loginMap.put("password", etLoginPwd.getText().toString().trim());
                    getPresenter().getLogin(loginMap, true, false);
                } else if (etLoginPhone.getText().toString().trim().length() != 11 || !VerifyUtils.isMobileNumber(etLoginPhone.getText().toString().trim())) {
                    ToastUtil.showShortToast(getString(R.string.error_phone_num));
                } else if (etLoginPwd.getText().toString().trim().length() < 6 || etLoginPwd.getText().toString().trim().length() > 16) {
                    ToastUtil.showLongToast(getResources().getString(R.string.error_pwd));
                }
                break;
        }
    }

    @Override
    public void resultLogin(LoginBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            SPUtil.put(this, IS_LOGIN, "true");
            SPUtil.put(this, USER_ID, data.getData().getUser().getUserId() + "");
            SPUtil.put(this, STORE_ID, data.getData().getUser().getStoreId() + "");
            SPUtil.put(this, NAME, data.getData().getUser().getUserName());
            SPUtil.put(this, PHONE, data.getData().getUser().getTelPhone());
            SPUtil.put(this, AVATAR, BASE_LOCAL_URL + data.getData().getUser().getAvatar());
            JPushInterface.setAlias(this, JPUSH_SEQUENCE, "jhzc" + data.getData().getUser().getTelPhone());
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
