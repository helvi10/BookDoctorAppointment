package com.example.cust.ui.commonDetails

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment
import com.example.doctor.ui.commonDetails.CommonDetailsViewModel

class CommonDetailsFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_common_details
    private var viewModel: CommonDetailsViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[CommonDetailsViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.commonn_details_text).text =
            getString(R.string.learn_more_about_content)
    }
}
