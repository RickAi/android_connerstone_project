package top.navyblue.connerstone.views.activites;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import top.navyblue.connerstone.R;
import top.navyblue.connerstone.views.fragments.BaseFragment;

public class MainActivity extends NavigationBaseActivity implements BaseFragment.OnInitFinishedListener {

    private Toolbar mSystemToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBars();
    }

    private void initBars() {
        // Init Toolbar
        mSystemToolbar = getToolbar();

        // TODO: status bar transparent
    }


    @Override
    public void onItemClick(int position) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        BaseFragment fragment = BaseFragment.newInstance(mHelpLiveo.get(position).getName());

        if(fragment != null){
            mFragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }

    @Override
    public void notifyInitReady(Toolbar toolbar) {
        if(toolbar != null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);

            // system toolbar should gone
            mSystemToolbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void notifyInitFinish() {
        mSystemToolbar.setVisibility(View.VISIBLE);
    }

}
