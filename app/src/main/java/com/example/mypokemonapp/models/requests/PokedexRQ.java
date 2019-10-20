package com.example.mypokemonapp.models.requests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokedexRQ {

    @Expose
    @SerializedName("limit")
    int limit;

    @Expose
    @SerializedName("offset")
    int offset;

    public PokedexRQ() {
        this.limit = 20;
        this.offset = 0;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
