package com.helptoyou.appdengi.routing

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.helptoyou.appdengi.ui.credits.CreditsFragment
import com.helptoyou.appdengi.ui.menu.MenuFragment
import org.koin.core.component.KoinApiExtension

object Screens {

    fun Menu() = FragmentScreen("MenuFragment") {
        MenuFragment.newInstance()
    }

    @KoinApiExtension
    fun Credits() = FragmentScreen("CreditsFragment") {
        CreditsFragment.newInstance()
    }
}