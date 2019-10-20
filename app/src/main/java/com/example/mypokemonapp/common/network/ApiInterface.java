package com.example.mypokemonapp.common.network;

import com.example.mypokemonapp.Utils.Constants;
import com.example.mypokemonapp.models.PokemonResponse;
import com.example.mypokemonapp.models.requests.PokedexRQ;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET(Constants.POKEMON_URL )
    Call<PokemonResponse> getPokemonRS(@Query("limit") int limit,@Query("offset") int Offset);

}
