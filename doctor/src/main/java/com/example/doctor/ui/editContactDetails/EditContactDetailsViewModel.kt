package com.example.doctor.ui.editContactDetails

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.util.EDIT_CONTACT_EMAIL
import com.example.doctor.ui.util.EDIT_CONTACT_PHONE_NUMBER

class EditContactDetailsViewModel : BaseViewModel() {

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _emailId = MutableLiveData<String>()
    val emailId: LiveData<String> = _emailId


    fun setData(arguments: Bundle?) {
        _phoneNumber.value = (arguments?.getString(EDIT_CONTACT_PHONE_NUMBER))
        _emailId.value = (arguments?.getString(EDIT_CONTACT_EMAIL))
    }
}
