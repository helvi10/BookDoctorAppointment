package com.example.doctor.ui.bookAppointment

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookAppointmentDataClass(
    val name: String? = null,
    val specialist: String? = null,
    val reviews: String? = null,
    val availableDate: String? = null,
    val availableTime: String? = null,
    val clinicAddress: String? = null,
    val patientName: String? = null
) : Parcelable
