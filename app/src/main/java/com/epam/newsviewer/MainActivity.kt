package com.epam.newsviewer

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import com.epam.newsviewer.dao.NewsRepository
import com.epam.newsviewer.dto.NewsItem
import java.util.*


class MainActivity : AppCompatActivity() {

    private var newsRepository = NewsRepository(this)
    private var news = ArrayList<NewsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsListView = findViewById<ListView>(R.id.lvNewsList)

        news = newsRepository.loadNews()

        val adapter = NewsItemAdapter(this, news)

        newsListView.adapter = adapter
    }
}
