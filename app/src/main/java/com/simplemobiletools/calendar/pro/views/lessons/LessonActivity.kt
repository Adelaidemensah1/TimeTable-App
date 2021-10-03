package com.simplemobiletools.calendar.pro.views.lessons

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.databinding.ActivityLessonBinding
 import com.simplemobiletools.calendar.pro.model.OnlineLearningPlatform
import com.simplemobiletools.calendar.pro.views.activities.LessonDetailActivity

class LessonActivity : AppCompatActivity(), OnlineLearningPlatformAdapter.OnItemClickListener {
    private lateinit var viewModel: LessonViewModel
    private var adapter: OnlineLearningPlatformAdapter? = null
    private lateinit var binding: ActivityLessonBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_lesson)
        viewModel = ViewModelProvider(this).get(LessonViewModel::class.java)

        binding.rvLessons.setHasFixedSize(true)
        binding.rvLessons.layoutManager = LinearLayoutManager(this)
        adapter = OnlineLearningPlatformAdapter(this)
        binding.rvLessons.itemAnimator = DefaultItemAnimator()
        binding.rvLessons.adapter = adapter

    }



    /** Called when returning to the activity  */
    override fun onResume() {
        super.onResume()
        viewModel.allLessons().observe(this, {
            adapter?.submitList(it)
            adapter?.notifyDataSetChanged()
        })
    }

    override fun onItemClick(lesson: OnlineLearningPlatform) {
        val intent = Intent(this, LessonDetailActivity::class.java)
        intent.putExtra("lesson", lesson)
        startActivity(intent)
    }
}