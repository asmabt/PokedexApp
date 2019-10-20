package com.example.mypokemonapp.home;

import com.example.mypokemonapp.common.pokedexBase.PokedexBaseView;
import com.example.mypokemonapp.models.ResultsItem;

import java.util.ArrayList;
import java.util.List;

public interface HomeView extends PokedexBaseView {

    void getPokemonList(List<ResultsItem> PokemonList);
    void showError();
}
