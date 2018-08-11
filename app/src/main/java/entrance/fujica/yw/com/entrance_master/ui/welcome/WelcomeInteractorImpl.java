package entrance.fujica.yw.com.entrance_master.ui.welcome;

import entrance.fujica.yw.com.entrance_master.model.CurrentVersion;
import entrance.fujica.yw.com.entrance_master.service.ApiService;
import io.reactivex.Observable;

public class WelcomeInteractorImpl implements WelcomeInteractor {
    private ApiService apiService;

    public WelcomeInteractorImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Observable<CurrentVersion> getCurrentVersion() {
        return apiService.getCurrentVersions();
    }
}
