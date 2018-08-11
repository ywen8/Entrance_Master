package entrance.fujica.yw.com.entrance_master.ui.welcome;

import android.util.Log;

import entrance.fujica.yw.com.entrance_master.model.CurrentVersion;
import entrance.fujica.yw.com.entrance_master.utils.RxUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WelcomePresenterImpl implements WelcomePresenter {
    private WelcomeInteractor welcomeInteractor;
    private WelcomeViews welcomeViews;
    private Disposable versionSubscription;


    public WelcomePresenterImpl(WelcomeInteractor welcomeInteractor) {
        this.welcomeInteractor = welcomeInteractor;
    }

    @Override
    public void getAppUpdateInfo() {
        versionSubscription = welcomeInteractor.getCurrentVersion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onGetVersionSuccess, t -> onGetVersionFailure());
    }

    private void onGetVersionSuccess(CurrentVersion currentVersion) {
        welcomeViews.showAppUpdate();
    }

    private void onGetVersionFailure() {
        welcomeViews.showAppUpdate();
        Log.i(this.getClass().getName(), "|-------访问出错!---------|");
    }

    @Override
    public void setView(WelcomeViews welcomeViews) {
        this.welcomeViews = welcomeViews;
    }

    @Override
    public void destroy() {
        welcomeViews = null;
        RxUtils.unsubscribe(versionSubscription);
    }


}
