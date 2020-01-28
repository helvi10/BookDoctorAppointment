package com.example.doctor.ui.patientInfo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PatientInfoDataClass(
    var firstName: String? = null,
    var lastName: String? = null,
    var mobile: String? = null,
    var emailId: String? = null,
    var patientNumber: String? = null,
    var dateOfBirth: String? = null,
    var Address: String? = null,
    var insuranceName: String? = null,
    var memberNumber: String? = null,
    var insuranceNumber: String? = null,
    var insuranceList: List<String?>?
) : Parcelable
