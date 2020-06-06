package com.dino.kidsq.questions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionsViewModel : ViewModel() {

    private var questionIndex = 0

    private val question = MutableLiveData<Question>()
    val currentQuestion : LiveData<Question>
        get() = question

    private val answers = MutableLiveData<MutableList<String>>()
    val answersList : LiveData<MutableList<String>>
        get() = answers

    data class Question(
        val text: String,
        val answers: List<String>)

    val questions: MutableList<Question> = mutableListOf(
        Question(text = "A for?",
            answers = listOf("All of these", "Apple", "Ant", "Aqua")),
        Question(text = "How many legs are for a elephant?",
            answers = listOf("4", "5", "3", "2")),
        Question(text = "What is the color of Orange?",
            answers = listOf("Orange", "Red", "Blue", "Yellow")),
        Question(text = "Where do the fish live?",
            answers = listOf("Water", "Dessert", "Land", "Sky")),
        Question(text = "What is the color of sky?",
            answers = listOf("Blue", "Red", "Pink", "Orange")))

    init {
        randomizeQuestions()
    }

    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }

    private fun setQuestion() {
        question.value = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers.value = questions[questionIndex].answers.toMutableList()
        answers.value!!.shuffle()
    }

}

