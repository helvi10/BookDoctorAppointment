package com.example.doctor.ui.doctorList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor.R
import com.example.doctor.model.Doctor
import com.example.doctor.ui.util.DOCTOR_TEXT

class DoctorListAdapter(
    var items: List<Doctor?>?,
    val context: Context?,
    val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<DoctorListAdapter.DoctorViewHolder>() {

    override fun onBindViewHolder(holder: DoctorViewHolder, position: Int) {
        holder.bindItems(items?.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return items?.size ?: -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DoctorViewHolder {
        val view: View
        view = LayoutInflater.from(parent.context).inflate(R.layout.doctor_info_item, parent, false)
        return DoctorViewHolder(view)
    }

    class DoctorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(
            doctor: Doctor?,
            itemClickListener: (Int) -> Unit
        ) {

            val doctorName = itemView.findViewById<TextView>(R.id.doctor_info_name)
            val miles = itemView.findViewById<TextView>(R.id.doctor_info_miles)
            val specialistTitle = itemView.findViewById<TextView>(R.id.doctor_info_specialist)
            val clinicAddress = itemView.findViewById<TextView>(R.id.doctor_info_clinic_address)
            val nextAvailabilityButton =
                itemView.findViewById<Button>(R.id.doctor_info_next_availability)

            val doctorNameText = DOCTOR_TEXT + doctor?.firstName + " " + doctor?.lastName
            doctorName.text = doctorNameText
            specialistTitle.text = doctor?.specialist
            clinicAddress.text = doctor?.clinicAddress

            nextAvailabilityButton.setOnClickListener {
                itemClickListener(layoutPosition)
            }
        }
    }
}
