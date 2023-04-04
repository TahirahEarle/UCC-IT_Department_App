package com.tahirahearle.ucc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {

    private val email: String = "ithod@ucc.edu.jm"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // send email to head of it department
        val fab : FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(intent)
        }

        // open twitter
        val tFab : FloatingActionButton = view.findViewById(R.id.tfab)
        tFab.setOnClickListener{
            val intent = Intent(activity, Twitter::class.java)
            startActivity(intent)
        }

        // open social media fragment
        val smpage : Button = view.findViewById(R.id.sm_button)
        smpage.setOnClickListener {
            val smFragment = SocialMediaFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, smFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        // open faculty fragment
        val facultypage : Button = view.findViewById(R.id.faculty_button)
        facultypage.setOnClickListener {
            val facultyFragment = FacultyFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, facultyFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // open admin fragment
        val adminpage : Button = view.findViewById(R.id.admin_button)
        adminpage.setOnClickListener {
            val adminFragment = AdminFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, adminFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        // open course fragment
        val coursepage : Button = view.findViewById(R.id.course_button)
        coursepage.setOnClickListener {
            val courseFragment = CourseFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, courseFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // view more button
        val viewMore : Button = view.findViewById(R.id.view_button)
        viewMore.setOnClickListener {
            val courseFragment = CourseFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, courseFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

}