package com.example.doctor.ui.doctorList

import com.example.doctor.model.Doctor

data class DoctorListDataClass(
    val customerName: String? = null,
    val mobile: String? = null,
    val emailId: String? = null,
    val patientNumber: String? = null,
    val dateOfBirth: String? = null,
    val Address: String? = null,
    val insuranceName: String? = null, val doctors: List<Doctor?>?
)
