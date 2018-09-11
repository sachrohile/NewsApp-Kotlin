package com.thesachlab.newsapp.home.view

import android.content.Context
import android.os.Build
import android.support.v4.view.PagerAdapter
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.thesachlab.newsapp.R
import com.thesachlab.newsapp.home.model.NewsItems
import kotlinx.android.synthetic.main.layout_news_list_item.view.*


class HomePageAdapter(private val context: Context, private val newsItems: List<NewsItems.Response>,private val trCatName: String) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(R.layout.layout_news_list_item, container, false) as ViewGroup

        layout.txt_news_title.setText(newsItems.get(position).newsNm)
        Glide.with(context).load(newsItems.get(position).newsPhotoLarge).into(layout.img_news_pic)
        layout.txt_news_details.setText(fromHtml(newsItems.get(position).newsDesc!!))
        layout.txt_news_date.text = newsItems[position].newsCrtDt
        layout.txt_news_cat.text=trCatName


        container.addView(layout)
        return layout
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun getCount(): Int {

        return newsItems.size
    }

    fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }
}