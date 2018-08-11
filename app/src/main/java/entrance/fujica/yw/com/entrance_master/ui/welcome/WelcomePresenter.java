package entrance.fujica.yw.com.entrance_master.ui.welcome;

public interface WelcomePresenter {

    void getAppUpdateInfo();

    void setView(WelcomeViews welcomeViews);

    void destroy();
}
