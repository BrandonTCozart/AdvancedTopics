package com.example.advancedtopics.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedtopics.Classes.AuthorQuote
import com.example.advancedtopics.Classes.Profile
import com.example.advancedtopics.DataClass.QuoteList
import com.example.advancedtopics.DataClass.Result
import com.example.advancedtopics.R

class quoteAdapter(private val resultList: List<AuthorQuote>): RecyclerView.Adapter<quoteAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var authorName = itemView.findViewById<TextView>(R.id.textViewAuthorName)
        var quote = itemView.findViewById<TextView>(R.id.textViewAuthorQuote)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quoteAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.quoters_layout, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: quoteAdapter.ViewHolder, position: Int) {
        val result: AuthorQuote = resultList[position]

        val name1 = holder.authorName
        name1.text = result.aName

        val quote = holder.quote
        quote.text = result.aQuote
    }

    override fun getItemCount(): Int {

        return resultList.size

    }
}