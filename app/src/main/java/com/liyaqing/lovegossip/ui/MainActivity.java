package com.liyaqing.lovegossip.ui;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.liyaqing.lovegossip.R;
import com.liyaqing.lovegossip.ui.base.BaseActivity;
import com.liyaqing.lovegossip.ui.main.ChatFragment;
import com.liyaqing.lovegossip.ui.main.PersonFragment;
import com.liyaqing.lovegossip.ui.main.XhFragment;
import com.liyaqing.lovegossip.ui.main.XzFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.contentContainer)
    FrameLayout contentContainer;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    private BottomBarTab chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        chat = bottomBar.getTabWithId(R.id.tab_chat);
        chat.setBadgeCount(5);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                showFragment(tabId);
                if (tabId==R.id.tab_chat) {
                    chat.setBadgeCount(0);
                }
            }
        });


    }
    private void showFragment(int id) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fm.findFragmentByTag(id + "");
        if (fragment == null) {
            fragment = createFragment(id);
            ft.add(R.id.contentContainer, fragment, id + "");
        }
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f != fragment) {
                    ft.hide(f);
                }
            }
        }
        ft.show(fragment).commit();
    }

    private Fragment createFragment(int id) {
        Fragment fragment = null;
        switch (id) {
            case R.id.tab_xz:
                fragment = new XzFragment();
                break;
            case R.id.tab_xh:
                fragment = new XhFragment();
                break;
            case R.id.tab_chat:
                fragment = new ChatFragment();
                break;
            case R.id.tab_person:
                fragment = new PersonFragment();
                break;
        }
        return fragment;
    }
}
