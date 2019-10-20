package com.example.mypokemonapp.models;

public class PokedexItem<T> {

    // primary object
    private T item;

    public PokedexItem(T item) {
        this.item = item;
    }

    public T getObject() {
        return item;
    }

    public void setObject(T item) {
        this.item = item;
    }
}
