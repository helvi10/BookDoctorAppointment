package com.example.doctor.ui.editPatientInfo

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.R
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.patientInfo.PatientInfoDataClass
import com.example.doctor.ui.util.*
import java.util.*


class EditPatientInfoViewModel : BaseViewModel() {

    private val _editPatientData = MutableLiveData<EditPatientDataClass>()
    val editPatientData: LiveData<EditPatientDataClass> = _editPatientData


    fun setData(arguments: Bundle?) {
        _editPatientData.value =
            setEditPatientData(arguments?.getParcelable(EDIT_PATIENT_INFO_DESTINATION))
    }

    /**
     * Set Edit Patient Dataclass
     */
    fun setEditPatientData(patientInfoDataClass: PatientInfoDataClass?): EditPatientDataClass {
        return EditPatientDataClass(
            phoneNumber = patientInfoDataClass?.mobile,
            emailId = patientInfoDataClass?.emailId,
            memberNumber = patientInfoDataClass?.memberNumber,
            insuranceNumber = patientInfoDataClass?.insuranceNumber,
            address = patientInfoDataClass?.Address,
            insurance = patientInfoDataClass?.insuranceName,
            editOptions = setEditOptions(
                patientInfoDataClass?.mobile,
                patientInfoDataClass?.emailId
            ),
            editInsurace = setInsuranceOptions(
                patientInfoDataClass?.insuranceName,
                patientInfoDataClass?.insuranceList
            ),
            insuranceList = patientInfoDataClass?.insuranceList
        )
    }

    fun setEditOptions(mobile: String?, emailId: String?): EditPatientContactOption {
        val twoLineItems: NTuple4<ResourceString, String?, Int, Bundle>
        twoLineItems =
            NTuple4(
                IdResourceString(R.string.edit_contact_details),
                mobile,
                R.id.EditContactDetailsFragment,
                getContactDetails(mobile, emailId)
            )

        return EditPatientContactOption(twoLineItems)
    }

    fun setInsuranceOptions(
        insurance: String?,
        insuranceList: List<String?>?
    ): EditPatientContactOption {
        val twoLineItems: NTuple4<ResourceString, String?, Int, Bundle>

        twoLineItems =
            NTuple4(
                IdResourceString(R.string.insurance_plan),
                insurance,
                R.id.SingleItemListFragment,
                getInsurance(insurance, insuranceList)
            )

        return EditPatientContactOption(twoLineItems)
    }

    fun setPhoneNumber(phone: String?) {
        editPatientData.value?.phoneNumber = phone
    }

    fun setEmail(email: String?) {
        editPatientData.value?.emailId = email
    }

    fun editOptions(
        phone: String?,
        emailId: String?
    ) {
        editPatientData.value?.editOptions = setEditOptions(phone, emailId)
    }

    private fun getContactDetails(phone: String?, emailId: String?): Bundle {
        val bundle = Bundle()
        bundle.putString(EDIT_CONTACT_PHONE_NUMBER, phone)
        bundle.putString(EDIT_CONTACT_EMAIL, emailId)
        return bundle
    }

    private fun getInsurance(insurance: String?, insuranceList: List<String?>?): Bundle {
        val bundle = Bundle()
        bundle.putString(INSURANCE_NAME, insurance)
        bundle.putStringArrayList(INSURANCE_LIST, insuranceList as ArrayList<String>?)
        return bundle
    }


}


