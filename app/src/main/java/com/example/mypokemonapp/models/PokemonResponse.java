package com.example.mypokemonapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class PokemonResponse {

	@Expose
	@SerializedName("results")
	private List<ResultsItem> results;


	protected PokemonResponse(Parcel in) {
	}



	public void setResults(List<ResultsItem> results){
		this.results = results;
	}

	public List<ResultsItem> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"PokemonResponse{" +
			",results = '" + results + '\'' + 
			"}";
		}

}