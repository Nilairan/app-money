package com.helptoyou.appdengi.routing

import android.content.Intent
import android.net.Uri
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.helptoyou.appdengi.ui.credits.CreditsFragment
import com.helptoyou.appdengi.ui.credits.info.CreditInfoFragment
import com.helptoyou.appdengi.ui.menu.MenuFragment
import com.helptoyou.domain.model.Credit
import org.koin.core.component.KoinApiExtension

object Screens {

    fun Menu() = FragmentScreen("MenuFragment") {
        MenuFragment.newInstance()
    }

    @KoinApiExtension
    fun Credits() = FragmentScreen("CreditsFragment") {
        CreditsFragment.newInstance()
    }

    fun CreditsUrl(url: String) = ActivityScreen("CreditsUrlActivity") {
        it.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        Intent()
    }

    fun CreditInfo(credit: Credit) = FragmentScreen("CreditInfoFragment") {
        CreditInfoFragment.newInstance(credit)
    }
}