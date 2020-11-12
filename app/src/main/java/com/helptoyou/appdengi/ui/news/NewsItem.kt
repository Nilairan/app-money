package com.helptoyou.appdengi.ui.news

import android.view.View
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.databinding.ItemNewsBinding
import com.helptoyou.domain.model.News
import com.xwray.groupie.viewbinding.BindableItem

class NewsItem(
    private val news: News,
    private val click: (News) -> Unit
) : BindableItem<ItemNewsBinding>() {
    override fun bind(viewBinding: ItemNewsBinding, position: Int) {
        viewBinding.title.text = news.title
        viewBinding.root.setOnClickListener { click(news) }
    }

    override fun getLayout(): Int {
        return R.layout.item_news
    }

    override fun initializeViewBinding(view: View): ItemNewsBinding {
        return ItemNewsBinding.bind(view)
    }
}