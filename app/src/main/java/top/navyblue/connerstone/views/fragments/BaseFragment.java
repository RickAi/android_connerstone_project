package top.navyblue.connerstone.views.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import butterknife.Bind;
import butterknife.ButterKnife;
import top.navyblue.connerstone.R;
import top.navyblue.connerstone.utils.Constants;

public class BaseFragment extends Fragment {
    protected Activity mActivity;

    @Bind(R.id.materialViewPager)
    protected MaterialViewPager mMaterialViewPager;

    public static BaseFragment newInstance(String fragmentName) {
        if (fragmentName.equals(Constants.NAVIGATION_BOOK)) {
            return new BookFragment();
        } else if (fragmentName.equals(Constants.NAVIGATION_MOVIE)) {
            return new MovieFragment();
        } else if (fragmentName.equals(Constants.NAVIGATION_PICTURE)) {
            return new PictureFragment();
        } else if (fragmentName.equals(Constants.NAVIGATION_MUSIC)) {
            return new MusicFragment();
        }

        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this, view);

        initListener();
        initAdapter();
        initBars();

        return view;
    }

    private void initBars() {
        // Toolbar
        mOnInitFinishedListener.notifyInitReady(mMaterialViewPager.getToolbar());

        // TODO: status bar transparent
    }

    private void initAdapter() {
        mMaterialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {


            @Override
            public Fragment getItem(int position) {
                return RecyclerViewFragment.newInstance();
            }


            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Selection";
                    case 1:
                        return "Actualités";
                    case 2:
                        return "Professionnel";
                    case 3:
                        return "Divertissement";
                }
                return "";
            }
        });

        mMaterialViewPager.getViewPager().setOffscreenPageLimit(mMaterialViewPager.getViewPager().getAdapter().getCount());
        // Allow title be shown
        mMaterialViewPager.getPagerTitleStrip().setViewPager(mMaterialViewPager.getViewPager());
    }

    private void initListener() {
        mMaterialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "http://cdn1.tnwcdn.com/wp-content/blogs.dir/1/files/2014/06/wallpaper_51.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://fs01.androidpit.info/a/63/0e/android-l-wallpapers-630ea6-h900.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "http://www.droid-life.com/wp-content/uploads/2014/10/lollipop-wallpapers10.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "http://www.tothemobile.com/wp-content/uploads/2014/07/original.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mOnInitFinishedListener = (OnInitFinishedListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mOnInitFinishedListener.notifyInitFinish();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    protected OnInitFinishedListener mOnInitFinishedListener;

    public interface OnInitFinishedListener{
        public void notifyInitReady(Toolbar toolbar);
        public void notifyInitFinish();
    }
}
