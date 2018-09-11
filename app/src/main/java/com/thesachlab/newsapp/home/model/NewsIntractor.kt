package com.thesachlab.newsapp.home.model

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class NewsIntractor {
    companion object {
        val TAG: String = NewsIntractor::class.java.simpleName
    }

    interface OnFinishedListener {
        fun onSuccess(newsItems: List<NewsItems.Response>)
        fun onFailed(error: String)
    }

    fun requestNewsListData(onFinishedListener: OnFinishedListener) {
        Log.e(TAG,"Network Calling")
        AndroidNetworking.get("http://dhangarmaza.com/loadAllNewsByCategoryId.php?cat_pk=54")
                .setTag(TAG)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(NewsItems::class.java, object : ParsedRequestListener<NewsItems> {
                    override fun onResponse(response: NewsItems?) {

                        Log.e(TAG,"Network Calling - "+response?.getNewsDetails()?.message)
                        if (response?.getNewsDetails()?.message.equals("success")) {

                            var data:List<NewsItems.Response>?= response?.getNewsDetails()?.response

                            onFinishedListener.onSuccess(data!!)

                        } else {
                            onFinishedListener.onFailed("Something went wrong")
                        }

                    }

                    override fun onError(anError: ANError?) {
                        onFinishedListener.onFailed("Something went wrong")
                    }

                })

    }
}