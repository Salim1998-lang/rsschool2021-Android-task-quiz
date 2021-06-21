package com.rsschool.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rsschool.quiz.R
import com.rsschool.quiz.data.q1
import com.rsschool.quiz.data.questionAnswer
import com.rsschool.quiz.data.right1
import com.rsschool.quiz.databinding.FragmentQuestion1Binding

class Question1 : Fragment() {

    private var fragmentQuestion1Binding: FragmentQuestion1Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestion1Binding = FragmentQuestion1Binding.inflate(layoutInflater)
        fragmentQuestion1Binding?.previousButton?.isEnabled = false
        fragmentQuestion1Binding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question1_to_question2)
        }
        fragmentQuestion1Binding?.nextButton?.isEnabled = false
        fragmentQuestion1Binding?.question?.text = questionAnswer[0].question

        val listRadioButtons = arrayListOf(
            fragmentQuestion1Binding?.optionOne,
            fragmentQuestion1Binding?.optionTwo,
            fragmentQuestion1Binding?.optionThree,
            fragmentQuestion1Binding?.optionFour,
            fragmentQuestion1Binding?.optionFive
        )
        for (i in listRadioButtons.indices) {
            listRadioButtons[i]?.text = questionAnswer[0].arrayAnswers[i]
        }
        checkedRadioGroup()
        savePositionRadioGroup()
        return fragmentQuestion1Binding!!.root
    }

    private fun savePositionRadioGroup() {
        when (q1) {
            0 -> {
                fragmentQuestion1Binding?.optionOne?.isChecked = true
            }
            1 -> {
                fragmentQuestion1Binding?.optionTwo?.isChecked = true
            }
            2 -> {
                fragmentQuestion1Binding?.optionThree?.isChecked = true
            }
            3 -> {
                fragmentQuestion1Binding?.optionFour?.isChecked = true
            }
            4 -> {
                fragmentQuestion1Binding?.optionFive?.isChecked = true
            }
        }
    }

    private fun checkedRadioGroup() {
        fragmentQuestion1Binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                fragmentQuestion1Binding?.optionOne?.id -> {
                    fragmentQuestion1Binding?.nextButton?.isEnabled =
                        true
                    q1 = 0
                }
                fragmentQuestion1Binding?.optionTwo?.id -> {
                    fragmentQuestion1Binding?.nextButton?.isEnabled =
                        true
                    q1 = 1
                    right1 = 20
                }
                fragmentQuestion1Binding?.optionThree?.id -> {
                    fragmentQuestion1Binding?.nextButton?.isEnabled =
                        true
                    q1 = 2
                }
                fragmentQuestion1Binding?.optionFour?.id -> {
                    fragmentQuestion1Binding?.nextButton?.isEnabled =
                        true
                    q1 = 3
                }
                fragmentQuestion1Binding?.optionFive?.id -> {
                    fragmentQuestion1Binding?.nextButton?.isEnabled =
                        true
                    q1 = 4
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentQuestion1Binding = null
    }
}