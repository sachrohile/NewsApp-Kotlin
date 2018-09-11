package com.thesachlab.newsapp.home.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.thesachlab.newsapp.R
import com.thesachlab.newsapp.home.model.NewsIntractor
import com.thesachlab.newsapp.home.model.NewsItems
import com.thesachlab.newsapp.home.presenter.NewsPresenter
import kotlinx.android.synthetic.main.layout_news_home.*



class HomeActivity : AppCompatActivity(), HomeView {
    override fun setNewsData(newsItems: List<NewsItems.Response>) {

        homePageAdapter=HomePageAdapter(this,newsItems,getString(R.string.str_imp_news))
        viewpager.adapter=homePageAdapter

    }

    override fun onResultFailed(string: String) {

    }

    private lateinit var homePageAdapter: HomePageAdapter
    private lateinit var newsHomePresenter: NewsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        newsHomePresenter = NewsPresenter(this, NewsIntractor())
        newsHomePresenter.getNewsData()
    }

    override fun showProgress() {
        progressbar.visibility = View.VISIBLE

    }

    override fun hideProgress() {
        progressbar.visibility = View.INVISIBLE
    }
}
