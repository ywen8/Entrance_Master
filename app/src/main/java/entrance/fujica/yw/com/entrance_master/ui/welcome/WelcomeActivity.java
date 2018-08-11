package entrance.fujica.yw.com.entrance_master.ui.welcome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import entrance.fujica.yw.com.entrance_master.R;
import entrance.fujica.yw.com.entrance_master.application.App;
import entrance.fujica.yw.com.entrance_master.view.CustomDialog;


public class WelcomeActivity extends AppCompatActivity implements WelcomeViews {
    @Inject
    WelcomePresenter welcomePresenter;
    @Inject
    CustomDialog customDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).createWelcomeComponent().inject(this);
        welcomePresenter.setView(this);
        welcomePresenter.getAppUpdateInfo();

    }

    @Override
    public void showAppUpdate() {
        customDialog.show();
    }

    @Override
    public void toMain(Class s) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        welcomePresenter.destroy();
    }
}
