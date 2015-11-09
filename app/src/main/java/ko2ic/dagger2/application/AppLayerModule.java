package ko2ic.dagger2.application;

import dagger.Module;
import dagger.Provides;
import ko2ic.dagger2.application.facade.WeatherFacade;
import ko2ic.dagger2.infrastructure.repository.WeatherRepository;

@Module
public class AppLayerModule {
    @Provides
    public WeatherFacade provideWeatherFacade(WeatherRepository repository) {
        return new WeatherFacade(repository);
    }
}
