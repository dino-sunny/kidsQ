package com.dino.kidsq.questions

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dino.kidsq.R
import com.dino.kidsq.databinding.QuestionsFragmentBinding
import com.dino.kidsq.utils.Utils

class QuestionsFragment : Fragment() {

    companion object {
        fun newInstance() = QuestionsFragment()
    }

    private lateinit var viewModel: QuestionsViewModel
    private lateinit var binding: QuestionsFragmentBinding
    private var questionIndex = 0
    lateinit var currentQuestion: QuestionsViewModel.Question
    lateinit var answers: MutableList<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.questions_fragment, container, false)

        activity?.let { Utils.setStatusIconColors(it,"#FFC107") }

        viewModel = ViewModelProvider(this).get(QuestionsViewModel::class.java)
        binding.questionViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val args = QuestionsFragmentArgs.fromBundle(requireArguments())
        binding.textView.text = "Hi ${args.user}"
        randomizeQuestions()

        return binding.root
    }

    private fun randomizeQuestions() {
        viewModel.questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        currentQuestion = viewModel.questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()

        binding.title.text = currentQuestion.text
        binding.firstAnswerRadioButton.text = answers[0]
        binding.secondAnswerRadioButton.text = answers[1]
        binding.thirdAnswerRadioButton.text = answers[2]
        binding.fourthAnswerRadioButton.text = answers[3]

    }
}