package com.simplemobiletools.calendar.pro.views.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.simplemobiletools.calendar.pro.model.OnlineLearningPlatform
import com.simplemobiletools.calendar.pro.model.TimetableRepository


class LessonViewModel() : ViewModel() {
    var repository: TimetableRepository = TimetableRepository()

    fun allLessons(): LiveData<List<OnlineLearningPlatform>> = repository.getLessons()
}