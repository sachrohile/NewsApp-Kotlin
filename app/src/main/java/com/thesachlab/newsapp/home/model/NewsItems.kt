package com.thesachlab.newsapp.home.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class NewsItems {
    @SerializedName("news_details")
    @Expose
    private var newsDetails: NewsDetails? = null

    fun getNewsDetails(): NewsDetails? {
        return newsDetails
    }

    fun setNewsDetails(newsDetails: NewsDetails) {
        this.newsDetails = newsDetails
    }

    inner class NewsDetails {

        @SerializedName("Message")
        @Expose
        var message: String? = null
        @SerializedName("Response")
        @Expose
         var response: List<Response>? = null

    }

     inner class Response {

        @SerializedName("news_pk")
        @Expose
        var newsPk: String? = null
        @SerializedName("news_nm")
        @Expose
        var newsNm: String? = null
        @SerializedName("news_desc")
        @Expose
        var newsDesc: String? = null
        @SerializedName("news_photo_small")
        @Expose
        var newsPhotoSmall: Any? = null
        @SerializedName("news_photo_large")
        @Expose
        var newsPhotoLarge: String? = null
        @SerializedName("news_video")
        @Expose
        var newsVideo: Any? = null
        @SerializedName("adv_nm")
        @Expose
        var advNm: String? = null
        @SerializedName("adv_photo_small")
        @Expose
        var advPhotoSmall: String? = null
        @SerializedName("adv_photo_large")
        @Expose
        var advPhotoLarge: String? = null
        @SerializedName("news_disp_seq")
        @Expose
        var newsDispSeq: String? = null
        @SerializedName("news_pub_dt")
        @Expose
        var newsPubDt: String? = null
        @SerializedName("news_crt_dt")
        @Expose
        var newsCrtDt: String? = null
        @SerializedName("news_upd_dt")
        @Expose
        var newsUpdDt: String? = null

    }
}