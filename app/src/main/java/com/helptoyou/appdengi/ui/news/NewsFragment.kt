package com.helptoyou.appdengi.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.*
import com.helptoyou.appdengi.databinding.FragmentNewsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class NewsFragment : Fragment(), BackButtonListener {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.addLifecycleObserver(lifecycle)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = getString(R.string.news)
        binding.toolbar.backImage.setOnClickListener { onBackPressed() }
        viewModel.newsListLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.newsList.layoutManager = LinearLayoutManager(context)
                    binding.newsList.adapter = GroupAdapter<GroupieViewHolder>().apply {
                        addAll(it.data.map { card ->
                            NewsItem(
                                card,
                                viewModel::openNews
                            )
                        })
                    }
                }
                is Loading -> binding.progressBar.visibility = View.VISIBLE
                is Error -> context?.openErrorAlert()
            }
        })
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }

    companion object {
        fun newInstance() = NewsFragment()
    }
}