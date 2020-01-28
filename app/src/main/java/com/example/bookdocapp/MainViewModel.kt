package com.example.bookdocapp

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import com.example.doctor.ui.util.PASSWORD
import com.example.doctor.ui.util.PATIENT_INFO_DESTINATION
import com.example.doctor.ui.util.USER1
import com.example.doctor.ui.util.USER2

class MainViewModel : ViewModel() {

    fun getPatientInfo(): Bundle {
        val bundle = bundleOf(PATIENT_INFO_DESTINATION to "Patient Information")
        return bundle
    }

    fun isUserValid(userName: String, password: String): Boolean {
        if ((userName.equals(USER1) && password.equals(PASSWORD)) || (userName.equals(USER2) && password.equals(
                PASSWORD
            ))
        ) {
            return true
        }
        return false
    }

}
