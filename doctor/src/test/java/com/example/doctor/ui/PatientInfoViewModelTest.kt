package com.example.doctor.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.doctor.model.Patient
import com.example.doctor.ui.patientInfo.PatientInfoDataClass
import com.example.doctor.ui.patientInfo.PatientInformationViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class PatientInfoViewModelTest {

    @get:Rule
    var rule:TestRule = InstantTaskExecutorRule()
    private lateinit var mViewModel: PatientInformationViewModel

    @Before
    fun setUp(){
        mViewModel = PatientInformationViewModel()
    }

    @Test
    fun `when data is  available should return  list`(){
        val patient = Patient(firstName = "Mike" ,
         lastName = "Walter",
         mobile = "9909123456",
         emailId = "mike@yahoo.com",
         patientNumber = "123",
         dateOfBirth ="10-1-1960" ,
         address = "chicago,IL",
         insuranceName = "345",
         memberNumber = "0909" ,
         insuranceNumber="4321",
         insuranceList=null,
         doctors= null
        )
        val patienData = mViewModel.patientDetails(patient)
        Assert.assertEquals(patienData,getPatientData())
    }


    @Test
    fun `when data is  not available should return empty  list`(){
        val patienData = mViewModel.patientDetails(null)
        Assert.assertEquals(getPatienEmpty(),patienData)
    }

    fun getPatienEmpty():PatientInfoDataClass{
        return PatientInfoDataClass(firstName = null,
            lastName = null,
            mobile = null,
            emailId = null,
            patientNumber = null,
            dateOfBirth = null,
            Address = null,
            insuranceName = null,
            memberNumber = null,
            insuranceNumber = null,
            insuranceList = null)
    }

    fun getPatientData():PatientInfoDataClass{
        return PatientInfoDataClass(firstName = "Mike",
        lastName = "Walter",
        mobile = "9909123456",
        emailId = "mike@yahoo.com",
        patientNumber = "123",
        dateOfBirth = "10-1-1960",
        Address = "chicago,IL",
        insuranceName = "345",
        memberNumber = "0909",
        insuranceNumber = "4321",
        insuranceList = null)
    }

}
