package com.example.quizzzpattern.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val question = MutableLiveData<String?>()
    val firstButton = MutableLiveData<String?>()
    val secondButton = MutableLiveData<String?>()
    val thirdButton = MutableLiveData<String?>()
    val fourButton = MutableLiveData<String?>()

    val end = MutableLiveData<Boolean>()
    val score = MutableLiveData<Int>()

    private var questionAnswers:MutableMap<String,Boolean> = mutableMapOf()
    private var questionDescription:String = ""
    private var buttons = listOf<String>()
    private var completeQuestion:Pair<Map<String,Boolean>,Pair<List<String>,String>> = Pair(questionAnswers, Pair(buttons, questionDescription))
    private var listQuestions:MutableList<Pair<Map<String,Boolean>,Pair<List<String>,String>>> = mutableListOf()
    private lateinit var currentQuestion:Pair<Map<String,Boolean>,Pair<List<String>,String>>
    private var scoreInt = 0
    init {
        setData()
        setFirstQuestion()
    }
    fun restartGame(){
        questionAnswers = mutableMapOf()
        questionDescription = ""
        buttons = listOf<String>()
        completeQuestion = Pair(questionAnswers, Pair(buttons, questionDescription))
        listQuestions = mutableListOf()
        score.value = 0
        scoreInt = 0
        end.value = false
        setData()
        setFirstQuestion()
    }
    private fun setData(){
        questionAnswers["1"] = false
        questionAnswers["2"] = true
        questionAnswers["3"] = false
        questionAnswers["4"] = false
        questionDescription = "Сколько детей в семье Аддамс?"
        buttons = listOf("1","2","3","4")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Вещь"] = true
        questionAnswers["Стул"] = false
        questionAnswers["Рука"] = false
        questionAnswers["Нож"] = false
        questionDescription = "Как зовут руку в семье Аддамс?"
        buttons = listOf("Вещь","Стул","Рука","Нож")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["15"] = false
        questionAnswers["16"] = true
        questionAnswers["17"] = false
        questionAnswers["18"] = false
        questionDescription = "Сколько лет Уенсдей?"
        buttons = listOf("15","16","17","18")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Пагли"] = false
        questionAnswers["Пагсли"] = true
        questionAnswers["Пугсли"] = false
        questionAnswers["Пигли"] = false
        questionDescription = "Как зовут брата Уенсдей?"
        buttons = listOf("Пагли","Пагсли","Пугсли","Пигли")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Не пьянеть"] = false
        questionAnswers["Маскировка"] = true
        questionAnswers["Регенерация"] = false
        questionAnswers["Гиперразум"] = false
        questionDescription = "Какой способностью обладает дирректриса Аккадемии?"
        buttons = listOf("Не пьянеть","Маскировка","Регенерация","Гиперразум")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Белый"] = false
        questionAnswers["Чёрный"] = true
        questionAnswers["Желтый"] = false
        questionAnswers["Фиолетовый"] = false
        questionDescription = "Любимый цвет Уенсдей?"
        buttons = listOf("Белый","Чёрный","Желтый","Фиолетовый")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["10"] = false
        questionAnswers["12"] = true
        questionAnswers["14"] = false
        questionAnswers["16"] = false
        questionDescription = "Во сколько лет оборотни перерождаются?"
        buttons = listOf("10","12","14","16")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Убийство"] = true
        questionAnswers["Кража"] = false
        questionAnswers["Изнасилование"] = false
        questionAnswers["Мошенничество"] = false
        questionDescription = "В каком приступлении подозревают Гомера?"
        buttons = listOf("Убийство","Кража","Изнасиование","Мошенничество")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Неверстоп"] = false
        questionAnswers["Невергон"] = false
        questionAnswers["Невермор"] = true
        questionAnswers["Невердор"] = false
        questionDescription = "Как называется Академия Уенсдей?"
        buttons = listOf("Неверстоп","Невермор","Невердор","Невергон")
        completeQuestion = Pair(questionAnswers, Pair(buttons,questionDescription))
        listQuestions.add(completeQuestion)
        questionAnswers["Казахстан"] = false
        questionAnswers["ОАЭ"] = false
        questionAnswers["Румыния"] = true
        questionAnswers["Польша"] = false
        questionDescription = "В какой стране проходили сьемки?"
        buttons = listOf("Казахстан","ОАЭ","Румыния","Польша")
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