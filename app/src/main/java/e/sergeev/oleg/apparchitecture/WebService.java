package e.sergeev.oleg.apparchitecture;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by o.sergeev on 24.07.2018.
 */

public interface WebService{
    /**
     * @GET declares an HTTP GET request
     * @Path("user") annotation on the userId parameter marks it as a
     * replacement for the {user} placeholder in the @GET path
     */
    @GET("/user/{user}")
    Call<UserProfileViewModel.User> getUser(@Path("user") String userId);
}
