package e.sergeev.oleg.apparchitecture;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

/**
 * Created by o.sergeev on 18.07.2018.
 */

public class UserProfileViewModel extends ViewModel {
    private String userId;
    private LiveData<User> user;
    private UserRepository userRepo;


    @Inject //UserRepository parameter is provided by Dagger 2
    public UserProfileViewModel(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    public void init(String userId){
        if (this.user != null){
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        this.userId = userId;
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser(){
        return this.user;
    }

    public class User{
        public String name = "Oleg";
        public String lastName = "Sergeev";
    }
}
