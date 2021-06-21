package com.rsschool.quiz.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rsschool.quiz.ActivityNavigate
import com.rsschool.quiz.R
import com.rsschool.quiz.data.q5
import com.rsschool.quiz.data.questionAnswer
import com.rsschool.quiz.data.right5
import com.rsschool.quiz.databinding.FragmentQuestion5Binding

class Question5 : Fragment() {

    private var fragmentQuestion5Binding: FragmentQuestion5Binding? = null
    private lateinit var activityNavigate: ActivityNavigate

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activityNavigate = context as ActivityNavigate
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestion5Binding = FragmentQuestion5Binding.inflate(layoutInflater)
        fragmentQuestion5Binding?.nextButton?.setOnClickListener {
            activityNavigate.intentOnShareResult()
        }
        fragmentQuestion5Binding?.nextButton?.isEnabled = false
        fragmentQuestion5Binding?.question?.text = questionAnswer[4].question
        val listRadioButtons = arrayListOf(
            fragmentQuestion5Binding?.optionOne,
            fragmentQuestion5Binding?.optionTwo,
            fragmentQuestion5Binding?.optionThree,
            fragmentQuestion5Binding?.optionFour,
            fragmentQuestion5Binding?.optionFive
        )
        for (i in listRadioButtons.indices) {
            listRadioButtons[i]?.text = questionAnswer[4].arrayAnswers[i]
        }
        fragmentQuestion5Binding?.previousButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question5_to_question4)
        }
        checkedRadioGroup()
        savePositionRadioGroup()
        return fragmentQuestion5Binding!!.root
    }

    private fun savePositionRadioGroup() {
        when (q5) {
            0 -> {
                fragmentQuestion5Binding?.optionOne?.isChecked = true
            }
            1 -> {
                fragmentQuestion5Binding?.optionTwo?.isChecked = true
            }
            2 -> {
                fragmentQuestion5Binding?.optionThree?.isChecked = true
            }
            3 -> {
                fragmentQuestion5Binding?.optionFour?.isChecked = true
            }
            4 -> {
                fragmentQuestion5Binding?.optionFive?.isChecked = true
            }
        }
    }

    private fun checkedRadioGroup() {
        fragmentQuestion5Binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                fragmentQuestion5Binding?.optionOne?.id -> {
                    fragmentQuestion5Binding?.nextButton?.isEnabled =
                        true
                    q5 = 0
                }
                fragmentQuestion5Binding?.optionTwo?.id -> {
                    fragmentQuestion5Binding?.nextButton?.isEnabled =
                        true
                    q5 = 1
                }
                fragmentQuestion5Binding?.optionThree?.id -> {
                    fragmentQuestion5Binding?.nextButton?.isEnabled =
                        true
                    q5 = 2
                }
                fragmentQuestion5Binding?.optionFour?.id -> {
                    fragmentQuestion5Binding?.nextButton?.isEnabled =
                        true
                    q5 = 3
                    right5 = 20
                }
                fragmentQuestion5Binding?.optionFive?.id -> {
                    fragmentQuestion5Binding?.nextButton?.isEnabled =
                        true
                    q5 = 4
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentQuestion5Binding = null
    }
}