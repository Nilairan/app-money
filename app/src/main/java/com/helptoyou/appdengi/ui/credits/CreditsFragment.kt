package com.helptoyou.appdengi.ui.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.BackButtonListener
import com.helptoyou.appdengi.common.Error
import com.helptoyou.appdengi.common.Loading
import com.helptoyou.appdengi.common.Success
import com.helptoyou.appdengi.databinding.FragmentCreditsBinding
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
                    print(it.data)
                }
                is Loading -> {
                    print("LOADING")
                }
                is Error -> {
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