package com.example.doctor.ui.editPatientInfo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment


class EditPatientInfoFragment : BaseFragment() {

    override val layoutId: Int = R.layout.fragment_edit_patient_info
    private var viewModel: EditPatientInfoViewModel? = null
    private val commonSharedEditPatientViewModel: CommonSharedEditPatientViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commonSharedEditPatientViewModel.setContinueButton(false)
        commonSharedEditPatientViewModel.setPhoneNumber(null)
        commonSharedEditPatientViewModel.setEmailAddress(null)
        commonSharedEditPatientViewModel.setInsurance(null)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[EditPatientInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        commonSharedEditPatientViewModel.continueButton.observe(viewLifecycleOwner, Observer {
            if (it) {
                if (viewModel?.editPatientData?.value?.phoneNumber != commonSharedEditPatientViewModel.phoneNumber.value &&
                    !commonSharedEditPatientViewModel.phoneNumber.value.equals(
                        null
                    )
                ) {
                    viewModel?.setPhoneNumber(commonSharedEditPatientViewModel.phoneNumber.value)
                }

                if (viewModel?.editPatientData?.value?.emailId !=
                    commonSharedEditPatientViewModel.email.value
                    && !commonSharedEditPatientViewModel.email.value.equals(null)
                ) {
                    viewModel?.setEmail(commonSharedEditPatientViewModel.email.value)
                }
                viewModel?.editOptions(
                    viewModel?.editPatientData?.value?.phoneNumber,
                    viewModel?.editPatientData?.value?.emailId
                )
            }
        })
        commonSharedEditPatientViewModel.insurance.observe(viewLifecycleOwner, Observer {
            it.let {
                if (it != null) {
                    viewModel?.editPatientData?.value?.insurance = it
                    viewModel?.editPatientData?.value?.editInsurace =
                        viewModel?.setInsuranceOptions(
                            viewModel?.editPatientData?.value?.insurance,
                            viewModel?.editPatientData?.value?.insuranceList
                        )
                }
            }
        })
        viewModel?.editPatientData?.observe(viewLifecycleOwner, Observer {
            buildAllViews(view, it)
        })
    }

    private fun buildAllViews(view: View, editPatientDataClass: EditPatientDataClass) {
        buildTwoLineItems(view, editPatientDataClass)
        buildMemberInfo(view, editPatientDataClass)
        buildFooter(view, editPatientDataClass)
    }

    private fun buildTwoLineItems(view: View, editPatientDataClass: EditPatientDataClass?) {
        view.findViewById<LinearLayout>(R.id.edit_patient_info_edit_contact).run {
            addView(oneLineItemView(this, editPatientDataClass?.editOptions?.twoLineItems))
        }

        view.findViewById<LinearLayout>(R.id.edit_patient_info_select_deal).run {
            addView(oneLineItemView(this, editPatientDataClass?.editInsurace?.twoLineItems))
        }
    }

    private fun buildMemberInfo(view: View, editPatientDataClass: EditPatientDataClass) {
        val memberNumber = view.findViewById<EditText>(R.id.member_number_text_input_layout)
        memberNumber.setText(editPatientDataClass.memberNumber)
        val insuranceNumber = view.findViewById<EditText>(R.id.insurance_number_text_input_layout)
        insuranceNumber.setText(editPatientDataClass.insuranceNumber)
        val address = view.findViewById<EditText>(R.id.edit_patient_address_layout)
        address.setText(editPatientDataClass.address)
    }

    private fun buildFooter(view: View, editPatientDataClass: EditPatientDataClass) {
        view.findViewById<Button>(R.id.edit_patient_save_to_information).setOnClickListener {
            Toast.makeText(context, "Your Information is successfully updated", Toast.LENGTH_LONG)
                .show()
            findNavController().popBackStack()
        }
        view.findViewById<Button>(R.id.edit_patient_cancel).setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun oneLineItemView(
        parentView: ViewGroup,
        triple: NTuple4<ResourceString, String?, Int, Bundle>?
    ): View =
        LayoutInflater.from(context).inflate(
            R.layout.two_line_item,
            parentView,
            false
        ).apply {
            findViewById<TextView>(R.id.twoLineItem_firstText).text =
                triple?.t1?.format(context)
            findViewById<TextView>(R.id.twoLineItem_secondText).text =
                triple?.t2
            setOnClickListener {
                findNavController().navigate(triple?.t3 ?: 0, triple?.t4)
            }
        }
}
