package com.example.doctor.ui.editPatientInfo

import android.content.Context
import android.os.Bundle

// Data class for Edit Patient Information screen
data class EditPatientDataClass(
    var phoneNumber: String?,
    var emailId: String?,
    var memberNumber: String?,
    var insuranceNumber: String?,
    var address: String?,
    var insurance: String?,
    var editOptions: EditPatientContactOption?,
    var editInsurace: EditPatientContactOption?,
    var insuranceList: List<String?>?
)

data class NTuple4<ResourceString, String, Int, Bundle>(
    val t1: ResourceString,
    val t2: String?,
    val t3: Int,
    val t4: Bundle
)

data class EditPatientContactOption(
    var twoLineItems: NTuple4<ResourceString, String?, Int, Bundle>
)

// Resource String for ViewModel handle Resource R.string.*

sealed class ResourceString {
    abstract fun format(context: Context): String
}

class IdResourceString(val id: Int) : ResourceString() {
    override fun format(context: Context): String {
        return context.getString(id)
    }
}
