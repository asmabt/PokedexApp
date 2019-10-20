package com.example.mypokemonapp.di;

import com.example.mypokemonapp.home.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {PokedexModule.class})

public interface PokedexComponent {

    void inject(MainActivity activity);
}
