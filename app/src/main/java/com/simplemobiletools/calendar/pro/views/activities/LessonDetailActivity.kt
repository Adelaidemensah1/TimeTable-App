package com.simplemobiletools.calendar.pro.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.databinding.ActivityLessonDetailBinding
import com.simplemobiletools.calendar.pro.model.OnlineLearningPlatform

class LessonDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLessonDetailBinding
    // private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson_detail)


        val lessons = intent.getParcelableExtra<OnlineLearningPlatform>("lesson")
        title = lessons?.olpTitle
        binding.detailWebView.loadUrl(lessons?.olpUrl.toString())
    }
}