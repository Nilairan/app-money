package com.helptoyou.appdengi.ui.credits.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.helptoyou.domain.model.Credit

class CreditInfoFragment : Fragment() {


    companion object {
        const val CREDIT = "CREDIT"
        fun newInstance(credit: Credit) = CreditInfoFragment().apply {
            arguments = Bundle().apply {
                putSerializable(CREDIT, credit)
            }
        }
    }
}