package com.example.doctor.ui.editPatientInfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.ui.BaseViewModel

class CommonSharedEditPatientViewModel : BaseViewModel() {

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _continueButton = MutableLiveData<Boolean>()
    val continueButton: LiveData<Boolean> = _continueButton

    private val _insurance = MutableLiveData<String>()
    val insurance: LiveData<String> = _insurance

    fun setPhoneNumber(phone: String?) {
        _phoneNumber.value = phone
    }

    fun setEmailAddress(email: String?) {
        _email.value = email
    }

    fun setContinueButton(isclicked: Boolean?) {
        _continueButton.value = isclicked
    }

    fun setInsurance(insurance: String?) {
        _insurance.value = insurance
    }
}
