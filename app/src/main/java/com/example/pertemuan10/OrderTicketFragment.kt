package com.example.pertemuan10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.SimpleDateFormat
import java.util.*

class OrderTicketFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order_ticket, container, false)

        val ticketSpinner: Spinner = view.findViewById(R.id.spinner_ticket_type)
        val orderButton: Button = view.findViewById(R.id.btn_order_ticket)

        // Populate spinner
        val ticketTypes = arrayOf("First Class Ticket", "Business Class Ticket", "Economy Class Ticket")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, ticketTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        ticketSpinner.adapter = adapter

        orderButton.setOnClickListener {
            val selectedTicketType = ticketSpinner.selectedItem?.toString()
            if (selectedTicketType.isNullOrEmpty()) {
                Toast.makeText(requireContext(), "Please select a ticket type", Toast.LENGTH_SHORT).show()
            } else {
                val currentDate = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(Date())
                Toast.makeText(requireContext(), "Ticket with type $selectedTicketType has been ordered on $currentDate", Toast.LENGTH_LONG).show()
            }
        }

        return view
    }
}
