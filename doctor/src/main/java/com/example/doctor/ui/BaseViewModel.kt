package com.example.doctor.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    private var _dialog = MutableLiveData<Any>()
    var dialog: LiveData<Any> = _dialog

    private var _showProgress = MutableLiveData<Boolean>()
    var showProgress: LiveData<Boolean> = _showProgress

    fun setProgress(status: Boolean) {
        _showProgress.value = status
    }

    fun setMessageForDialog(message: Any?) {
        _dialog.value = message
    }

}
