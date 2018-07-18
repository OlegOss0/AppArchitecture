package e.sergeev.oleg.apparchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by o.sergeev on 18.07.2018.
 */

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;

    public void init(String userId){
        this.userId = userId;
    }

    public LiveData<User> getUser(){
        return user;
    }

    public class User{
        public String name = "Oleg";
        public String lastName = "Ыergeev";
    }
}
