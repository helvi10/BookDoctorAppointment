package com.example.doctor.ui.patientInfo

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.model.Patient
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.util.DOCTOR_INFO_DESTINATION
import com.example.doctor.ui.util.DoctorMockDataSource.mockResponse
import com.example.doctor.ui.util.EDIT_PATIENT_INFO_DESTINATION
import com.google.gson.Gson


class PatientInformationViewModel : BaseViewModel() {

    private val _patientData = MutableLiveData<PatientInfoDataClass>()
    val patientData: LiveData<PatientInfoDataClass> = _patientData

    var patient: Patient? = null

    init {
    }

    fun getResponse() {
        patient = deserializeFromJSON(mockResponse)
        val patientInfoDataClass = patientDetails(patient)
        setPatientData(patientInfoDataClass)
    }

    private fun setPatientData(patientData: PatientInfoDataClass) {
        _patientData.value = patientData
    }

    private fun deserializeFromJSON(
        jsonString: String?
    ): Patient {
        return Gson().fromJson(
            jsonString,
            Patient::class.java
        )
    }

    fun patientDetails(patient: Patient?): PatientInfoDataClass {
        return PatientInfoDataClass(
            firstName = patient?.firstName,
            lastName = patient?.lastName,
            mobile = patient?.mobile,
            emailId = patient?.emailId,
            patientNumber = patient?.patientNumber,
            dateOfBirth = patient?.dateOfBirth,
            Address = patient?.address,
            insuranceName = patient?.insuranceName,
            memberNumber = patient?.memberNumber,
            insuranceNumber = patient?.insuranceNumber,
            insuranceList = patient?.insuranceList
        )
    }

    /**
     * Navigate to Appointment Flow
     */
    fun navigateToAppointmentFlow(): Bundle {
        val bundle = Bundle()
        bundle.putParcelable(DOCTOR_INFO_DESTINATION, patient)
        return bundle
    }

    /**
     * Navigate to Edit Patient flow
     */

    fun navigateToEditPatientFlow(): Bundle {
        val bundle = Bundle()
        bundle.putParcelable(EDIT_PATIENT_INFO_DESTINATION, patientData.value)
        return bundle
    }


}
