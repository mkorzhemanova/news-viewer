package com.epam.newsviewer.dao

import android.content.Context
import com.epam.newsviewer.dto.NewsItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.nio.charset.Charset
import java.util.ArrayList

class NewsRepository(val context: Context) {

    companion object {
        val NEWS_FILENAME = "news.json"
        val GSON = Gson()
    }

    fun loadNews(): ArrayList<NewsItem> {
        return loadNewsFromJsonFile()
    }

    private fun loadNewsFromJsonFile(): ArrayList<NewsItem> {
        val newsJsonString = readFileToStringFromAssets(NEWS_FILENAME)
        return parseNewsFromJsonString(newsJsonString)
    }

    private fun readFileToStringFromAssets(fileName: String): String {
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer, Charset.forName("UTF-8"))
        } catch (e: IOException) {
            // TODO exception handling
            e.printStackTrace()
            throw e
        }
    }

    private fun parseNewsFromJsonString(jsonString: String): ArrayList<NewsItem> {
        val collectionType = object : TypeToken<ArrayList<NewsItem>>() {}.type
        return GSON.fromJson<ArrayList<NewsItem>>(jsonString, collectionType)
    }
}