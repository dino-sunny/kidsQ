package com.dino.kidsq.won

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dino.kidsq.R

class WonFragment : Fragment() {

    companion object {
        fun newInstance() = WonFragment()
    }

    private lateinit var viewModel: WonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.won_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}