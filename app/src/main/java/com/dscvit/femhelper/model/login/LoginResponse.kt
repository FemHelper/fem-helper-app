package com.dscvit.femhelper.model.login


import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("User")
    val user: User
)