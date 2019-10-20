package com.example.mypokemonapp.models;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsItem {

	@Expose
	@SerializedName("name")
	private String name;
	@Expose
	@SerializedName("url")
	private String url;

	protected ResultsItem(Parcel in) {
		name = in.readString();
		url = in.readString();
	}



	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"ResultsItem{" + 
			"name = '" + name + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}

}