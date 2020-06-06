package com.dino.kidsq.questions

import androidx.lifecycle.ViewModel

class QuestionsViewModel : ViewModel() {

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
}