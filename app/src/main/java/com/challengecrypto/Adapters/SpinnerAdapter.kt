package com.challengecrypto.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.challengecrypto.R

class SpinnerAdapter(
    context: Context, objects: Array<String>, imageArray: Array<Int>) : ArrayAdapter<String?>(context, R.layout.my_spinner_item, R.id.text_spinner, objects) {
    private val ctx: Context
    private val contentArray: Array<String>
    private val imageArray: Array<Int>

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getCustomView(position, convertView, parent)
    }



    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater: LayoutInflater = ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val row: View = inflater.inflate(R.layout.my_spinner_item, parent, false)
        val textView: TextView = row.findViewById(R.id.text_spinner) as TextView
        textView.setText(contentArray[position])
        val imageView: ImageView = row.findViewById(R.id.iv_icon) as ImageView
        imageView.setImageResource(imageArray[position])
        return row
    }

    init {
        ctx = context
        contentArray = objects
        this.imageArray = imageArray
    }
}