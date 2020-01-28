package com.example.doctor.ui.doctorList

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.model.Patient
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.util.APPOINTMENT_CONFIRMATION_DESTINATION
import com.example.doctor.ui.util.CUSTOMER_NAME
import com.example.doctor.ui.util.DOCTOR_INFO_DESTINATION

class DoctorListViewModel : BaseViewModel() {

    private val _doctorListDataClass = MutableLiveData<DoctorListDataClass>()
    val doctorListDataClass: LiveData<DoctorListDataClass> = _doctorListDataClass

    fun setData(arguments: Bundle?) {
        _doctorListDataClass.value =
            setDoctorListDataClass(arguments?.getParcelable(DOCTOR_INFO_DESTINATION))
    }

    /**
     * Set Book DoctorList Dataclass
     */
    fun setDoctorListDataClass(patient: Patient?): DoctorListDataClass {
        return DoctorListDataClass(
            customerName = patient?.firstName + " " + patient?.lastName,
            mobile = patient?.mobile,
            emailId = patient?.emailId,
            patientNumber = patient?.patientNumber,
            dateOfBirth = patient?.dateOfBirth,
            Address = patient?.address,
            insuranceName = patient?.insuranceName,
            doctors = patient?.doctors
        )
    }

    /**
     * Get user selected doctor information
     */
    fun getSelectedDoctorInfo(position: Int): Bundle {
        val bundle = Bundle()
        bundle.putParcelable(
            APPOINTMENT_CONFIRMATION_DESTINATION,
            _doctorListDataClass.value?.doctors?.get(position)
        )
        bundle.putString(CUSTOMER_NAME, _doctorListDataClass.value?.customerName)
        return bundle
    }

}
