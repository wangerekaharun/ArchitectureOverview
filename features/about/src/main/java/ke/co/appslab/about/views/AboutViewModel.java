package ke.co.appslab.about.views;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ke.co.appslab.core.models.User;
import ke.co.appslab.repository.UsersRepo;

public class AboutViewModel extends ViewModel {
    MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    public void getUser(){
        UsersRepo usersRepo = new UsersRepo();
        User user = usersRepo.getUser();
        userMutableLiveData.postValue(user);
    }
}
