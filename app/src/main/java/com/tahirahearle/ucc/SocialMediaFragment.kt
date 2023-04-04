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


class SocialMediaFragment : Fragment() {

    private val email: String = "ithod@ucc.edu.jm"

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_socialmedia, container, false)



        // send email to head of it department
        val fab : FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email,null))
            intent.putExtra(Intent.EXTRA_EMAIL, email)
            startActivity(intent)
        }

        //launches facebook
        val fbweb: Button = view.findViewById(R.id.facebook_button)
        fbweb.setOnClickListener {
            val intent = Intent(activity, Facebook::class.java)
            startActivity(intent)
        }

        //launches instagram
        val igweb: Button = view.findViewById(R.id.instagram_button)
        igweb.setOnClickListener {
            val intent = Intent(activity, Instagram::class.java)
            startActivity(intent)
        }

        //launches twitter
        val tweetweb: Button = view.findViewById(R.id.twitter_button)
        tweetweb.setOnClickListener {
            val intent = Intent(activity, Twitter::class.java)
            startActivity(intent)
        }

        return view
    }
}
