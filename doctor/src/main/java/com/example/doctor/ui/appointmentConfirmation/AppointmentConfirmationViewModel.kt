package com.example.doctor.ui.appointmentConfirmation

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.bookAppointment.BookAppointmentDataClass
import com.example.doctor.ui.util.APPOINTMENT_CONFIRMED_DESTINATION

class AppointmentConfirmationViewModel : BaseViewModel() {

    private val _appointmentData = MutableLiveData<AppointmentConfirmationDataclass>()
    val appointmentData: LiveData<AppointmentConfirmationDataclass> = _appointmentData

    fun setData(arguments: Bundle?) {
        _appointmentData.value = setBookAppointmentData(
            arguments?.getParcelable(
                APPOINTMENT_CONFIRMED_DESTINATION
            )
        )
    }

    /**
     * Set Appointment Confirmation  Dataclass
     */
    private fun setBookAppointmentData(bookAppointmentDataClass: BookAppointmentDataClass?): AppointmentConfirmationDataclass {
        return AppointmentConfirmationDataclass(
            name = bookAppointmentDataClass?.name,
            availableDate = bookAppointmentDataClass?.availableDate,
            availableTime = bookAppointmentDataClass?.availableTime,
            clinicAddress = bookAppointmentDataClass?.clinicAddress,
            customerName = bookAppointmentDataClass?.patientName
        )
    }
}
