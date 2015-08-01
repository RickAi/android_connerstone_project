package top.navyblue.connerstone.views.activites;

import android.os.Bundle;
import android.view.Menu;

import br.liveo.Model.HelpLiveo;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class NavigationBaseActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo mHelpLiveo;

    @Override
    public void onInt(Bundle bundle) {
        mHelpLiveo = new HelpLiveo();
        mHelpLiveo.add("trial");
        mHelpLiveo.add("trial");
        mHelpLiveo.add("trial");
        mHelpLiveo.add("trial");
        mHelpLiveo.addSeparator();
        mHelpLiveo.add("trial");
        mHelpLiveo.add("trial");
        mHelpLiveo.add("trial");

        with(this) // default theme is dark
                .startingPosition(2) //Starting position in the list
                .addAllHelpItem(mHelpLiveo.getHelp())
                .setOnPrepareOptionsMenu(onPrepare)
                .build();
    }

    @Override
    public void onItemClick(int i) {

    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };
}
