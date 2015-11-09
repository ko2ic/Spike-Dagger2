package ko2ic.dagger2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import ko2ic.dagger2.R;
import ko2ic.dagger2.domain.model.Weather;

public class ThirdActivity extends BaseActivity {

    @Bind(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        init();
        Intent intent = getIntent();
        Weather weather = (Weather)intent.getSerializableExtra("weather");
        textView.setText(weather.title);
    }
}
