package entrance.fujica.yw.com.entrance_master.service;


import entrance.fujica.yw.com.entrance_master.model.CurrentVersion;
import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiService {

    @GET("/api/server")
    Observable<CurrentVersion> getCurrentVersions();

}
