package com.helptoyou.appdengi.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updatePadding
import com.github.terrakok.cicerone.Command
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.BackButtonListener
import com.helptoyou.appdengi.common.doOnApplyWindowInsets
import com.helptoyou.appdengi.databinding.ActivityMainBinding
import com.helptoyou.appdengi.routing.Screens
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val navigatorHolder: NavigatorHolder by inject()
    private val navigator: Navigator = object : AppNavigator(this, R.id.nav_host_fragment) {
        override fun applyCommands(commands: Array<out Command>) {
            super.applyCommands(commands)
            supportFragmentManager.executePendingTransactions()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.doOnApplyWindowInsets { view, insets, padding ->
            view.updatePadding(top = padding.top + insets.systemWindowInsetTop)
            insets
        }
        navigator.applyCommands(arrayOf<Command>(Replace(Screens.Menu())))
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (fragment != null && fragment is BackButtonListener
            && (fragment as BackButtonListener).onBackPressed()
        ) {
            return
        } else {
            super.onBackPressed()
        }
    }
}