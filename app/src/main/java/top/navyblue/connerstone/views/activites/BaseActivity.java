package top.navyblue.connerstone.views.activites;

import android.app.Activity;
import android.os.Bundle;

import top.navyblue.connerstone.R;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

}
