package com.example.mypokemonapp.common.network;

import com.example.mypokemonapp.BuildConfig;
import com.example.mypokemonapp.home.PokedexApp;
import com.example.mypokemonapp.models.PokemonResponse;
import com.example.mypokemonapp.models.requests.PokedexRQ;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {

    private static ApiManager instance;
    private OkHttpClient client;
    private Gson gson;
    private ApiInterface apiInterface ;

    private ApiManager(){
    }

    public static  ApiManager getInstance(){
        if(instance == null) {
            instance = new ApiManager();
        }
        return instance ;
    }


    /**
     * Build the http client
     */
    public void buildHttpClient() {

        //final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //setupRetrofitAPI(client, BuildConfig.BASE_URL);
    }

    /**
     * Create Retrofit API
     */
    public void setupRetrofitAPI(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                //.client(okHttpClient)
                .build();
        instance.apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    /**
     * GSON converter
     *
     * @return converter
     */
    public Gson getGson() {
        if (gson == null) {
            gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation() // Non annotated with #expose will be excluded
                    .disableHtmlEscaping()
                    .setLenient()
                    .setDateFormat("dd-MMM-yyy")
                    .create();
        }

        return gson;
    }


    public Call<PokemonResponse> getPokemonRS(PokedexRQ request) {
        return this.apiInterface.getPokemonRS(request.getLimit(), request.getOffset());

    }
}
