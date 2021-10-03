package com.simplemobiletools.calendar.pro


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.simplemobiletools.calendar.pro.databinding.ActivityHomeBinding
import com.simplemobiletools.calendar.pro.views.auth.SignUpActivity
import com.simplemobiletools.calendar.pro.extensions.Extensions.toast
import com.simplemobiletools.calendar.pro.utils.FirebaseUtils.firebaseAuth
import com.simplemobiletools.calendar.pro.views.adapters.ViewPagerAdapter
import com.simplemobiletools.calendar.pro.views.events.EventActivity

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var toolbar: Toolbar
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView: NavigationView
    private lateinit var drawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)


        //main toolbar
        toolbar = findViewById(R.id.topAppBar)
        setSupportActionBar(toolbar)

        navView = findViewById(R.id.nav_view)


        //drawer
        drawerLayout = findViewById(R.id.drawer_layout)
        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navView.setNavigationItemSelectedListener(this)


        //onboarding
        // startActivity(Intent(this, AppIntroActivity::class.java))


        //sign out a user
        binding.btnSignOut.setOnClickListener {
            firebaseAuth.signOut()
            startActivity(Intent(this, SignUpActivity::class.java))
            toast("signed out")
            finish()
        }

//viewpager
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = animalsArray[position]
        }.attach()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                toast("Home clicked")
            }
            R.id.nav_about -> {
                toast("About clicked")
            }
            R.id.nav_policy -> {
                toast("Policy clicked")
            }

            R.id.nav_account -> {
                toast("Account clicked")
            }
            R.id.nav_lesson -> {
                // Handle search icon press
                toast("Lessons clicked")
                startActivity(Intent(this, EventActivity::class.java))
            }
            R.id.nav_tools -> {
                // Handle search icon press
                toast("Settings clicked")
            }

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    //close drawer
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    //overflow menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        // menuInflater.inflate(R.menu.appbar_menu_main, menu)
        return true
    }

    //drawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
