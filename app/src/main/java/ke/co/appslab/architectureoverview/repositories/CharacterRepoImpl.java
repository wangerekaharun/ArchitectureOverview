package ke.co.appslab.architectureoverview.repositories;

import androidx.lifecycle.MutableLiveData;

import ke.co.appslab.architectureoverview.data.datastates.CharactersState;
import ke.co.appslab.architectureoverview.data.remote.ApiClient;
import ke.co.appslab.architectureoverview.data.remote.ApiService;
import ke.co.appslab.architectureoverview.models.CharactersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterRepoImpl implements CharactersRepo {
    public CharacterRepoImpl(){

    }
    private ApiService apiService = new ApiClient().getClient().create(ApiService.class);


    @Override
    public MutableLiveData<CharactersState> fetchAllCharacters() {
        final MutableLiveData<CharactersState> charactersStateMutableLiveData = new MutableLiveData<>();
        Call<CharactersResponse> call = apiService.fetchAllCharacters();
        call.enqueue(new Callback<CharactersResponse>() {
            @Override
            public void onResponse(Call<CharactersResponse> call, Response<CharactersResponse> response) {
                if (response.isSuccessful()){
                    charactersStateMutableLiveData.postValue(new CharactersState(response.body()));
                }
            }

            @Override
            public void onFailure(Call<CharactersResponse> call, Throwable t) {
                charactersStateMutableLiveData.postValue(new CharactersState(t));

            }
        });

        return charactersStateMutableLiveData;
    }
}
