package entrance.fujica.yw.com.entrance_master.application;

import android.app.Application;
import android.os.StrictMode;

import entrance.fujica.yw.com.entrance_master.custom.CustomModel;
import entrance.fujica.yw.com.entrance_master.favorites.FavoritesModel;
import entrance.fujica.yw.com.entrance_master.http.HttpModel;
import entrance.fujica.yw.com.entrance_master.ui.welcome.WelcomeComponent;
import entrance.fujica.yw.com.entrance_master.ui.welcome.WelcomeModel;


public class App extends Application {
    private AppComponent appComponent;
    private WelcomeComponent welcomeComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        StrictMode.enableDefaults();
        appComponent = createAppComponent();
    }

    private AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
                .appModel(new AppModel(this))
                .httpModel(new HttpModel())
                .favoritesModel(new FavoritesModel())
                .customModel(new CustomModel())
                .build();
    }

    public WelcomeComponent createWelcomeComponent() {
        welcomeComponent = appComponent.push(new WelcomeModel());
        return welcomeComponent;
    }

    public void releaseWelcomeComponent() {
        welcomeComponent = null;
    }

}
