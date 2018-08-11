package entrance.fujica.yw.com.entrance_master.ui.welcome;

import dagger.Module;
import dagger.Provides;
import entrance.fujica.yw.com.entrance_master.service.ApiService;

@Module
public class WelcomeModel {
    @Provides
    @WelcomeScope
    WelcomeInteractor providesWelcomeInteractor(ApiService apiService) {
        return new WelcomeInteractorImpl(apiService);
    }

    @Provides
    @WelcomeScope
    WelcomePresenter  providesWelcomePresenter(WelcomeInteractor  welcomeInteractor){
        return  new WelcomePresenterImpl(welcomeInteractor);
    }

}
