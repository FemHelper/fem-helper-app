package com.dscvit.femhelper.model.sendalert


import com.google.gson.annotations.SerializedName

data class SendAlertResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("Request")
    val request: Request
)