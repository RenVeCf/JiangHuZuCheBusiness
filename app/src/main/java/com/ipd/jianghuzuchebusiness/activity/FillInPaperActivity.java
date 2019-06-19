package com.ipd.jianghuzuchebusiness.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuchebusiness.R;
import com.ipd.jianghuzuchebusiness.adapter.VehiclePhotoAdapter;
import com.ipd.jianghuzuchebusiness.base.BaseActivity;
import com.ipd.jianghuzuchebusiness.bean.GetCarCommitBean;
import com.ipd.jianghuzuchebusiness.bean.UploadImgBean;
import com.ipd.jianghuzuchebusiness.bean.VehiclePhotoBean;
import com.ipd.jianghuzuchebusiness.common.view.TopView;
import com.ipd.jianghuzuchebusiness.contract.FillInPaperContract;
import com.ipd.jianghuzuchebusiness.presenter.FillInPaperPresenter;
import com.ipd.jianghuzuchebusiness.utils.ApplicationUtil;
import com.ipd.jianghuzuchebusiness.utils.ToastUtil;
import com.ipd.jianghuzuchebusiness.utils.isClickUtil;
import com.wildma.pictureselector.PictureSelector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_90;
import static com.ipd.jianghuzuchebusiness.common.config.IConstants.REQUEST_CODE_91;

/**
 * Description ：填写取/退车单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/10.
 */
public class FillInPaperActivity extends BaseActivity<FillInPaperContract.View, FillInPaperContract.Presenter> implements FillInPaperContract.View {

    @BindView(R.id.tv_fill_in_car_paper_top)
    TopView tvFillInCarPaperTop;
    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.ll_license_plate_num)
    LinearLayout llLicensePlateNum;
    @BindView(R.id.ll_vehicle_condition)
    LinearLayout llVehicleCondition;
    @BindView(R.id.bt_confirmation_order)
    Button btConfirmationOrder;
    @BindView(R.id.rv_vehicle_photo)
    RecyclerView rvVehiclePhoto;
    @BindView(R.id.tv_car_num)
    TextView tvCarNum;

    private int paperType;
    private String orderId;
    private String licensePlateNum = ""; //车牌号
    private String statusIds = ""; //车辆状况

    private String imgPath;
    private VehiclePhotoAdapter vehiclePhotoAdapter;
    private List<VehiclePhotoBean> list = new ArrayList<>();
    private StringBuffer imgPaths = new StringBuffer();
    //    private PhotoAdapter photoAdapter;
    private ArrayList<String> selectedPhotos = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_fill_in_car_paper;
    }

    @Override
    public FillInPaperContract.Presenter createPresenter() {
        return new FillInPaperPresenter(this);
    }

    @Override
    public FillInPaperContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvFillInCarPaperTop);

        paperType = getIntent().getIntExtra("paper_type", 0);
        orderId = getIntent().getStringExtra("order_id");

        switch (paperType) {
            case 0:
                tvTopTitle.setText("填写取车单");
                break;
            case 1:
                tvTopTitle.setText("填写退车单");
                llLicensePlateNum.setVisibility(View.GONE);
                break;
        }

        //设置RecyclerView方向和是否反转
        GridLayoutManager NotUseList = new GridLayoutManager(this, 4);
        rvVehiclePhoto.setLayoutManager(NotUseList);
        rvVehiclePhoto.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvVehiclePhoto.setItemAnimator(new DefaultItemAnimator()); //默认动画

        //初始化数据
        list.add(getImageData());
        vehiclePhotoAdapter = new VehiclePhotoAdapter(list);
        rvVehiclePhoto.setAdapter(vehiclePhotoAdapter);

