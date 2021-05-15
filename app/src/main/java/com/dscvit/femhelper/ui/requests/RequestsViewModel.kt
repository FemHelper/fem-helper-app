package com.dscvit.femhelper.ui.requests

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.femhelper.model.requests.Request
import com.dscvit.femhelper.repository.AppRepository
import kotlinx.coroutines.launch

class RequestsViewModel(private val repo: AppRepository): ViewModel() {

    fun upsertRequest(request: Request) = viewModelScope.launch {
        repo.upsertRequest(request)
    }

    fun deleteRequests() = viewModelScope.launch {
        repo.deleteRequests()
    }

    fun getAlerts() = repo.getAlerts()

    fun requestIsDone(id: Int) = viewModelScope.launch {
        repo.requestIsDone(id)
    }

}