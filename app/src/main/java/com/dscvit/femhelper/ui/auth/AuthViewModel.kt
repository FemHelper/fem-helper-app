package com.dscvit.femhelper.ui.auth

import androidx.lifecycle.ViewModel
import com.dscvit.femhelper.model.login.LoginRequest
import com.dscvit.femhelper.model.registernotification.RegisterNotificationRequest
import com.dscvit.femhelper.model.signup.SignupRequest
import com.dscvit.femhelper.repository.AppRepository

class AuthViewModel(private val repo: AppRepository) : ViewModel() {

    fun signUpUser(signupRequest: SignupRequest) = repo.signUpUser(signupRequest)

    fun signInUser(loginRequest: LoginRequest) = repo.signInUser(loginRequest)

    fun registerDevice(registerNotificationRequest: RegisterNotificationRequest) =
        repo.registerDevice(registerNotificationRequest)

    fun updateDeviceDetails(registerNotificationRequest: RegisterNotificationRequest) =
        repo.updateDeviceDetails(registerNotificationRequest)

}