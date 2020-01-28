package com.example.doctor.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Patient(
    val firstName: String? = null,
    val lastName: String? = null,
    val mobile: String? = null,
    val emailId: String? = null,
    val patientNumber: String? = null,
    val dateOfBirth: String? = null,
    val address: String? = null,
    val insuranceName: String? = null,
    var memberNumber: String? = null,
    var insuranceNumber: String? = null,
    val insuranceList: List<String?>?,
    val doctors: List<Doctor?>?
) : Parcelable
