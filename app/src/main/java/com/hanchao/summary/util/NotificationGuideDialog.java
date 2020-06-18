//package com.hanchao.summary.util;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.os.Build;
//import android.provider.Settings;
//import android.support.annotation.NonNull;
//import android.support.v4.app.NotificationManagerCompat;
//import android.view.View;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import com.hanchao.summary.R;
//import com.inshot.screenrecorder.R;
//
///**
// * @author fxYan
// */
//public class NotificationGuideDialog extends Dialog implements View.OnClickListener{
//
//    private Context mContext;
//    private View mBtn;
//    private TextView mDescTv, mDesc2Tv;
//
//    public static boolean hasNotificationPermission(Context context) {
//        if (context != null) {
//            return NotificationManagerCompat.from(context).areNotificationsEnabled();
//        }
//        return true;
//    }
//
//    public NotificationGuideDialog(@NonNull Context context) {
//        super(context, R.style.custom_dialog);
////        mContext = context;
////        setContentView(R.layout.dialog_notification_guide);
////
////        mDescTv = findViewById(R.id.desc);
////        mDesc2Tv = findViewById(R.id.desc2);
////        mBtn = findViewById(R.id.btn);
////
////        mBtn.setOnClickListener(this);
////        mDescTv.setText(mContext.getString(R.string.notification_permission_desc, mContext.getString(R.string.app_name)));
////        mDesc2Tv.setText(new StringBuilder().append(mContext.getString(R.string.open_settings_0)).append("\n")
////                .append(mContext.getString(R.string.open_notification)).toString());
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn:
////                PermissionUtils.openSettings(mContext);
//                enterSettingPage();
//                dismiss();
//                break;
//        }
//    }
//
//    private void enterSettingPage() {
//        Intent intent = new Intent(Settings.ACTION_SETTINGS);
//        if (Build.VERSION.SDK_INT > 26) {
//            intent.setAction(Settings.ACTION_APP_NOTIFICATION_SETTINGS);
//            intent.putExtra(Settings.EXTRA_APP_PACKAGE, mContext.getPackageName());
//            intent.putExtra(Settings.EXTRA_CHANNEL_ID, mContext.getApplicationInfo().uid);
//        } else {
//            intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//            intent.setData(Uri.fromParts("package", mContext.getPackageName(), null));
//        }
//        try {
//            mContext.startActivity(intent);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
