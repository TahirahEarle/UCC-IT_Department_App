package com.tahirahearle.ucc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton


class FacultyFragment : Fragment() {

    private val email: String = "ithod@ucc.edu.jm"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_faculty, container, false)

        // send email to head of it department
        val fab : FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(intent)
        }

        // Faculty Information

        val members = listOf(
            Member("Natalie Rose", R.drawable.headshot5,
                "876-339-0961",
                "ithod@ucc.edu.jm",
                "Head of IT Department"),

            Member("Otis Osbourne", R.drawable.headshot2,
                "876-218-2935",
                "itfaculty@ucc.edu.jm",
                "Discrete Maths Lecturer"),

            Member("Sajjad Rizvi", R.drawable.headshot,
                "+92-310-226-6566",
                "srizvi@faculty.ucc.edu.jm",
                "Computer Data Analysis Lecturer"),

            Member("Valentine White", R.drawable.headshot4,
                "876-373-2020",
                "vpwhite@faculty.ucc.edu.jm",
                "Database Management Lecturer"),

            Member("Karen Wilson", R.drawable.headshot7,
                "876-490-7395",
                "kwilson@faculty.ucc.edu.jm",
                "Technical Writing Lecturer"),

            Member("Neil Williams", R.drawable.headshot1,
                "876-906-3000",
                "itlecturer@ucc.edu.jm",
                "Internet Authoring Lecturer"),

            Member("Henry Osbourne", R.drawable.headshot3,
                "876-555-9012",
                "hosbourne@ucc.edu.jm",
                "Mobile App Development Lecturer")
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = MemberAdapter(members)

        return view
    }

}