package com.tahirahearle.ucc

import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CourseFragment : Fragment() {

    private val email: String = "ithod@ucc.edu.jm"
    private lateinit var db: FirebaseFirestore
    private lateinit var courseList: ArrayList<Course>

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_course, container, false)

        // send email to head of it department
        val fab : FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(intent)
        }

        val rvCourses: RecyclerView = view.findViewById(R.id.rvCourses)
        rvCourses.layoutManager = LinearLayoutManager(requireContext())
        rvCourses.setHasFixedSize(true)
        courseList = arrayListOf()

        db = Firebase.firestore

        db.collection("Courses").get()
            .addOnSuccessListener {
                if (!it.isEmpty) {
                    for (data in it.documents) {
                        val course: Course? = data.toObject(Course::class.java)
                        if (course != null) {
                            courseList.add(course)
                        }
                    }

                    rvCourses.adapter = CourseAdapter(courseList)
                }
            }
            .addOnFailureListener {
                Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
            }

        return view
    }
}
