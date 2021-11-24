package com.example.tareafragments

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String? = null
)


fun UserResponse.toUser(): User{
    return User(
        this.email,
        this.name.first,
        this.name.last,
        this.picture.medium
    )
}

fun List<UserResponse>.toUser(): List<User>{
    return this.map{it.toUser()}
}
