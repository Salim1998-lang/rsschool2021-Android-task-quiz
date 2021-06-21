package com.rsschool.quiz

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rsschool.quiz.data.*
import com.rsschool.quiz.databinding.ActivityShareResultBinding

class ShareResultActivity : AppCompatActivity() {

    private var shareResultBinding: ActivityShareResultBinding? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shareResultBinding = ActivityShareResultBinding.inflate(layoutInflater)
        setContentView(shareResultBinding?.root)
        val sum = right1 + right2 + right3 + right4 + right5

        shareResultBinding?.back?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        shareResultBinding?.exit?.setOnClickListener {
            finishAffinity()
        }
        shareResultBinding?.share?.setOnClickListener {
            val myIntent = Intent()
            myIntent.setAction(Intent.ACTION_SEND)
            myIntent.putExtra(Intent.EXTRA_TEXT, "Your result: $sum%\n" +
                    "\nВопрос 1: ${questionAnswer[0].question} \n Варианты ответов: \n1. ${questionAnswer[0].arrayAnswers[0]} \n" +
                    "2. ${questionAnswer[0].arrayAnswers[1]} \n" +
                    "3. ${questionAnswer[0].arrayAnswers[2]} \n" +
                    "4. ${questionAnswer[0].arrayAnswers[3]} \n" +
                    "5. ${questionAnswer[0].arrayAnswers[4]} \n" +
                    "Ваш ответ - ${questionAnswer[0].arrayAnswers[q1]}" +
                    "\nВопрос 2: ${questionAnswer[1].question} \n" +
                    " Варианты ответов: \n" +
                    "1. ${questionAnswer[1].arrayAnswers[0]} \n" +
                    "2. ${questionAnswer[1].arrayAnswers[1]} \n" +
                    "3. ${questionAnswer[1].arrayAnswers[2]} \n" +
                    "4. ${questionAnswer[1].arrayAnswers[3]} \n" +
                    "5. ${questionAnswer[1].arrayAnswers[4]} \n" +
                    "Ваш ответ - ${questionAnswer[1].arrayAnswers[q2]}" +
                    "\nВопрос 3: ${questionAnswer[2].question} \n" +
                    " Варианты ответов: \n" +
                    "1. ${questionAnswer[2].arrayAnswers[0]} \n" +
                    "2. ${questionAnswer[2].arrayAnswers[1]} \n" +
                    "3. ${questionAnswer[2].arrayAnswers[2]} \n" +
                    "4. ${questionAnswer[2].arrayAnswers[3]} \n" +
                    "5. ${questionAnswer[2].arrayAnswers[4]} \n" +
                    "Ваш ответ - ${questionAnswer[2].arrayAnswers[q3]}" +
                    "\nВопрос 4: ${questionAnswer[3].question} \n" +
                    " Варианты ответов: \n" +
                    "1. ${questionAnswer[3].arrayAnswers[0]} \n" +
                    "2. ${questionAnswer[3].arrayAnswers[1]} \n" +
                    "3. ${questionAnswer[3].arrayAnswers[2]} \n" +
                    "4. ${questionAnswer[3].arrayAnswers[3]} \n" +
                    "5. ${questionAnswer[3].arrayAnswers[4]} \n" +
                    "Ваш ответ - ${questionAnswer[3].arrayAnswers[q4]}" +
                    "\nВопрос 5: ${questionAnswer[4].question} \n" +
                    " Варианты ответов: \n" +
                    "1. ${questionAnswer[4].arrayAnswers[0]} \n" +
                    "2. ${questionAnswer[4].arrayAnswers[1]} \n" +
                    "3. ${questionAnswer[4].arrayAnswers[2]} \n" +
                    "4. ${questionAnswer[4].arrayAnswers[3]} \n" +
                    "5. ${questionAnswer[4].arrayAnswers[4]} \n" +
                    "Ваш ответ - ${questionAnswer[4].arrayAnswers[q5]}"
            )
            myIntent.setType("text/plain")
            startActivity(myIntent)
        }


        shareResultBinding?.yourResult?.text = "Your result: $sum%"

    }

    override fun onBackPressed() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onDestroy() {
        super.onDestroy()
        shareResultBinding = null
    }
}