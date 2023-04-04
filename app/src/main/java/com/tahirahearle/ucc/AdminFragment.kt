package com.tahirahearle.ucc

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AdminFragment : Fragment() {

    private val email: String = "ithod@ucc.edu.jm"

    @SuppressLint("SetTextI18n")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_admin, container, false)

        // send email to head of it department
        val fab : FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(intent)
        }

        val entryRequirementsTextView = view.findViewById<TextView>(R.id.entry_requirements_text_view)
        entryRequirementsTextView.text = "- To be unconditionally admitted to complete UCC undergraduate " +
                "programmes, individuals should possess a minimum of five (5) subjects at the GCE or CSEC  " +
                "level (including the mandatory English Language and Mathematics) at grades A, B, C or 1, 2, " +
                "3 respectively. A CSEC pass at level 3 must have been obtained since 1998.\n\n" +
                "- Candidates who have a minimum of 4 CXCs can also apply pending the outstanding CXC " +
                "subjects or can opt to do UCC replacement courses Core Mathematics, English for Academic " +
                "Purpose and Fundamentals of Accounting.\n\n" +
                "- Candidates can opt to apply under the Mature Entry option. To be accepted, applicants " +
                "must be working for 5 years or more and be at a minimum age of 25 years. Academic " +
                "qualifications, a detailed resume, a job letter and 3 professional references will be required.\n\n" +
                "--"

        // Set the honours programme text
        val honoursProgrammeTextView = view.findViewById<TextView>(R.id.honours_programme_text_view)
        honoursProgrammeTextView.text = "Students with 8 CXC/GCE subjects including Mathematics and " +
                "English Language at Grade 1 may be eligible for a 25% tuition waiver during the first year."

        // Set up the apply button
        val applyButton = view.findViewById<Button>(R.id.apply_button)
        applyButton.setOnClickListener {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ucc.edu.jm/apply/undergraduate"))
            startActivity(intent)
        }



        return view
    }

}


