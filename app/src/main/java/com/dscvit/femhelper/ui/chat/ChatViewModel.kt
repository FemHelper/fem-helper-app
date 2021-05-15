package com.dscvit.femhelper.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.femhelper.model.chat.Message
import com.dscvit.femhelper.repository.AppRepository
import kotlinx.coroutines.launch

class ChatViewModel(private val repo: AppRepository): ViewModel() {

    fun viewChatRooms() = repo.viewChatRooms()

    fun getMessages(chatRoomId: Int) = repo.getMessages(chatRoomId)

    suspend fun deleteChatRooms() = repo.deleteChatRooms()

    suspend fun deleteMessages() = repo.deleteMessages()

    fun insertMessage(message: Message) = viewModelScope.launch {
        repo.insertMessage(message)
    }

}