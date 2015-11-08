package ko2ic.dagger2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ko2ic.dagger2.R;
import ko2ic.dagger2.domain.model.Weather;

public class ThirdActivity extends AppCompatActivity {

    @Bind(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Weather weather = (Weather)intent.getSerializableExtra("weather");
        textView.setText(weather.title);
    }
}
