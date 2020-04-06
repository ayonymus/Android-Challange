package com.ayon.marvel.data.remote.model

class Thumbnail (val path : String, val extension : String) {

	override fun toString(): String {
		return "$path.$extension"
	}
}