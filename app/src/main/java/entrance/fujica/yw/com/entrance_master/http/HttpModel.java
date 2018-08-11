package entrance.fujica.yw.com.entrance_master.http;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import entrance.fujica.yw.com.entrance_master.service.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
public class HttpModel {
    public static final int CONNECT_TIMEOUT_IN_MS = 3000;

    @Singleton
    @Provides
    public OkHttpClient providesOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().
                connectTimeout(CONNECT_TIMEOUT_IN_MS, TimeUnit.MILLISECONDS).
                addInterceptor(httpLoggingInterceptor).
                build();
    }

    @Singleton
    @Provides
    public Retrofit providesRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder().baseUrl("http://api.themoviedb.org/").
                addConverterFactory(MoshiConverterFactory.create()).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                client(okHttpClient).build();
    }

    @Singleton
    @Provides
    public ApiService providesApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    
}
