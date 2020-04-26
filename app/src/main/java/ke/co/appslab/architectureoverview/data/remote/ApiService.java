package ke.co.appslab.architectureoverview.data.remote;

import android.content.Context;
import android.content.Intent;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ke.co.appslab.architectureoverview.models.CharactersResponse;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface ApiService {

    @GET("character")
    Call<CharactersResponse> fetchAllCharacters();


}
