package com.liyaqing.lovegossip.ui.base;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.liyaqing.lovegossip.R;
import com.liyaqing.lovegossip.util.LogUtil;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by liyaqing on 2017/3/8.
 */

public class BaseActivity extends AppCompatActivity {
    protected String TAG = this.getClass().getSimpleName();
    protected CompositeSubscription mSubscriptions = new CompositeSubscription();

//    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Icepick.restoreInstanceState(this, savedInstanceState);
        LogUtil.i(TAG + "------" + "onCreate");
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSubscriptions.clear();
        LogUtil.i(TAG + "------" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.i(TAG + "------" + "onDestroy");
    }

    @Override
    protected void onPause() {
//        if (progressDialog != null && progressDialog.isShowing()){
//            progressDialog.dismiss();
//        }
        super.onPause();
        LogUtil.i(TAG + "------" + "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.i(TAG + "------" + "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.i(TAG + "------" + "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.i(TAG + "------" + "onRestart");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.i(TAG + "------" + "onRestoreInstanceState");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        LogUtil.i(TAG + "------" + "onSaveInstanceState");
    }

    /**
     * 跳转到另一个activity
     * @param clazz
     */
    protected void gotoActivity(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 跳转到另一个activity，附带动画效果
     * @param clazz
     */
    protected void gotoActivityWithAnim(Class clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        overridePendingTransition(R.anim.activity_or_fragment_enter, R.anim.activity_or_fragment_exit);
    }
    /**
     * 跳转到另一个activity，附带动画效果
     */
    protected void gotoActivityWithAnim(Intent intent){
        startActivity(intent);
        overridePendingTransition(R.anim.activity_or_fragment_enter, R.anim.activity_or_fragment_exit);
    }
    /**
     * 跳转到另一个activity，附带动画效果
     */
    protected void gotoActivitiesWithAnim(Intent[] intents){
        startActivities(intents);
        overridePendingTransition(R.anim.activity_or_fragment_enter, R.anim.activity_or_fragment_exit);
    }
    /**
     * 跳转到另一个activity，附带动画效果
     */
    protected void startActivityForResultWithAnim(Intent intent, int requestCode){
        startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.activity_or_fragment_enter, R.anim.activity_or_fragment_exit);
    }

    /**
     * 结束，附带动画效果
     */
    protected void finishWithAnim(){
        finish();
        if (animOnFinish()){
            overridePendingTransition(R.anim.activity_or_fragment_pop_enter, R.anim.activity_or_fragment_pop_exit);
        }
    }

    private boolean animOnFinish() {
        return true;
    }
}
