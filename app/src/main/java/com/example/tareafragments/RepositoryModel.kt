package com.example.tareafragments
import android.media.Image
import com.google.gson.annotations.SerializedName

class RepositoryModel (
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("images")
    val images: List<Image>
)