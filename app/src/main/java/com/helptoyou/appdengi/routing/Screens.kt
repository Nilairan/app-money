package com.helptoyou.appdengi.routing

import android.content.Intent
import android.net.Uri
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.helptoyou.appdengi.ui.cards.CardsFragment
import com.helptoyou.appdengi.ui.credits.CreditsFragment
import com.helptoyou.appdengi.ui.credits.info.CreditInfoFragment
import com.helptoyou.appdengi.ui.menu.MenuFragment
import com.helptoyou.appdengi.ui.news.NewsFragment
import com.helptoyou.appdengi.ui.news.info.NewsInfoFragment
import com.helptoyou.appdengi.ui.policy.PolicyFragment
import com.helptoyou.domain.model.Credit
import com.helptoyou.domain.model.News
import org.koin.core.component.KoinApiExtension

object Screens {

    fun Menu() = FragmentScreen("MenuFragment") {
        MenuFragment.newInstance()
    }

    @KoinApiExtension
    fun Credits() = FragmentScreen("CreditsFragment") {
        CreditsFragment.newInstance()
    }

    fun GoogleUrl(url: String) = ActivityScreen("CreditsUrlActivity") {
        it.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        Intent()
    }

    fun CreditInfo(credit: Credit) = FragmentScreen("CreditInfoFragment") {
        CreditInfoFragment.newInstance(credit)
    }

    @KoinApiExtension
    fun Card() = FragmentScreen("CardFragment") {
        CardsFragment.newInstance()
    }

    @KoinApiExtension
    fun News() = FragmentScreen("NewsFragment") {
        NewsFragment.newInstance()
    }

    fun NewsInfo(news: News) = FragmentScreen("NewsInfoFragment") {
        NewsInfoFragment.newInstance(news)
    }

    fun PrivacyPolicy() = FragmentScreen("PrivacyPolicyFragment") {
        PolicyFragment.newInstance()
    }


}