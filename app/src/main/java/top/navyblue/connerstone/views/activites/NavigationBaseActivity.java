package top.navyblue.connerstone.views.activites;

import android.os.Bundle;
import android.view.Menu;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;
import top.navyblue.connerstone.utils.Constants;

public abstract class NavigationBaseActivity extends NavigationLiveo implements OnItemClickListener {
    protected HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle bundle) {
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add(Constants.NAVIGATION_BOOK);
        mHelpLiveo.addSeparator();
        mHelpLiveo.add(Constants.NAVIGATION_MOVIE);
        mHelpLiveo.addSeparator();
        mHelpLiveo.add(Constants.NAVIGATION_PICTURE);
        mHelpLiveo.addSeparator();
        mHelpLiveo.add(Constants.NAVIGATION_MUSIC);

        with(this) // default theme is dark
                .startingPosition(1)
                .addAllHelpItem(mHelpLiveo.getHelp())
                .setOnPrepareOptionsMenu(onPrepare)
                .build();
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {

        }
    };
}
