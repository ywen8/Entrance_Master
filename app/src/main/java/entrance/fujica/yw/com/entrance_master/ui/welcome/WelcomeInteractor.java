package entrance.fujica.yw.com.entrance_master.ui.welcome;

import entrance.fujica.yw.com.entrance_master.model.CurrentVersion;
import io.reactivex.Observable;


public interface WelcomeInteractor {

    Observable<CurrentVersion> getCurrentVersion();
}
