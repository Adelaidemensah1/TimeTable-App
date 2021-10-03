package com.simplemobiletools.calendar.pro.views.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType
import com.simplemobiletools.calendar.pro.R
import com.simplemobiletools.calendar.pro.views.auth.SignUpActivity


class AppIntroActivity : AppIntro() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Make sure you don't call setContentView!

        supportActionBar?.hide()
        setTransformer(AppIntroPageTransformerType.Flow)

        addSlide(
            AppIntroFragment.newInstance(
                "My Class",
                "A simple app to keep track of all your classes.",
                R.mipmap.ic_launcher,
                Color.DKGRAY
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                "All your courses at one place",
                "Update your classes at any time",
                R.mipmap.ic_launcher,
                Color.DKGRAY
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                "Manage different timetables",
                "Divide your calendar into 3 parts and add courses into any or all parts.",
                R.mipmap.ic_launcher,
                Color.DKGRAY
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                "Alerts!",
                "Get notifications before every class!",
                R.drawable.notif,
                Color.DKGRAY
            )
        )
        addSlide(
            AppIntroFragment.newInstance(
                "...Let's get started!",
                "This is the last slide, I won't annoy you more :)"
            )
        )
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        // Do something when users tap on Done button.
       // startActivity(Intent(this, SignUpActivity::class.java))

        finish()
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        // Do something when users tap on Skip button.
       // startActivity(Intent(this, SignUpActivity::class.java))

        finish()
    }


}
