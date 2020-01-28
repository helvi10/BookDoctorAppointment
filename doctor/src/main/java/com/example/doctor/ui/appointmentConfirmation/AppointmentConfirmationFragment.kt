package com.example.doctor.ui.appointmentConfirmation

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

class AppointmentConfirmationFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_appointment_confirmed
    private var viewModel: AppointmentConfirmationViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[AppointmentConfirmationViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        viewModel?.appointmentData?.observe(viewLifecycleOwner, Observer {
            buildAllViews(view, it)
        })
    }

    private fun buildAllViews(view: View, bookAppointmentData: AppointmentConfirmationDataclass) {
        val headerMessage =
            bookAppointmentData.customerName + getString(R.string.confirmed_appointment)
        view.findViewById<TextView>(R.id.appointment_confirmed_header).text = headerMessage

        val doctorNameAndTime = bookAppointmentData.name
        view.findViewById<TextView>(R.id.appointment_confirmed_time).text = doctorNameAndTime

        view.findViewById<TextView>(R.id.appointment_confirmed_date).text =
            bookAppointmentData.availableDate
        view.findViewById<TextView>(R.id.appointment_confirmed_address).text =
            bookAppointmentData.clinicAddress
        view.findViewById<Button>(R.id.appointment_confirmed_button).setOnClickListener {
            findNavController().popBackStack(R.id.PatientInfoFragment, false)
        }
    }

}
