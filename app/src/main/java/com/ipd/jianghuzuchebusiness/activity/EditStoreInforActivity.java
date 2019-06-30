package com.ipd.jianghuzuchebusiness.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.ImageSelectGridAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.CaptchaBean;
import com.ipd.jianghuzuchebusiness.bean.ChargeBean;
import com.ipd.jianghuzuchebusiness.bean.StoreInforBean;
import com.ipd.jianghuzuchebusiness.bean.UploadImgBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.EditStoreInforContract;
import com.ipd.jianghuzuchebusiness.presenter.EditStoreInforPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.LogUtils;
import com.ipd.jianghuzuchebusiness.utils.SPUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuchebusiness.activity.FillInPaperActivity.getImageRequestBody;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_93;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_94;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_95;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.STORE_ID;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuchebusiness.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：编辑门店资料
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class EditStoreInforActivity extends BaseActivity<EditStoreInforContract.View, EditStoreInforContract.Presenter> implements EditStoreInforContract.View, ImageSelectGridAdapter.OnAddPicClickListener {

    @BindView(R.id.tv_edit_store_infor_top)
    TopView tvEditStoreInforTop;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.ll_store_name)
    LinearLayout llStoreName;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.ll_store_path)
    LinearLayout llStorePath;
    @BindView(R.id.tv_store_phone)
    TextView tvStorePhone;
    @BindView(R.id.ll_store_phone)
    LinearLayout llStorePhone;
    @BindView(R.id.cb_charge_one)
    CheckBox cbChargeOne;
    @BindView(R.id.cb_charge_two)
    CheckBox cbChargeTwo;
    @BindView(R.id.cb_charge_three)
    CheckBox cbChargeThree;
    @BindView(R.id.ll_charge_service)
    LinearLayout llChargeService;
    @BindView(R.id.rv_edit_store_infor)
    RecyclerView rvEditStoreInfor;
    @BindView(R.id.bt_edit_store_infor)
    Button btEditStoreInfor;

    private StoreInforBean.DataBean.SelectStoreBean selectStoreBean = new StoreInforBean.DataBean.SelectStoreBean();
    private List<ChargeBean.DataBean.ChargeListBean> chargeListBean;
    private StringBuffer imgPaths = new StringBuffer();
    private StringBuffer chargePaths = new StringBuffer();
    private ImageSelectGridAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_store_infor;
    }

    @Override
    public EditStoreInforContract.Presenter createPresenter() {
        return new EditStoreInforPresenter(this);
    }

    @Override
    public EditStoreInforContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvEditStoreInforTop);

        selectStoreBean = getIntent().getParcelableExtra("select_store_bean");
        chargeListBean = getIntent().getParcelableArrayListExtra("charge_list");

        tvStoreName.setText(selectStoreBean.getStoreName());
        tvStorePath.setText(selectStoreBean.getDescAddress());
        tvStorePhone.setText(selectStoreBean.getContactsPhone());
        if (chargeListBean.size() > 0)
            cbChargeOne.setText(chargeListBean.get(0).getTitle());
        if (chargeListBean.size() > 1)
            cbChargeTwo.setText(chargeListBean.get(1).getTitle());
        if (chargeListBean.size() > 2)
            cbChargeThree.setText(chargeListBean.get(2).getTitle());

        String[] chargeId = selectStoreBean.getChargeId().split(",");
        if (chargeId.length < 1 || selectStoreBean.getChargeId().equals("")) {

        } else {
            for (int i = 0; i < chargeId.length; i++) {
                if (chargeListBean.size() > 0)
                    if (chargeId[i].equals(chargeListBean.get(0).getChargeId() + "")) {
                        cbChargeOne.setChecked(true);
                    }
                if (chargeListBean.size() > 1)
                    if (chargeId[i].equals(chargeListBean.get(1).getChargeId() + "")) {
                        cbChargeTwo.setChecked(true);
                    }
                if (chargeListBean.size() > 2)
                    if (chargeId[i].equals(chargeListBean.get(2).getChargeId() + "")) {
                        cbChargeThree.setChecked(true);
                    }
            }
        }

        //设置RecyclerView方向和是否反转
        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvEditStoreInfor.setLayoutManager(NotUseList);
        rvEditStoreInfor.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvEditStoreInfor.setItemAnimator(new DefaultItemAnimator()); //默认动画

        mAdapter = new ImageSelectGridAdapter(this, this);
        //初始化数据
        String[] strs = selectStoreBean.getPicPath().split(",");
        for (int i = 0; i < strs.length; i++) {
            LocalMedia localMedia = new LocalMedia();
            localMedia.setCompressed(true);
            localMedia.setCompressPath(BASE_LOCAL_URL + strs[i].toString());
            mAdapter.setSelectList(localMedia);
        }
        mAdapter.setSelectMax(9);
        rvEditStoreInfor.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {
        mAdapter.setOnItemClickListener(new ImageSelectGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                PictureSelector.create(EditStoreInforActivity.this).themeStyle(R.style.picture_default_style).openExternalPreview(position, mAdapter.mList);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_93:
                    tvStoreName.setText(data.getStringExtra("inputResult"));
                    break;
                case REQUEST_CODE_94:
                    tvStorePath.setText(data.getStringExtra("inputResult"));
                    break;
                case REQUEST_CODE_95:
                    tvStorePhone.setText(data.getStringExtra("inputResult"));
                    break;
                case PictureConfig.CHOOSE_REQUEST:
                    for (int i = 0; i < PictureSelector.obtainMultipleResult(data).size(); i++) {
                        TreeMap<String, RequestBody> map = new TreeMap<>();
                        map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(PictureSelector.obtainMultipleResult(data).get(i).getCompressPath()));
                        getPresenter().getUploadImg("3", map, true, false);
                    }
                    break;
            }
        }
    }

    @Override
    public void resultEditStoreInfor(CaptchaBean data) {
        ToastUtil.showShortToast(data.getMsg());
        startActivity(new Intent(this, StoreInforActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, StoreInforActivity.class));
        finish();
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        LocalMedia localMedia = new LocalMedia();
        localMedia.setCompressed(true);
        localMedia.setCompressPath(BASE_LOCAL_URL + data.getData());
        mAdapter.setSelectList(localMedia);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.ll_store_name, R.id.ll_store_path, R.id.ll_store_phone, R.id.bt_edit_store_infor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_store_name:
                if (isClickUtil.isFastClick()) {
                    startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 0).putExtra("input", selectStoreBean.getStoreName()), REQUEST_CODE_93);
                }
                break;
            case R.id.ll_store_path:
                if (isClickUtil.isFastClick()) {
                    startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 1).putExtra("input", selectStoreBean.getDescAddress()), REQUEST_CODE_94);
                }
                break;
            case R.id.ll_store_phone:
                if (isClickUtil.isFastClick()) {
                    startActivityForResult(new Intent(this, InputActivity.class).putExtra("type", 2).putExtra("input", selectStoreBean.getContactsPhone()), REQUEST_CODE_95);
                }
                break;
            case R.id.bt_edit_store_infor:
                if (isClickUtil.isFastClick()) {
                    if (mAdapter.mList.size() < 3 || mAdapter.mList.size() > 9) {
                        ToastUtil.showShortToast("最小上传图片为3张，最大为9张！");
                    } else {
                        for (int i = 0; i < mAdapter.mList.size(); i++) {
                            if (i < mAdapter.mList.size() - 1)
                                imgPaths.append((mAdapter.mList.get(i).getCompressPath() + ",").replaceAll(BASE_LOCAL_URL, ""));
                            else
                                imgPaths.append((mAdapter.mList.get(i).getCompressPath()).replaceAll(BASE_LOCAL_URL, ""));
                        }

                        List<String> charge = new ArrayList<>();
                        if (cbChargeOne.isChecked())
                            charge.add(chargeListBean.get(0).getChargeId() + "");
                        if (cbChargeTwo.isChecked())
                            charge.add(chargeListBean.get(1).getChargeId() + "");
                        if (cbChargeThree.isChecked())
                            charge.add(chargeListBean.get(2).getChargeId() + "");

                        for (int i = 0; i < charge.size(); i++) {
                            if (i < charge.size() - 1)
                                chargePaths.append(charge.get(i) + ",");
                            else
                                chargePaths.append(charge.get(i));
                        }
                        TreeMap<String, String> returnCarMap = new TreeMap<>();
                        returnCarMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                        returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
                        returnCarMap.put("storeName", tvStoreName.getText().toString().trim());
                        returnCarMap.put("descAddress", tvStorePath.getText().toString().trim());
                        returnCarMap.put("contactsPhone", tvStorePhone.getText().toString().trim());
                        returnCarMap.put("chargeId", chargePaths + "");
                        returnCarMap.put("picPath", imgPaths + "");
                        getPresenter().getEditStoreInfor(returnCarMap, true, false);
                    }
                }
                break;
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onAddPicClick() {
        PictureSelector.create(EditStoreInforActivity.this)
                .openGallery(PictureMimeType.ofImage())
                .maxSelectNum(9)// 最大图片选择数量 int
                .isCamera(true)
                .compress(true)
                .minimumCompressSize(100)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }
}
