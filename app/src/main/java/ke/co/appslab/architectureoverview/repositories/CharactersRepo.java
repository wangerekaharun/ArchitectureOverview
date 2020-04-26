package ke.co.appslab.architectureoverview.repositories;

import androidx.lifecycle.MutableLiveData;

import ke.co.appslab.architectureoverview.data.datastates.CharactersState;
import ke.co.appslab.architectureoverview.data.remote.ApiClient;
import ke.co.appslab.architectureoverview.data.remote.ApiService;
import ke.co.appslab.architectureoverview.models.CharactersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface CharactersRepo {
    MutableLiveData<CharactersState> fetchAllCharacters();
}
