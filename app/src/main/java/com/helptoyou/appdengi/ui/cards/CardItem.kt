package com.helptoyou.appdengi.ui.cards

import android.view.View
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.loadImage
import com.helptoyou.appdengi.databinding.ItemCardBinding
import com.helptoyou.domain.model.Card
import com.xwray.groupie.viewbinding.BindableItem

class CardItem(
    private val card: Card,
    private val detailListener: (String) -> Unit
) : BindableItem<ItemCardBinding>() {
    override fun bind(viewBinding: ItemCardBinding, position: Int) {
        viewBinding.cardName.text = card.name
        viewBinding.limitText.text = card.priceInfo
        viewBinding.detailText.text = card.text
        viewBinding.imageCard.loadImage(card.imageUrl)
        viewBinding.detailButton.setOnClickListener { detailListener(card.url) }
    }

    override fun getLayout(): Int {
        return R.layout.item_card
    }

    override fun initializeViewBinding(view: View): ItemCardBinding {
        return ItemCardBinding.bind(view)
    }
}