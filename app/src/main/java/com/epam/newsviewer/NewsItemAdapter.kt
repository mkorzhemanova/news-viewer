package com.epam.newsviewer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.epam.newsviewer.dto.NewsItem


class NewsItemAdapter(context: Context, users: ArrayList<NewsItem>) : ArrayAdapter<NewsItem>(context, 0, users) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var rowView = convertView
        if (rowView == null) {
            rowView = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        }

        val newsItem = getItem(position)

        val tvHeader = rowView!!.findViewById(R.id.tvNewsHeader) as TextView
        tvHeader.text = newsItem!!.header

        val tvText = rowView.findViewById(R.id.tvNewsText) as TextView
        tvText.text = newsItem.text

        return rowView
    }
}