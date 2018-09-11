package com.thesachlab.newsapp.home.view

import com.thesachlab.newsapp.home.model.NewsItems

interface HomeView {
    fun showProgress()
    fun hideProgress()
    fun setNewsData(newsItems: List<NewsItems.Response>)
    fun onResultFailed(string: String)
}