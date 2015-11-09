package ko2ic.dagger2.infrastructure;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import ko2ic.dagger2.infrastructure.repository.WeatherRepository;

@Module
public class InfraLayerModule {
    @Provides
    public WeatherRepository provideWeatherRepository(Context context) {
        return new WeatherRepository(context);
    }
}
