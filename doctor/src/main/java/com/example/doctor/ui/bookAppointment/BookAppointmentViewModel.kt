package com.example.doctor.ui.bookAppointment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.model.Doctor
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.util.APPOINTMENT_CONFIRMATION_DESTINATION
import com.example.doctor.ui.util.APPOINTMENT_CONFIRMED_DESTINATION
import com.example.doctor.ui.util.CUSTOMER_NAME
import java.text.SimpleDateFormat
import java.util.*


class BookAppointmentViewModel : BaseViewModel() {

    private val _bookAppointmentData = MutableLiveData<BookAppointmentDataClass>()
    val bookAppointmentData: LiveData<BookAppointmentDataClass> = _bookAppointmentData

    fun setData(arguments: Bundle?) {
        val customerName = arguments?.getString(CUSTOMER_NAME)
        _bookAppointmentData.value = setBookAppointmentData(
            (arguments?.getParcelable(APPOINTMENT_CONFIRMATION_DESTINATION)),
            customerName
        )
    }

    /**
     * Set Book Appointment Dataclass
     */

    fun setBookAppointmentData(
        doctor: Doctor?,
        patientName: String?
    ): BookAppointmentDataClass {
        return BookAppointmentDataClass(
            name = DOCTOR_TEXT + doctor?.firstName + " " + doctor?.lastName,
            specialist = doctor?.specialist,
            reviews = REVIEWS,
            availableDate = getNextDayDate(),
            availableTime = "",
            clinicAddress = doctor?.clinicAddress,
            patientName = patientName
        )
    }

    @SuppressLint("SimpleDateFormat")
    private fun getNextDayDate(): String {
        val sdf: SimpleDateFormat = SimpleDateFormat(dateTimeFormat)
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR, 1)
        return sdf.format(calendar.time)
    }

    fun getDoctorInfo(): Bundle {
        val bundle = Bundle()
        bundle.putParcelable(
            APPOINTMENT_CONFIRMED_DESTINATION,
            _bookAppointmentData.value
        )
        bundle.putString(CUSTOMER_NAME, _bookAppointmentData.value?.patientName)
        return bundle
    }

    companion object {
        private const val dateTimeFormat = "MMMM dd, hh:00 a"
        private const val DOCTOR_TEXT = "Dr. "
        private const val REVIEWS = "Reviews: 600"
    }

}
