package entrance.fujica.yw.com.entrance_master.favorites;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FavoritesStore {

    private static final String PREF_NAME = "Door_Favorites";
    private SharedPreferences pref;

    @Inject
    public FavoritesStore(Context context) {
        pref = context.getApplicationContext().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public void setFavorite() {
        SharedPreferences.Editor editor = pref.edit();
//        editor.putString(movie.getId(), movieJson);
        editor.apply();
    }

}
