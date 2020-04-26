package ke.co.appslab.architectureoverview.ui.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import ke.co.appslab.architectureoverview.data.datastates.CharactersState;
import ke.co.appslab.architectureoverview.repositories.CharacterRepoImpl;
import ke.co.appslab.architectureoverview.repositories.CharactersRepo;

public class CharactersViewModel extends ViewModel {
    private CharactersRepo charactersRepo = new CharacterRepoImpl();
    public MutableLiveData<CharactersState> charactersStateMutableLiveData = new MutableLiveData<>();


    public void fetchAllCharacters() {
        charactersStateMutableLiveData = (charactersRepo.fetchAllCharacters());
    }
}
