package com.example.doctor.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.doctor.model.Doctor
import com.example.doctor.ui.bookAppointment.BookAppointmentDataClass
import com.example.doctor.ui.bookAppointment.BookAppointmentViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class BookAppointmentViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BookAppointmentViewModel

    @Before
    fun setup() {
        viewModel = BookAppointmentViewModel()
    }

    @Test
    fun `when build Book Appointment should return list of data`() {
        val doctor = Doctor(
            suffix = "Dr.",
            firstName = "Mark",
            lastName = "Price",
            mobile = "9909132789",
            specialist = null,
            clinicAddress = "chicago,IL",
            emailId = "helvi@gmail.com",
            distance = "3.3",
            imageURL = null
        )
        val appointment = viewModel.setBookAppointmentData(doctor, "Harry")
        Assert.assertEquals(getBookAppointmentData(), appointment)
    }

    @Test
    fun `when data is not available should return empty list`() {
         viewModel.setBookAppointmentData(null, "")
         val appointment = viewModel.bookAppointmentData.value
         Assert.assertEquals(null,appointment)
    }

    fun getBookAppointmentData(): BookAppointmentDataClass {
        return BookAppointmentDataClass(
            name = "Dr. Mark Price",
            specialist = null,
            reviews = "Reviews: 600",
            availableDate = "2020 Jan 28 00",
            availableTime = "10:30AM",
            clinicAddress = "chicago,IL",
            customerName = "Harry"
        )
    }
}
