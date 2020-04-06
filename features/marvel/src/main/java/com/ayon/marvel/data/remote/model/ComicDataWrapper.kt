package com.ayon.marvel.data.remote.model


data class ComicDataWrapper (
	val code : String,
	val status : String,
	val copyright : String,
	val attributionText : String,
	val attributionHTML : String,
	val data : Data,
	val etag : String
)