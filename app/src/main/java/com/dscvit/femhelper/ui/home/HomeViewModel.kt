package com.dscvit.femhelper.ui.home

import androidx.lifecycle.ViewModel
import com.dscvit.femhelper.model.sendalert.SendAlertRequest
import com.dscvit.femhelper.repository.AppRepository

class HomeViewModel (private val repo: AppRepository) : ViewModel() {

    fun sendAlert(sendAlertRequest: SendAlertRequest) = repo.sendAlert(sendAlertRequest)

    fun logOut() = repo.logOut()

}