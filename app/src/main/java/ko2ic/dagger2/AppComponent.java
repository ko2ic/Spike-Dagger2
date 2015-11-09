package ko2ic.dagger2;

import javax.inject.Singleton;

import dagger.Component;
import ko2ic.dagger2.application.AppLayerModule;
import ko2ic.dagger2.infrastructure.InfraLayerModule;
import ko2ic.dagger2.ui.activity.SecondActivity;

@Singleton
@Component(modules = {InfraLayerModule.class, AppLayerModule.class, AppModule.class})
public interface AppComponent {
    void inject(SecondActivity activity);
}
