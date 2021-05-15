package com.dscvit.femhelper.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dscvit.femhelper.model.chat.ChatRoom
import com.dscvit.femhelper.model.chat.Message
import com.dscvit.femhelper.model.requests.Request

@Database(
    entities = [Message::class, ChatRoom::class, Request::class],
    version = 5,
    exportSchema = false
)
abstract class ChatsDatabase : RoomDatabase() {
    abstract fun chatsDao(): ChatsDao
}