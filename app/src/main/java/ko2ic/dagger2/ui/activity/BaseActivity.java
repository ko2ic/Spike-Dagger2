package ko2ic.dagger2.ui.activity;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import ko2ic.dagger2.AppApplication;
import ko2ic.dagger2.AppComponent;


public class BaseActivity extends AppCompatActivity {

    protected void init() {
        ButterKnife.bind(this);
    }

    public AppComponent getApplicationComponent() {
        return ((AppApplication) getApplication()).getApplicationComponent();
    }
}
