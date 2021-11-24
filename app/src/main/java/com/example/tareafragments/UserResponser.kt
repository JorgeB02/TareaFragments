package com.example.tareafragments

import com.google.gson.annotations.SerializedName

data class ResultResponse(
    @SerializedName("results")
    val users: List <UserResponse>
)

data class UserResponse (
    val email: String,
    val name: FullNameResponse,
    val picture: PictureResponse,
    val location: LocationResponse
)

data class FullNameResponse(
    val title: String,
    val first: String,
    val last: String
)

data class LocationResponse(
    @SerializedName("country")
    val country:String
)
data class PictureResponse(
    val large: String,
    @SerializedName("medium")
    val medium: String,
    val thumbail: String
)

