package top.navyblue.connerstone.views.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import top.navyblue.connerstone.R;
import top.navyblue.connerstone.views.fragments.BaseFragment;

public class MainActivity extends NavigationBaseActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolbar();
    }

    private void initToolbar() {
        mToolbar = getToolbar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayUseLogoEnabled(false);
        actionBar.setHomeButtonEnabled(true);
    }


    @Override
    public void onItemClick(int position) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        BaseFragment fragment = BaseFragment.newInstance(mHelpLiveo.get(position).getName(), mToolbar);

        if(fragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
}
