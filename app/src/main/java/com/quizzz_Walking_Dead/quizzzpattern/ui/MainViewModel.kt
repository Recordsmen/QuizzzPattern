package com.quizzz_Walking_Dead.quizzzpattern.ui

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quizzz_Walking_Dead.quizzzpattern.R

class MainViewModel(context: Context) : ViewModel() {

    val question = MutableLiveData<String?>()
    val firstButton = MutableLiveData<String?>()
    val secondButton = MutableLiveData<String?>()
    val thirdButton = MutableLiveData<String?>()
    val fourButton = MutableLiveData<String?>()

    val end = MutableLiveData<Boolean>()
    val score = MutableLiveData<Int>()
    @SuppressLint("StaticFieldLeak")
    var contextI:Context

    private var questionAnswers:MutableMap<String,Boolean> = mutableMapOf()
    private var questionDescription:String = ""
    private var buttons = listOf<String>()
    private var completeQuestion:Pair<Map<String,Boolean>,Pair<List<String>,String>> = Pair(questionAnswers, Pair(buttons, questionDescription))
    private var listQuestions:MutableList<Pair<Map<String,Boolean>,Pair<List<String>,String>>> = mutableListOf()
    private lateinit var currentQuestion:Pair<Map<String,Boolean>,Pair<List<String>,String>>
    private var scoreInt = 0
    init {
        contextI = context
        setData(context)
        setFirstQuestion()
    }
    fun restartGame(){
        questionAnswers = mutableMapOf()
        questionDescription = ""
        buttons = listOf()
        completeQuestion = Pair(questionAnswers, Pair(buttons, questionDescription))
        listQuestions = mutableListOf()
        score.value = 0
        scoreInt = 0
        end.value = false
        setData(context = contextI)
        setFirstQuestion()
    }
    private fun setData(context: Context){

        questionAnswers[context.getString(R.string.question_1_1)] = false
        questionAnswers[context.getString(R.string.question_1_correct)] = true
        questionAnswers[context.getString(R.string.question_1_2)] = false
        questionAnswers[context.getString(R.string.question_1_3)] = false
        questionDescription = context.getString(R.string.question_1)
        buttons = listOf(
            context.getString(R.string.question_1_1),
            context.getString(R.string.question_1_correct),
            context.getString(R.string.question_1_2),
            context.getString(R.string.question_1_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_2_correct)] = true
        questionAnswers[context.getString(R.string.question_2_1)] = false
        questionAnswers[context.getString(R.string.question_2_2)] = false
        questionAnswers[context.getString(R.string.question_2_3)] = false
        questionDescription = context.getString(R.string.question_2)
        buttons = listOf(
            context.getString(R.string.question_2_correct),
            context.getString(R.string.question_2_1),
            context.getString(R.string.question_2_2),
            context.getString(R.string.question_2_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_3_correct)] = true
        questionAnswers[context.getString(R.string.question_3_1)] = false
        questionAnswers[context.getString(R.string.question_3_2)] = false
        questionAnswers[context.getString(R.string.question_3_3)] = false
        questionDescription = context.getString(R.string.question_3)
        buttons = listOf(
            context.getString(R.string.question_3_correct),
            context.getString(R.string.question_3_1),
            context.getString(R.string.question_3_2),
            context.getString(R.string.question_3_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_4_correct)] = true
        questionAnswers[context.getString(R.string.question_4_1)] = false
        questionAnswers[context.getString(R.string.question_4_2)] = false
        questionAnswers[context.getString(R.string.question_4_3)] = false
        questionDescription = context.getString(R.string.question_4)
        buttons = listOf(
            context.getString(R.string.question_4_correct),
            context.getString(R.string.question_4_1),
            context.getString(R.string.question_4_2),
            context.getString(R.string.question_4_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_5_correct)] = true
        questionAnswers[context.getString(R.string.question_5_1)] = false
        questionAnswers[context.getString(R.string.question_5_2)] = false
        questionAnswers[context.getString(R.string.question_5_3)] = false
        questionDescription = context.getString(R.string.question_5)
        buttons = listOf(
            context.getString(R.string.question_5_correct),
            context.getString(R.string.question_5_1),
            context.getString(R.string.question_5_2),
            context.getString(R.string.question_5_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_6_correct)] = true
        questionAnswers[context.getString(R.string.question_6_1)] = false
        questionAnswers[context.getString(R.string.question_6_2)] = false
        questionAnswers[context.getString(R.string.question_6_3)] = false
        questionDescription = context.getString(R.string.question_6)
        buttons = listOf(
            context.getString(R.string.question_6_correct),
            context.getString(R.string.question_6_1),
            context.getString(R.string.question_6_2),
            context.getString(R.string.question_6_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_7_correct)] = true
        questionAnswers[context.getString(R.string.question_7_1)] = false
        questionAnswers[context.getString(R.string.question_7_2)] = false
        questionAnswers[context.getString(R.string.question_7_3)] = false
        questionDescription = context.getString(R.string.question_7)
        buttons = listOf(
            context.getString(R.string.question_7_correct),
            context.getString(R.string.question_7_1),
            context.getString(R.string.question_7_2),
            context.getString(R.string.question_7_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_8_correct)] = true
        questionAnswers[context.getString(R.string.question_8_1)] = false
        questionAnswers[context.getString(R.string.question_8_2)] = false
        questionAnswers[context.getString(R.string.question_8_3)] = false
        questionDescription = context.getString(R.string.question_8)
        buttons = listOf(
            context.getString(R.string.question_8_correct),
            context.getString(R.string.question_8_1),
            context.getString(R.string.question_8_2),
            context.getString(R.string.question_8_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_9_correct)] = true
        questionAnswers[context.getString(R.string.question_9_1)] = false
        questionAnswers[context.getString(R.string.question_9_2)] = false
        questionAnswers[context.getString(R.string.question_9_3)] = false
        questionDescription = context.getString(R.string.question_9)
        buttons = listOf(
            context.getString(R.string.question_9_correct),
            context.getString(R.string.question_9_1),
            context.getString(R.string.question_9_2),
            context.getString(R.string.question_9_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers[context.getString(R.string.question_10_correct)] = true
        questionAnswers[context.getString(R.string.question_10_1)] = false
        questionAnswers[context.getString(R.string.question_10_2)] = false
        questionAnswers[context.getString(R.string.question_10_3)] = false
        questionDescription = context.getString(R.string.question_10)
        buttons = listOf(
            context.getString(R.string.question_10_correct),
            context.getString(R.string.question_10_1),
            context.getString(R.string.question_10_2),
            context.getString(R.string.question_10_3))
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        listQuestions.shuffle()
    }
    fun nextQuestion(answer:String){
        if (currentQuestion.first[answer] == true){
            scoreInt++
            score.value = scoreInt
        }
        listQuestions.removeAt(0)
        Log.i("ListQuestions",listQuestions.size.toString())
        if (listQuestions.size == 1 ){
            end.value = true
            Log.i("ListQuestions","END")
        }
        val firstQuestion = listQuestions.first()
        question.value = firstQuestion.second.second
        firstButton.value = firstQuestion.second.first[0]
        secondButton.value = firstQuestion.second.first[1]
        thirdButton.value = firstQuestion.second.first[2]
        fourButton.value = firstQuestion.second.first[3]
    }
    private fun setFirstQuestion(){
        val firstQuestion = listQuestions.first()
        currentQuestion = listQuestions.first()
        question.value = firstQuestion.second.second
        firstButton.value = firstQuestion.second.first[0]
        secondButton.value = firstQuestion.second.first[1]
        thirdButton.value = firstQuestion.second.first[2]
        fourButton.value = firstQuestion.second.first[3]
    }
}