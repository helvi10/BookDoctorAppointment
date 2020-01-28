package com.example.doctor.ui.appointmentConfirmation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AppointmentConfirmationDataclass(
    val name: String? = null,
    val availableDate: String? = null,
    val availableTime: String? = null,
    val clinicAddress: String? = null,
    val customerName: String? = null
) : Parcelable
