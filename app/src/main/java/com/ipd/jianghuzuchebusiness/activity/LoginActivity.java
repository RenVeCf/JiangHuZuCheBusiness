package com.ipd.jianghuzuchebusiness.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import com.ipd.jianghuzuchebusiness.utils.BDLocationUtils;
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
    private static final int PERMISSIONS_REQUEST_CODE = 1003;
    //定位相关
    BDLocationUtils bdLocationUtils;

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
        bdLocationUtils = new BDLocationUtils(this);
        bdLocationUtils.doLocation();//开启定位
        bdLocationUtils.mLocationClient.start();//开始定位
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
     * 检查支付宝 SDK 所需的权限，并在必要的时候动态获取。
     * 在 targetSDK = 23 以上，READ_PHONE_STATE 和 WRITE_EXTERNAL_STORAGE 权限需要应用在运行时获取。
     * 如果接入支付宝 SDK 的应用 targetSdk 在 23 以下，可以省略这个步骤。
     */
    private void requestPermission() {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    }, PERMISSIONS_REQUEST_CODE);
        }
    }

    /**
     * 权限获取回调
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                // 用户取消了权限弹窗
                if (grantResults.length == 0) {
                    ToastUtil.showShortToast(getString(R.string.permission_rejected));
                    return;
                }

                // 用户拒绝了某些权限
                for (int x : grantResults) {
                    if (x == PackageManager.PERMISSION_DENIED) {
                        ToastUtil.showShortToast(getString(R.string.permission_rejected));
                        return;
                    }
                }

                // 所需的权限均正常获取
//                ToastUtil.showShortToast(getString(R.string.permission_granted));
                break;
        }
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
