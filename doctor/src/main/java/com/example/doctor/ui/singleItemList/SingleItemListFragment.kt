package com.example.doctor.ui.singleItemList

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R
import com.example.doctor.ui.BaseFragment
import com.example.doctor.ui.editPatientInfo.CommonSharedEditPatientViewModel

class SingleItemListFragment : BaseFragment() {

    override val layoutId = R.layout.fragment_single_item_list
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: SingleItemListAdapter? = null
    private var viewModel: SingleItemViewModel? = null
    private val commonSharedEditPatientViewModel: CommonSharedEditPatientViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        setViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel?.setData(arguments)
        buildAllViews(view)
    }

    private fun setViewModel() {
        viewModel = ViewModelProviders.of(this)[SingleItemViewModel::class.java]
    }

    private fun buildAllViews(view: View) {
        viewModel?.insuranceList?.observe(viewLifecycleOwner, Observer {
            buildRecyclerView(view)
        })
    }

    private fun buildRecyclerView(view: View) {
        recyclerView = view.findViewById(R.id.single_item_info_recyclerview)
        val itemOnClick: (Int) -> Unit = { position ->
            commonSharedEditPatientViewModel.setInsurance(
                viewModel?.insuranceList?.value?.get(
                    position
                )
            )
            findNavController().popBackStack()
        }

        recyclerViewAdapter = SingleItemListAdapter(
            viewModel?.insuranceList?.value ?: listOf(), context, itemClickListener = itemOnClick
        )
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = recyclerViewAdapter
    }

}
