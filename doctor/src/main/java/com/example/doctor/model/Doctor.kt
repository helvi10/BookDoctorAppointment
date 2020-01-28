package com.example.doctor.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Doctor(
    val suffix: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val mobile: String? = null,
    val specialist: String? = null,
    val clinicAddress: String? = null,
    val emailId: String? = null,
    val distance: String? = null,
    val imageURL: String? = null
) : Parcelable
