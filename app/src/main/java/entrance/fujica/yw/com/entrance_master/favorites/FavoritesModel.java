package entrance.fujica.yw.com.entrance_master.favorites;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import entrance.fujica.yw.com.entrance_master.application.AppModel;

@Module(includes = AppModel.class)
public class FavoritesModel {

    @Singleton
    @Provides
    FavoritesIntercator providesFavorites(FavoritesStore store) {
        return new FavoritesIntercatorImpl(store);
    }
}
