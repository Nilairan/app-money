package com.helptoyou.appdengi.ui.policy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.R
import com.helptoyou.appdengi.common.BackButtonListener
import com.helptoyou.appdengi.databinding.FragmentPolicyBinding
import org.koin.android.ext.android.inject

class PolicyFragment : Fragment(), BackButtonListener {

    private val router: Router by inject()
    private lateinit var binding: FragmentPolicyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPolicyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = getString(R.string.privacy_policy)
        binding.toolbar.backImage.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {
        fun newInstance() = PolicyFragment()
    }
}