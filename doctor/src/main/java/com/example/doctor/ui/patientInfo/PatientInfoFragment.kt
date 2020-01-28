package com.example.doctor.ui.patientInfo

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment

class PatientInfoFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_patient_info
    private var viewModel: PatientInformationViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.getResponse()
        viewModel?.patientData?.observe(viewLifecycleOwner, Observer {
            buildAllViews(view, it)
        })
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[PatientInformationViewModel::class.java]
    }

    private fun buildAllViews(view: View, patientInfoDataClass: PatientInfoDataClass) {
        buildPatientInfo(view, patientInfoDataClass)
        buildBookAppointment(view)
        buildUpdateInformation(view)
    }

    private fun buildPatientInfo(view: View, patientInfoDataClass: PatientInfoDataClass) {
        val customerName = patientInfoDataClass.firstName + " " + patientInfoDataClass.lastName
        view.findViewById<TextView>(R.id.customer_contact_information_header1).text = customerName
        view.findViewById<TextView>(R.id.customer_contact_information_header2).text =
            patientInfoDataClass.patientNumber
        view.findViewById<TextView>(R.id.customer_contact_information_header3).text =
            patientInfoDataClass.Address
        view.findViewById<TextView>(R.id.edit_patient_info_learn_more).setOnClickListener {
            findNavController().navigate(R.id.CommonDetailFragment)
        }
        view.findViewById<LinearLayout>(R.id.edit_patient_info_deals).apply {
            addView(advertiseItem(this))
            setOnClickListener {
                navigateToDeal()
            }
        }
        view.findViewById<Button>(R.id.edit_patient_search_button).setOnClickListener {
            findNavController().navigate(
                R.id.DoctorListFragment,
                viewModel?.navigateToAppointmentFlow()
            )
        }
        view.findViewById<Button>(R.id.edit_patient_cancel_button)
            .setOnClickListener { findNavController().popBackStack() }
    }

    private fun advertiseItem(view: ViewGroup): View =
        LayoutInflater.from(context).inflate(
            R.layout.advertise_item, view, false
        ).apply { }


    private fun buildBookAppointment(view: View) {
        view.findViewById<TextView>(R.id.edit_patient_info_search_for_doc_subheader)
            .setOnClickListener {
                findNavController().navigate(
                    R.id.DoctorListFragment,
                    viewModel?.navigateToAppointmentFlow()
                )
            }
    }

    private fun buildUpdateInformation(view: View) {
        view.findViewById<TextView>(R.id.edit_patient_info_subheader).setOnClickListener {
            findNavController().navigate(
                R.id.EditPatientInfoFragment,
                viewModel?.navigateToEditPatientFlow()
            )
        }
    }

    private fun navigateToDeal() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        this.startActivity(browserIntent)
    }
}