//        photoAdapter = new PhotoAdapter(this, selectedPhotos);
    }

    @Override
    public void initListener() {
//        rvVehiclePhoto.addOnItemTouchListener(new RecyclerI);

        vehiclePhotoAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {
                    clickDataBean = list.get(position);
                    switch (view.getId()) {
                        case R.id.iv_household_registration:
                            if (TextUtils.isEmpty(clickDataBean.getName())) {
//                                PhotoPicker.builder()
//                                        .setPhotoCount(9)
//                                        .setShowCamera(false)
//                                        .setPreviewEnabled(false)
//                                        .start(FillInPaperActivity.this);
                                selectPhoto();
                            } else {
                                BigImageActivity.launch(FillInPaperActivity.this, clickDataBean.getName());
                            }
                            break;
                        case R.id.iv_household_registration_del:
                            list.remove(position);
                            vehiclePhotoAdapter.notifyItemRemoved(position);
                            break;
                    }
                }
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
//            if (resultCode == RESULT_OK &&
//                    (requestCode == PhotoPicker.REQUEST_CODE || requestCode == PhotoPreview.REQUEST_CODE)) {
//
//                List<String> photos = null;
//                if (data != null) {
//                    photos = data.getStringArrayListExtra(PhotoPicker.KEY_SELECTED_PHOTOS);
//                }
//                selectedPhotos.clear();
//
//                if (photos != null) {
//
//                    selectedPhotos.addAll(photos);
//                }
//                photoAdapter.notifyDataSetChanged();
//            }

            switch (requestCode) {
                case REQUEST_CODE_90:
                    licensePlateNum = data.getStringExtra("license_plate_num");
                    tvCarNum.setText(licensePlateNum);
                    break;
                case REQUEST_CODE_91:
                    statusIds = data.getStringExtra("status_ids");
                    break;
//                case PictureSelector.SELECT_REQUEST_CODE:
//                    String picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
//                    TreeMap<String, RequestBody> map = new TreeMap<>();
//                    map.put("file\";filename=\"" + ".jpeg", getImageRequestBody(picturePath));
//                    getPresenter().getUploadImg("3", map, true, false);
//                    break;
            }
        }
    }

    public static RequestBody getImageRequestBody(String filePath) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        return RequestBody.create(MediaType.parse(options.outMimeType), new File(filePath));
    }

    private VehiclePhotoBean getImageData() {
        //初始化数据
        VehiclePhotoBean dataBean = new VehiclePhotoBean();
        return dataBean;
    }

    VehiclePhotoBean clickDataBean;

    private void selectPhoto() {
        /**
         * create()方法参数一是上下文，在activity中传activity.this，在fragment中传fragment.this。参数二为请求码，用于结果回调onActivityResult中判断
         * selectPicture()方法参数分别为 是否裁剪、裁剪后图片的宽(单位px)、裁剪后图片的高、宽比例、高比例。都不传则默认为裁剪，宽200，高200，宽高比例为1：1。
         */
        PictureSelector.create(this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(false, 200, 200, 1, 1);
    }

//    private void selectPhoto() {
//        // 进入相册 以下是例子：用不到的api可以不写
//        PictureSelector.create(FillInPaperActivity.this)
//                .openGallery(ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
////                .theme(R.style.picture.white.style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
//                .maxSelectNum(9)// 最大图片选择数量 int
////                .minSelectNum()// 最小选择数量 int
//                .imageSpanCount(4)// 每行显示个数 int
//                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
//                .previewImage(true)// 是否可预览图片 true or false
////                .previewVideo()// 是否可预览视频 true or false
////                .enablePreviewAudio() // 是否可播放音频 true or false
//                .isCamera(true)// 是否显示拍照按钮 true or false
////                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
//                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
//                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
//                .setOutputCameraPath("/CustomPath")// 自定义拍照保存路径,可不填
//                .enableCrop(false)// 是否裁剪 true or false
//                .compress(true)// 是否压缩 true or false
//                .glideOverride(200, 200)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
//                .withAspectRatio(16, 9)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
//                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示 true or false
//                .isGif(false)// 是否显示gif图片 true or false
//                .compressSavePath("/yasuo/CustomPath")//压缩图片保存地址
////                .freeStyleCropEnabled()// 裁剪框是否可拖拽 true or false
//                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
////                .showCropFrame()// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
////                .showCropGrid()// 是否显示裁剪矩形网格 圆形裁剪时建议设为false    true or false
//                .openClickSound(true)// 是否开启点击声音 true or false
////                .selectionMedia()// 是否传入已选图片 List<LocalMedia> list
//                .previewEggs(true)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中) true or false
////                .cropCompressQuality()// 裁剪压缩质量 默认90 int
//                .minimumCompressSize(100)// 小于100kb的图片不压缩
//                .synOrAsy(true)//同步true或异步false 压缩 默认同步
////                .cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效 int
////                .rotateEnabled() // 裁剪是否可旋转图片 true or false
////                .scaleEnabled()// 裁剪是否可放大缩小图片 true or false
////                .videoQuality()// 视频录制质量 0 or 1 int
////                .videoMaxSecond(15)// 显示多少秒以内的视频or音频也可适用 int
////                .videoMinSecond(10)// 显示多少秒以内的视频or音频也可适用 int
////                .recordVideoSecond()//视频秒数录制 默认60s int
////                .isDragFrame(false)// 是否可拖动裁剪框(固定)
//                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
//    }
//
//    @OnClick({R.id.ll_license_plate_num, R.id.ll_vehicle_condition, R.id.bt_confirmation_order})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.ll_license_plate_num:
//                if (isClickUtil.isFastClick()) {
//                    if (!licensePlateNum.equals(""))
//                        startActivityForResult(new Intent(this, LicensePlateNumActivity.class).putExtra("car_num", licensePlateNum), REQUEST_CODE_90);
//                    else
//                        startActivityForResult(new Intent(this, LicensePlateNumActivity.class).putExtra("car_num", ""), REQUEST_CODE_90);
//                }
//                break;
//            case R.id.ll_vehicle_condition:
//                startActivityForResult(new Intent(this, VehicleConditionActivity.class).putExtra("order_id", orderId).putExtra("paper_type", paperType), REQUEST_CODE_91);
//                break;
//            case R.id.bt_confirmation_order:
//                if (isClickUtil.isFastClick()) {
//                    if (list.size() < 4 || list.size() > 10) {
//                        ToastUtil.showShortToast("最小上传图片为3张，最大为9张！");
//                    } else {
//                        switch (paperType) {
//                            case 0:
//                                if (!licensePlateNum.equals("") && !statusIds.equals("")) {
//                                    list.remove(list.size() - 1);
//                                    for (int i = 0; i < list.size(); i++) {
//                                        if (i < list.size() - 1)
//                                            imgPaths.append(list.get(i).getName() + ",");
//                                        else
//                                            imgPaths.append(list.get(i).getName());
//                                    }
//
//                                    TreeMap<String, String> loginMap = new TreeMap<>();
//                                    loginMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
//                                    loginMap.put("orderId", orderId + "");
//                                    loginMap.put("plateNumber", licensePlateNum);
//                                    loginMap.put("statusIds", statusIds);
//                                    loginMap.put("picPath", imgPaths + "");
//                                    loginMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
//                                    getPresenter().getGetCarCommit(loginMap, true, false);
//                                } else
//                                    ToastUtil.showShortToast("请将资料填写完整");
//                                break;
//                            case 1:
//                                if (!statusIds.equals("")) {
//                                    list.remove(list.size() - 1);
//                                    for (int i = 0; i < list.size(); i++) {
//                                        if (i < list.size() - 1)
//                                            imgPaths.append(list.get(i).getName() + ",");
//                                        else
//                                            imgPaths.append(list.get(i).getName());
//                                    }
//
//                                    TreeMap<String, String> returnCarMap = new TreeMap<>();
//                                    returnCarMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
//                                    returnCarMap.put("orderId", orderId + "");
//                                    returnCarMap.put("statusIds", statusIds);
//                                    returnCarMap.put("picPath", imgPaths + "");
//                                    returnCarMap.put("storeId", SPUtil.get(this, STORE_ID, "") + "");
//                                    getPresenter().getReturnCarCommit(returnCarMap, true, false);
//                                } else
//                                    ToastUtil.showShortToast("请将资料填写完整");
//                                break;
//                        }
//                    }
//                }
//                break;
//        }
//    }

    @Override
    public void resultGetCarCommit(GetCarCommitBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            setResult(RESULT_OK, new Intent()
                    .putExtra("get_car_result", "1"));
            finish();
        }
    }

    @Override
    public void resultReturnCarCommit(GetCarCommitBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            setResult(RESULT_OK, new Intent()
                    .putExtra("get_car_result", "1"));
            finish();
        }
    }

    @Override
    public void resultUploadImg(UploadImgBean data) {
        imgPath = data.getData();
        clickDataBean.setName(imgPath);
        list.add(getImageData());
        vehiclePhotoAdapter.notifyDataSetChanged();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
