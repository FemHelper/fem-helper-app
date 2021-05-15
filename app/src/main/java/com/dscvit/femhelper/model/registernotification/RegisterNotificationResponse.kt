package com.dscvit.femhelper.model.registernotification


import com.google.gson.annotations.SerializedName

data class RegisterNotificationResponse(
    @SerializedName("device_details")
    val deviceDetails: DeviceDetails,
    @SerializedName("message")
    val message: String
)