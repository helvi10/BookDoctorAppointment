package com.example.bookdocapp


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

class MainFragment : Fragment() {

    private var viewModel: MainViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildAllViews(view)
    }

    fun buildAllViews(view: View) {
        val username = view.findViewById<EditText>(R.id.login_username_text_input)
        val password = view.findViewById<EditText>(R.id.login_password_text_input)
        val error = view.findViewById<TextView>(R.id.login_info_error)
        username.setText("")
        password.setText("")

        view.findViewById<Button>(R.id.login_info_button)
            .setOnClickListener {
                if (viewModel?.isUserValid(username.text.toString(), password.text.toString()) == true
                ) {
                    findNavController().navigate(
                        R.id.doctor_main_navigation,
                        viewModel?.getPatientInfo()
                    )
                } else {
                    error.visibility = View.VISIBLE
                    error.text = getString(R.string.error_message)
                }
            }
    }

}


