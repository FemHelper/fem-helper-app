package com.dscvit.femhelper.di.modules

import com.dscvit.femhelper.websocket.ChatWsListener
import org.koin.dsl.module

val wsModule = module {
    factory { ChatWsListener(get(), get()) }
}