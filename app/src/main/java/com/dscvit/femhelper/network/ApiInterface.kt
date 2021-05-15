package com.dscvit.femhelper.network

import com.dscvit.femhelper.model.chat.ChatMessagesResponse
import com.dscvit.femhelper.model.chat.ChatRoomResponse
import com.dscvit.femhelper.model.login.LoginRequest
import com.dscvit.femhelper.model.login.LoginResponse
import com.dscvit.femhelper.model.logout.LogOutResponse
import com.dscvit.femhelper.model.registernotification.RegisterNotificationRequest
import com.dscvit.femhelper.model.registernotification.RegisterNotificationResponse
import com.dscvit.femhelper.model.requests.AlertsResponse
import com.dscvit.femhelper.model.sendalert.SendAlertRequest
import com.dscvit.femhelper.model.sendalert.SendAlertResponse
import com.dscvit.femhelper.model.signup.SignupRequest
import com.dscvit.femhelper.model.signup.SignupResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiInterface {

    @POST("signup/")
    suspend fun signUpUser(@Body signupRequest: SignupRequest): Response<SignupResponse>

    @POST("login/")
    suspend fun singInUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("device_register/")
    suspend fun registerDevice(@Body registerNotificationRequest: RegisterNotificationRequest):
            Response<RegisterNotificationResponse>

    @PATCH("device_register/")
    suspend fun updateDeviceDetails(@Body registerNotificationRequest: RegisterNotificationRequest):
            Response<RegisterNotificationResponse>

    @POST("send_alert/")
    suspend fun sendAlert(@Body sendAlertRequest: SendAlertRequest): Response<SendAlertResponse>

    @GET("logout/")
    suspend fun logOut(): Response<LogOutResponse>

    @GET("view_chat_rooms/")
    suspend fun viewChatRooms(): Response<ChatRoomResponse>

    @GET("previous_messages/{chatRoomId}/")
    suspend fun getMessages(@Path("chatRoomId") chatRoomId: Int): Response<ChatMessagesResponse>

    @GET("view_alert/")
    suspend fun getAlerts(): Response<AlertsResponse>

}

