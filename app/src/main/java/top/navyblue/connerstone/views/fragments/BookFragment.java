package top.navyblue.connerstone.views.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends BaseFragment {

    protected Toolbar mToolbar;

    public BookFragment(Toolbar toolbar) {
        mToolbar = toolbar;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected Toolbar getToolbar() {
        return mToolbar;
    }
}
