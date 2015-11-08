package ko2ic.dagger2.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import ko2ic.dagger2.R;
import ko2ic.dagger2.application.facade.WeatherFacade;
import ko2ic.dagger2.infrastructure.repository.WeatherRepository;
import ko2ic.dagger2.infrastructure.repository.event.common.RuntimeExceptionEvent;

public class SecondActivity extends AppCompatActivity {

    @Inject
    WeatherFacade facade;

    @Bind(R.id.editText)
    EditText editText;

    @Bind(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facade.fetchWeahter(editText.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    public void onEvent(WeatherRepository.WeatherEventSuccess event){
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        intent.putExtra("weather", event.getWeather());
        startActivity(intent);
    }

    public void onEvent(WeatherRepository.WeatherEventFailure event){
        Toast toast = Toast.makeText(this, String.format("Http Status Code is %s .", event.getStatusCode()), Toast.LENGTH_LONG);
        toast.show();
    }

    public void onEvent(RuntimeExceptionEvent event){
        Log.e("Spike-Dagger2", "program exception", event.getThrowable());
    }
}
