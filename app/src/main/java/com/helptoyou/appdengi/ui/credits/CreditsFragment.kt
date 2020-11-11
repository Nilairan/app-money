package com.helptoyou.appdengi.ui.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.*
import com.helptoyou.appdengi.databinding.FragmentCreditsBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import org.koin.core.component.KoinApiExtension

@KoinApiExtension
class CreditsFragment : Fragment(), BackButtonListener {

    private lateinit var binding: FragmentCreditsBinding
    private val viewModel: CreditsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel.addLifecycleObserver(lifecycle)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreditsBinding.inflate(inflater, container, false)
        binding.toolbar.title.text = getString(R.string.credits)
        binding.toolbar.backImage.setOnClickListener {
            onBackPressed()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.creditsListLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.creditsList.layoutManager = LinearLayoutManager(context)
                    binding.creditsList.adapter = GroupAdapter<GroupieViewHolder>().apply { addAll(it.data.map { credit -> CreditItem(credit, viewModel::clickToDetail, viewModel::clickToSubmit) }) }
                }
                is Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Error -> {
                    binding.progressBar.visibility = View.GONE
                    context?.let { context -> context.openErrorAlert() }
                }
            }
        })
    }

    companion object {
        fun newInstance() = CreditsFragment()
    }

    override fun onBackPressed(): Boolean {
        viewModel.onBackPressed()
        return true
    }

}