package com.example.advancedtopics.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.advancedtopics.DataClass.QuoteList
import com.example.advancedtopics.R

class quoteAdapter: RecyclerView.Adapter<quoteAdapter.ViewHolder>(){
    private var resultList: List<com.example.advancedtopics.DataClass.Result>? = null

    fun setQuoteList(resultList: List<com.example.advancedtopics.DataClass.Result>?){
        this.resultList = resultList
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quoteAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.quoters_layout, parent, false)
        return ViewHolder(contactView)
    }



    override fun onBindViewHolder(holder: quoteAdapter.ViewHolder, position: Int) {

        val result: com.example.advancedtopics.DataClass.Result = resultList!![position]

        val name1 = holder.authorName
        name1.text = result.author

        val quote = holder.quote
        quote.text = result.content


    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var authorName = itemView.findViewById<TextView>(R.id.textViewAuthorName)
        var quote = itemView.findViewById<TextView>(R.id.textViewAuthorQuote)


    }



    override fun getItemCount(): Int {

        if(resultList == null){
            return 0

        }else{
            return resultList?.size!!
        }

    }
}