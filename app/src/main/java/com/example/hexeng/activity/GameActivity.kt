package com.example.hexeng.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hexeng.R
import com.example.hexeng.model.Vocab
import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {

    private var randomVocabList: ArrayList<Vocab> = arrayListOf()
    private var round = 0
    private var totalscore = 0
    private var targetVocab = Vocab()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        val vocabList = intent.extras?.getParcelableArrayList<Vocab>("vocabList")


        for (i in 1..20) {
            var vocab = vocabList?.let { randomVocab(it) }

            if (vocab != null) {
                randomVocabList?.add(vocab)
            }
        }

        setupView()

        choice_one.setOnClickListener {
            if (evaluate(targetVocab.meaning.toString(),choice_one_text.text as String)) {
                totalscore += 10
                update()
            }
            else {
                update()
            }
        }

        choice_two.setOnClickListener {
            if (evaluate(targetVocab.meaning.toString(),choice_two_text.text as String)) {
                totalscore += 10
                update()
            }
            else {
                update()
            }
        }

        choice_three.setOnClickListener {
            if (evaluate(targetVocab.meaning.toString(),choice_three_text.text as String)) {
                totalscore += 10
                update()
            } else {
                update()
            }
        }

        choice_four.setOnClickListener {
            if (evaluate(targetVocab.meaning.toString(),choice_three_text.text as String)) {
                totalscore += 10
                update()
            } else {
                update()
            }
        }
    }

    private fun setupView() {
        setupQuestion()
    }

    private fun setupQuestion() {

        targetVocab = this.randomVocab(randomVocabList)

        question.text = targetVocab.word
        val choiceList = ArrayList<String>()

        targetVocab.meaning?.let { choiceList.add(it) }
        this.randomVocab(randomVocabList).meaning?.let { choiceList.add(it) }
        this.randomVocab(randomVocabList).meaning?.let { choiceList.add(it) }
        this.randomVocab(randomVocabList).meaning?.let { choiceList.add(it) }

        when(round) {
            0 -> {
                choice_one_text.text   = choiceList[1]
                choice_two_text.text   = choiceList[3]
                choice_three_text.text = choiceList[0]
                choice_four_text.text  = choiceList[2]
            }
            1 -> {
                choice_one_text.text   = choiceList[0]
                choice_two_text.text   = choiceList[3]
                choice_three_text.text = choiceList[2]
                choice_four_text.text  = choiceList[1]
            }
            2 -> {
                choice_one_text.text   = choiceList[3]
                choice_two_text.text   = choiceList[0]
                choice_three_text.text = choiceList[2]
                choice_four_text.text  = choiceList[1]
            }
            3 -> {
                choice_one_text.text   = choiceList[3]
                choice_two_text.text   = choiceList[1]
                choice_three_text.text = choiceList[2]
                choice_four_text.text  = choiceList[0]
            }
            4 -> {
                choice_one_text.text   = choiceList[0]
                choice_two_text.text   = choiceList[1]
                choice_three_text.text = choiceList[3]
                choice_four_text.text  = choiceList[2]
            }
            5 -> {
                choice_one_text.text   = choiceList[1]
                choice_two_text.text   = choiceList[3]
                choice_three_text.text = choiceList[2]
                choice_four_text.text  = choiceList[0]
            }
            6 -> {
                choice_one_text.text   = choiceList[0]
                choice_two_text.text   = choiceList[1]
                choice_three_text.text = choiceList[3]
                choice_four_text.text  = choiceList[2]
            }
            7 -> {
                choice_one_text.text   = choiceList[3]
                choice_two_text.text   = choiceList[0]
                choice_three_text.text = choiceList[1]
                choice_four_text.text  = choiceList[2]
            }
            8 -> {
                choice_one_text.text   = choiceList[1]
                choice_two_text.text   = choiceList[2]
                choice_three_text.text = choiceList[3]
                choice_four_text.text  = choiceList[0]
            }
            9 -> {
                choice_one_text.text   = choiceList[0]
                choice_two_text.text   = choiceList[1]
                choice_three_text.text = choiceList[2]
                choice_four_text.text  = choiceList[3]
            }
        }

        choiceList.clear()
    }

    private fun evaluate(targetMeaning: String,choiceMeaning:String): Boolean {
        return targetMeaning == choiceMeaning
    }


    private fun update() {
        round++
        if (round < 10){
            score.text = totalscore.toString()
            setupQuestion()
        } else {
            startActivity(Intent(this,CompleteActivity::class.java).putExtra("total-score",totalscore))
            finish()
        }
    }

    private fun randomVocab(vocabList: ArrayList<Vocab>): Vocab {
        return vocabList.random()
    }
}