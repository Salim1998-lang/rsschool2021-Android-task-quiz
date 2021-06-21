package com.rsschool.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rsschool.quiz.R
import com.rsschool.quiz.data.*
import com.rsschool.quiz.databinding.FragmentQuestion3Binding


class Question3 : Fragment() {

    private var fragmentQuestion3Binding: FragmentQuestion3Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestion3Binding = FragmentQuestion3Binding.inflate(layoutInflater)
        fragmentQuestion3Binding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question3_to_question4)
        }
        fragmentQuestion3Binding?.nextButton?.isEnabled = false
        fragmentQuestion3Binding?.question?.text = questionAnswer[2].question
        val listRadioButtons = arrayListOf(
            fragmentQuestion3Binding?.optionOne,
            fragmentQuestion3Binding?.optionTwo,
            fragmentQuestion3Binding?.optionThree,
            fragmentQuestion3Binding?.optionFour,
            fragmentQuestion3Binding?.optionFive
        )
        for (i in listRadioButtons.indices) {
            listRadioButtons[i]?.text = questionAnswer[2].arrayAnswers[i]
        }
        fragmentQuestion3Binding?.previousButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question3_to_question2)
        }
        checkedRadioGroup()
        savePositionRadioGroup()
        return fragmentQuestion3Binding!!.root
    }

    private fun savePositionRadioGroup() {
        when (q3) {
            0 -> {
                fragmentQuestion3Binding?.optionOne?.isChecked = true
            }
            1 -> {
                fragmentQuestion3Binding?.optionTwo?.isChecked = true
            }
            2 -> {
                fragmentQuestion3Binding?.optionThree?.isChecked = true
            }
            3 -> {
                fragmentQuestion3Binding?.optionFour?.isChecked = true
            }
            4 -> {
                fragmentQuestion3Binding?.optionFive?.isChecked = true
            }
        }
    }


    private fun checkedRadioGroup() {
        fragmentQuestion3Binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                fragmentQuestion3Binding?.optionOne?.id -> {
                    fragmentQuestion3Binding?.nextButton?.isEnabled =
                        true
                    q3 = 0
                }
                fragmentQuestion3Binding?.optionTwo?.id -> {
                    fragmentQuestion3Binding?.nextButton?.isEnabled =
                        true
                    q3 = 1
                }
                fragmentQuestion3Binding?.optionThree?.id -> {
                    fragmentQuestion3Binding?.nextButton?.isEnabled =
                        true
                    q3 = 2
                    right3 = 20
                }
                fragmentQuestion3Binding?.optionFour?.id -> {
                    fragmentQuestion3Binding?.nextButton?.isEnabled =
                        true
                    q3 = 3
                }
                fragmentQuestion3Binding?.optionFive?.id -> {
                    fragmentQuestion3Binding?.nextButton?.isEnabled =
                        true
                    q3 = 4
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fragmentQuestion3Binding = null
    }
}