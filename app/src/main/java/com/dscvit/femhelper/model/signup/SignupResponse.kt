package com.dscvit.femhelper.model.signup


import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("User")
    val user: User
)