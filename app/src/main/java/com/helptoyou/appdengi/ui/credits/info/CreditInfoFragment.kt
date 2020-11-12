package com.helptoyou.appdengi.ui.credits.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.BackButtonListener
import com.helptoyou.appdengi.common.loadImage
import com.helptoyou.appdengi.databinding.FragmentCreditInfoBinding
import com.helptoyou.appdengi.routing.Screens
import com.helptoyou.domain.model.Credit
import org.koin.android.ext.android.inject

class CreditInfoFragment : Fragment(), BackButtonListener {

    private lateinit var binding: FragmentCreditInfoBinding
    private val router: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreditInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = getString(R.string.zaem)
        binding.toolbar.backImage.setOnClickListener { onBackPressed() }
        val credit: Credit = arguments?.getSerializable(CREDIT) as Credit
        binding.docText.text = credit.dokuments
        binding.workText.text = credit.workTime
        binding.percentText.text = credit.percent
        binding.yearText.text = credit.age
        binding.imageLogo.loadImage(credit.imageUrl)
        binding.submitButton.setOnClickListener {
            router.navigateTo(Screens.GoogleUrl(credit.url))
        }
    }

    companion object {
        const val CREDIT = "CREDIT"
        fun newInstance(credit: Credit) = CreditInfoFragment().apply {
            arguments = Bundle().apply {
                putSerializable(CREDIT, credit)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}