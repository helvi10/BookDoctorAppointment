package com.example.doctor.ui.singleItemList

import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctor.ui.BaseViewModel
import com.example.doctor.ui.util.INSURANCE_LIST
import com.example.doctor.ui.util.INSURANCE_NAME

class SingleItemViewModel : BaseViewModel() {

    private val _insuranceList = MutableLiveData<List<String>>()
    val insuranceList: LiveData<List<String>> = _insuranceList

    private val _insurance = MutableLiveData<String>()
    val insurance: LiveData<String> = _insurance

    fun setData(arguments: Bundle?) {
        _insurance.value = arguments?.getString(INSURANCE_NAME)
        _insuranceList.value = arguments?.getStringArrayList(INSURANCE_LIST)
    }
}
