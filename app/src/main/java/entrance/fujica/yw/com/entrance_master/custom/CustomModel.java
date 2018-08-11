package entrance.fujica.yw.com.entrance_master.custom;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import entrance.fujica.yw.com.entrance_master.application.AppModel;
import entrance.fujica.yw.com.entrance_master.view.CustomDialog;

@Module(includes = AppModel.class)
public class CustomModel {

    @Singleton
    @Provides
    public CustomDialog providesCustomDialog(Context context) {
        return new CustomDialog(context);
    }
}
