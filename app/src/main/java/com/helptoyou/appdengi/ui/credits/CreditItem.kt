package com.helptoyou.appdengi.ui.credits

import android.view.View
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.loadImage
import com.helptoyou.appdengi.databinding.ItemCreditBinding
import com.helptoyou.domain.model.Credit
import com.xwray.groupie.viewbinding.BindableItem

class CreditItem(
        private val credit: Credit,
        private val clickDetail: (Credit) -> Unit,
        private val submitDetail: (String) -> Unit
) : BindableItem<ItemCreditBinding>() {


    override fun getLayout(): Int {
        return R.layout.item_credit
    }

    override fun initializeViewBinding(view: View): ItemCreditBinding {
        return ItemCreditBinding.bind(view)
    }

    override fun bind(viewBinding: ItemCreditBinding, position: Int) {
        viewBinding.imageCredit.loadImage(credit.imageUrl)
        viewBinding.creditName.text = credit.name
        viewBinding.ratingText.text = credit.rating.toString()
        viewBinding.limitText.text = credit.sumOne
        viewBinding.percentText.text = credit.percent
        viewBinding.iconCircleCard.visibility = if (credit.nakartu) View.VISIBLE else View.INVISIBLE
        viewBinding.iconCircleNal.visibility = if (credit.nalichnie) View.VISIBLE else View.INVISIBLE
        viewBinding.iconCircleTime.visibility = if (credit.zafiveminut) View.VISIBLE else View.INVISIBLE
        viewBinding.iconCircleWorkTime.visibility = if (credit.kruglosutochno) View.VISIBLE else View.INVISIBLE
        viewBinding.detailButton.setOnClickListener { clickDetail(credit) }
        viewBinding.submitButton.setOnClickListener { submitDetail(credit.url) }
    }
}