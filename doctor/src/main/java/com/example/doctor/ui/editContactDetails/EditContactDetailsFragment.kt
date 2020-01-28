package com.example.doctor.ui.editContactDetails

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment
import com.example.doctor.ui.editPatientInfo.CommonSharedEditPatientViewModel

class EditContactDetailsFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_edit_contact_details
    private var viewModel: EditContactDetailsViewModel? = null
    private val commonSharedEditPatientViewModel: CommonSharedEditPatientViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[EditContactDetailsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        buildAllViews(view)
    }

    private fun buildAllViews(view: View) {
        viewModel?.phoneNumber?.observe(viewLifecycleOwner, Observer {
            val phoneNumber =
                view.findViewById<EditText>(R.id.customer_contact_details_phone_number_layout)
            phoneNumber.setText(it)
            phoneNumber.doOnTextChanged { text, _, _, _ ->
                commonSharedEditPatientViewModel.setPhoneNumber((text.toString()))
            }
        })
        viewModel?.emailId?.observe(viewLifecycleOwner, Observer {
            val emailID =
                view.findViewById<EditText>(R.id.customer_edit_contact_email_text_input_layout)
            emailID.setText(it)
            emailID.doOnTextChanged { text, _, _, _ ->
                commonSharedEditPatientViewModel.setEmailAddress((text.toString()))
            }
        })

        view.findViewById<Button>(R.id.edit_contact_save).setOnClickListener {
            commonSharedEditPatientViewModel.setContinueButton(true)
            findNavController().popBackStack()
        }

        view.findViewById<Button>(R.id.edit_contact_cancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
