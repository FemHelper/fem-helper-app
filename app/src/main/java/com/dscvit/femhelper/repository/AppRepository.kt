package com.dscvit.femhelper.repository

import com.dscvit.femhelper.db.ChatsDao
import com.dscvit.femhelper.model.chat.Message
import com.dscvit.femhelper.model.login.LoginRequest
import com.dscvit.femhelper.model.registernotification.RegisterNotificationRequest
import com.dscvit.femhelper.model.requests.Request
import com.dscvit.femhelper.model.sendalert.SendAlertRequest
import com.dscvit.femhelper.model.signup.SignupRequest
import com.dscvit.femhelper.network.ApiClient

class AppRepository(private val apiClient: ApiClient, private val chatsDao: ChatsDao) : BaseRepo() {
    fun signUpUser(signupRequest: SignupRequest) = makeRequest {
        apiClient.signUpUser(signupRequest)
    }

    fun signInUser(loginRequest: LoginRequest) = makeRequest {
        apiClient.signInUser(loginRequest)
    }

    fun registerDevice(registerNotificationRequest: RegisterNotificationRequest) = makeRequest {
        apiClient.registerDevice(registerNotificationRequest)
    }

    fun updateDeviceDetails(registerNotificationRequest: RegisterNotificationRequest) =
        makeRequest {
            apiClient.updateDeviceDetails(registerNotificationRequest)
        }

    fun sendAlert(sendAlertRequest: SendAlertRequest) = makeRequest {
        apiClient.sendAlert(sendAlertRequest)
    }

    fun logOut() = makeRequest {
        apiClient.logOut()
    }

    fun getAlerts() = makeRequest {
        apiClient.getAlerts()
    }

    fun viewChatRooms() = makeRequestAndSave (
        databaseQuery = { chatsDao.getAllChatRooms() },
        networkCall = { apiClient.viewChatRooms() },
        saveCallResult = { chatsDao.insertChatRooms(it.chatRooms) }
    )

    fun getMessages(chatRoomId: Int) = makeRequestAndSave(
        databaseQuery = { chatsDao.loadMessagesByChatRoomId(chatRoomId) },
        networkCall = { apiClient.getMessages(chatRoomId) },
        saveCallResult = { chatsDao.insertMessages(it.messages) }
    )

    fun getAllRequests() = chatsDao.getAllRequests()

    suspend fun insertMessage(message: Message) = chatsDao.insertMessage(message)

    suspend fun upsertRequest(request: Request) = chatsDao.upsertRequest(request)

    suspend fun requestIsDone(id: Int) = chatsDao.requestIsDone(id)

    suspend fun deleteChatRooms() = chatsDao.deleteChatRooms()

    suspend fun deleteMessages() = chatsDao.deleteMessages()

    suspend fun deleteRequests() = chatsDao.deleteRequests()

}