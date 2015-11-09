package ko2ic.dagger2.application.facade;


import javax.inject.Inject;

import ko2ic.dagger2.infrastructure.repository.WeatherRepository;


public class WeatherFacade {

    private WeatherRepository repository;

    @Inject
    public WeatherFacade(WeatherRepository repository){
        this.repository = repository;
    }

    public void fetchWeahter(String cityCode){
        repository.fetchWeather(cityCode);
    }
}
