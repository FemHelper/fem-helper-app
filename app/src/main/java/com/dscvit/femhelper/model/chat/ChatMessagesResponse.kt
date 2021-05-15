package com.dscvit.femhelper.model.chat


import com.google.gson.annotations.SerializedName

data class ChatMessagesResponse(
    @SerializedName("Messages")
    val messages: List<Message>
)