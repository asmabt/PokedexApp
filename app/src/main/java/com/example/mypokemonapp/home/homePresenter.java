package com.example.mypokemonapp.home;

import android.util.Log;

import com.example.mypokemonapp.common.pokedexBase.PokedexBasePresenter;
import com.example.mypokemonapp.models.PokemonResponse;
import com.example.mypokemonapp.models.ResultsItem;
import com.example.mypokemonapp.common.network.ApiManager;
import com.example.mypokemonapp.models.requests.PokedexRQ;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class homePresenter extends PokedexBasePresenter<HomeView> {

    private static  final int POKEMON_RS = 100 ;
    List<ResultsItem> ListPokemons = new ArrayList<>();
    private static homePresenter instance;




    public homePresenter() {
    }

    public static homePresenter getInstance() {
        if (instance == null) {
            instance = new homePresenter();
        }
        return instance;
    }

    void getPokemonData(PokedexRQ request){

        request.setOffset(request.getOffset());

        ApiManager.getInstance().getPokemonRS(request).enqueue(new Callback<PokemonResponse>() {

            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {

                if (response.isSuccessful() && response.body() != null) {
                    PokemonResponse results = response.body();
                    if(results != null && results.getResults().size()>0){
                        for(ResultsItem item : results.getResults()){
                            ListPokemons.add(item);
                        }
                        view.getPokemonList(ListPokemons);
                    }
                    else if(view!=null){
                        view.showError();
                    }

                }

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {

                if (!call.isCanceled()) {
                    if (view != null) {
                        view.showError();
                    }
                }
            }
        });
    }



}
