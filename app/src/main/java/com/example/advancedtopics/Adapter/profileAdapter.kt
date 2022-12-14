package com.example.advancedtopics.Adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedtopics.Classes.Profile
import com.example.advancedtopics.R

class profileAdapter(val profileInstance: List<Profile>): RecyclerView.Adapter<profileAdapter.ViewHolder>(){

    // On Click Listener //
    private lateinit var mListener: onItemClickListener
    private lateinit var bListener: onDeleteButtonClickListener


    interface onItemClickListener{

        fun onItemClick(position: Int){

        }

        /*
        fun onDeleteButtonClick(position: Int){

        }
         */
    }

    interface onDeleteButtonClickListener{

        fun onDeleteButtonClick(position: Int){

        }
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    fun setOnDeleteButtonListener(listener: onDeleteButtonClickListener){
        bListener = listener
    }


    // On Click Listener //

    inner class ViewHolder(itemView: View, listener: onItemClickListener, dlistener: onDeleteButtonClickListener) : RecyclerView.ViewHolder(itemView){

        val nameBox = itemView.findViewById<TextView>(R.id.textViewName)
        val ageBox = itemView.findViewById<TextView>(R.id.textViewAge)
        val bioBox = itemView.findViewById<TextView>(R.id.textViewBio)
        val creationDateBox = itemView.findViewById<TextView>(R.id.textViewCreationDate)

        val image = itemView.findViewById<ImageView>(R.id.imageView)
        val deleteButton = itemView.findViewById<ImageButton>(R.id.imageButton)

        // on Click Listener //
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
        // On Click Listener //
        init {
            deleteButton.setOnClickListener {
                dlistener.onDeleteButtonClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.profile_layout, parent, false)

        return ViewHolder(contactView, /* On click Listener */ mListener, bListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val profile: Profile = profileInstance[position]

        val name = holder.nameBox
        name.text = profile.displayName

        val age = holder.ageBox
        age.text = profile.age.toString()

        val bio = holder.bioBox
        bio.text = profile.bio

        val creationDate = holder.creationDateBox
        creationDate.text = profile.accountCreationDate

        val profileImage = holder.image
        profileImage.setImageResource(R.drawable.ic_launcher_foreground)
    }

    override fun getItemCount(): Int {
        return profileInstance.size
    }




}