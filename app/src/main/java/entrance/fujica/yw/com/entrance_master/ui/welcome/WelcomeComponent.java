package entrance.fujica.yw.com.entrance_master.ui.welcome;


import dagger.Subcomponent;

@WelcomeScope
@Subcomponent(modules = WelcomeModel.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity welcomeActivity);
}
