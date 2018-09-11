package com.thesachlab.newsapp.home.presenter

import com.thesachlab.newsapp.home.model.NewsIntractor
import com.thesachlab.newsapp.home.model.NewsItems
import com.thesachlab.newsapp.home.view.HomeView

class NewsPresenter(private var newsHomeView: HomeView?,private val newsIntractor: NewsIntractor):NewsIntractor.OnFinishedListener{

    fun getNewsData(){
        newsHomeView?.showProgress()
        newsIntractor.requestNewsListData(this)
    }
    fun onDestory(){
        newsHomeView=null
    }

    override fun onSuccess(newsItems: List<NewsItems.Response>) {
        newsHomeView?.hideProgress()
        newsHomeView?.setNewsData(newsItems)

    }

    override fun onFailed(error: String) {
        newsHomeView?.hideProgress()
        newsHomeView?.onResultFailed(error)

    }


}