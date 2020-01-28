package com.example.doctor.ui.doctorList


import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment

class DoctorListFragment : BaseFragment() {
    override val layoutId: Int = R.layout.fragment_doctor_list
    private var viewModel: DoctorListViewModel? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        viewModel?.doctorListDataClass?.observe(viewLifecycleOwner, Observer {
            initializeView(view, it)
        })
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[DoctorListViewModel::class.java]
    }

    private fun initializeView(view: View, doctorListDataClass: DoctorListDataClass) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.doctor_list_recyclerView)
        val recyclerViewAdapter =
            DoctorListAdapter(doctorListDataClass.doctors, context, itemOnClick)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = recyclerViewAdapter
    }

    val itemOnClick: (Int) -> Unit = { position ->
        findNavController().navigate(
            R.id.BookAppointmentFragment,
            viewModel?.getSelectedDoctorInfo(position)
        )
    }

}
