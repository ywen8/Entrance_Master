package entrance.fujica.yw.com.entrance_master.application;

import javax.inject.Singleton;

import dagger.Component;
import entrance.fujica.yw.com.entrance_master.custom.CustomModel;
import entrance.fujica.yw.com.entrance_master.favorites.FavoritesModel;
import entrance.fujica.yw.com.entrance_master.http.HttpModel;
import entrance.fujica.yw.com.entrance_master.ui.welcome.WelcomeComponent;
import entrance.fujica.yw.com.entrance_master.ui.welcome.WelcomeModel;


@Singleton
@Component(modules = {AppModel.class, HttpModel.class, FavoritesModel.class, CustomModel.class})
public interface AppComponent {

    WelcomeComponent push(WelcomeModel welcomeModel);

}
