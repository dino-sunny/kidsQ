package com.dino.kidsq.questions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dino.kidsq.R
import com.dino.kidsq.databinding.QuestionsFragmentBinding
import com.dino.kidsq.utils.Utils

class QuestionsFragment : Fragment() {

    private lateinit var viewModel: QuestionsViewModel
    private lateinit var binding: QuestionsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.questions_fragment, container, false)

        activity?.let { Utils.setStatusIconColors(it,"#FFC107") }

        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        binding.questionViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val args = QuestionsFragmentArgs.fromBundle(requireArguments())
        binding.textView.text = "Hi ${args.user}"
        return binding.root
    }
}