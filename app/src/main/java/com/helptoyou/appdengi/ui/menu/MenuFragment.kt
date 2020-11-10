package com.helptoyou.appdengi.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.helptoyou.appdengi.databinding.FragmentMenuBinding
import com.helptoyou.appdengi.routing.Screens
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinApiExtension

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private val routing: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    @KoinApiExtension
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loansContainer.setOnClickListener {
            routing.navigateTo(Screens.Credits())
        }
        binding.creditContainer.setOnClickListener {
            routing.navigateTo(Screens.Credits())
        }
    }

    companion object {
        fun newInstance() = MenuFragment()
    }
}