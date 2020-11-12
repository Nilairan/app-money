package com.helptoyou.appdengi.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.*
import com.helptoyou.appdengi.databinding.FragmentCardBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class CardsFragment : Fragment(), BackButtonListener {

    private val viewModel: CardsViewModel by viewModels()
    private lateinit var binding: FragmentCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.addLifecycleObserver(lifecycle)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = getString(R.string.bank_card)
        binding.toolbar.backImage.setOnClickListener { onBackPressed() }
        viewModel.cardsListLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.cardList.layoutManager = LinearLayoutManager(context)
                    binding.cardList.adapter = GroupAdapter<GroupieViewHolder>().apply {
                        addAll(it.data.map { card ->
                            CardItem(
                                card,
                                viewModel::onOpenUrl
                            )
                        })
                    }
                }
                is Loading -> binding.progressBar.visibility = View.VISIBLE
                is Error -> context?.openErrorAlert()
            }
        })
    }

    companion object {
        fun newInstance() = CardsFragment()
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }
}