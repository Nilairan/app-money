package com.helptoyou.appdengi.ui.news.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.BackButtonListener
import com.helptoyou.appdengi.common.loadImage
import com.helptoyou.appdengi.databinding.FragmentNewsInfoBinding
import com.helptoyou.domain.model.News
import org.koin.android.ext.android.inject

class NewsInfoFragment : Fragment(), BackButtonListener {

    private val router: Router by inject()
    private lateinit var binding: FragmentNewsInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = getString(R.string.news)
        binding.toolbar.backImage.setOnClickListener { onBackPressed() }
        val news = arguments?.getSerializable(NEWS) as News
        binding.titleText.text = news.title
        binding.text.text = news.text
        binding.logo.loadImage(news.imageUrl)
    }

    companion object {
        private const val NEWS = "NEWS"

        fun newInstance(news: News) = NewsInfoFragment().apply {
            arguments = Bundle().apply {
                putSerializable(NEWS, news)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}