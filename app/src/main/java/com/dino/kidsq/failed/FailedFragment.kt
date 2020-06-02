package com.dino.kidsq.failed

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dino.kidsq.R

class FailedFragment : Fragment() {

    companion object {
        fun newInstance() = FailedFragment()
    }

    private lateinit var viewModel: FailedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.failed_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FailedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}