package com.dscvit.femhelper.network

import com.dscvit.femhelper.model.login.LoginRequest
import com.dscvit.femhelper.model.registernotification.RegisterNotificationRequest
import com.dscvit.femhelper.model.sendalert.SendAlertRequest
import com.dscvit.femhelper.model.signup.SignupRequest

class ApiClient(private val preAuthApi: ApiInterface, private val postAuthApi: ApiInterface) :
    BaseApiClient() {

    suspend fun signUpUser(signupRequest: SignupRequest) = getResult {
        preAuthApi.signUpUser(signupRequest)
    }

    suspend fun signInUser(loginRequest: LoginRequest) = getResult {
        preAuthApi.singInUser(loginRequest)
    }

    suspend fun registerDevice(registerNotificationRequest: RegisterNotificationRequest) =
        getResult {
            postAuthApi.registerDevice(registerNotificationRequest)
        }

    suspend fun updateDeviceDetails(registerNotificationRequest: RegisterNotificationRequest) =
        getResult {
            postAuthApi.updateDeviceDetails(registerNotificationRequest)
        }

    suspend fun sendAlert(sendAlertRequest: SendAlertRequest) = getResult {
        postAuthApi.sendAlert(sendAlertRequest)
    }

    suspend fun logOut() = getResult {
        postAuthApi.logOut()
    }

    suspend fun viewChatRooms() = getResult {
        postAuthApi.viewChatRooms()
    }

    suspend fun getMessages(chatRoomId: Int) = getResult {
        postAuthApi.getMessages(chatRoomId)
    }

    suspend fun getAlerts() = getResult {
        postAuthApi.getAlerts()
    }

}