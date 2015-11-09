package ko2ic.dagger2;

import android.app.Application;

import ko2ic.dagger2.application.AppLayerModule;
import ko2ic.dagger2.infrastructure.InfraLayerModule;


public class AppApplication extends Application {

    private AppComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).appLayerModule(new AppLayerModule()).infraLayerModule(new InfraLayerModule())
                .build();
    }

    public AppComponent getApplicationComponent() {
        return applicationComponent;
    }


}
