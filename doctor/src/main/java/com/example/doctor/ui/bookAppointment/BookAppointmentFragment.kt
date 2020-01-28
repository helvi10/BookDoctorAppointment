package com.example.doctor.ui.bookAppointment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment

class BookAppointmentFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_appointment_confirmation
    private var viewModel: BookAppointmentViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[BookAppointmentViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        viewModel?.bookAppointmentData?.observe(viewLifecycleOwner, Observer {
            buildViews(view, it)
        })
    }

    private fun buildViews(view: View, bookAppointmentdataClass: BookAppointmentDataClass) {
        view.findViewById<Button>(R.id.patient_confirmation_cancel_button).setOnClickListener {
            findNavController().popBackStack()
        }
        view.findViewById<Button>(R.id.patient_confirmation_confirm_button).setOnClickListener {
            findNavController().navigate(
                R.id.AppointmentConfirmedFragment,
                viewModel?.getDoctorInfo()
            )
        }
        view.findViewById<TextView>(R.id.patient_confirmation_doctor_name).text =
            bookAppointmentdataClass.name
        view.findViewById<TextView>(R.id.patient_confirmation_doctor_type).text =
            bookAppointmentdataClass.specialist
        view.findViewById<TextView>(R.id.patient_confirmation_doctor_reviews).text =
            bookAppointmentdataClass.reviews
        view.findViewById<TextView>(R.id.patient_confirmation_doctor_availability_text).text =
            bookAppointmentdataClass.availableDate
    }

}
