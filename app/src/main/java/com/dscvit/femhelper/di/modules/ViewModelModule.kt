package com.dscvit.femhelper.di.modules

import com.dscvit.femhelper.ui.auth.AuthViewModel
import com.dscvit.femhelper.ui.chat.ChatViewModel
import com.dscvit.femhelper.ui.home.HomeViewModel
import com.dscvit.femhelper.ui.requests.RequestsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AuthViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ChatViewModel(get()) }
    viewModel { RequestsViewModel(get()) }
}