package com.rsschool.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rsschool.quiz.R
import com.rsschool.quiz.data.q2
import com.rsschool.quiz.data.questionAnswer
import com.rsschool.quiz.data.right2
import com.rsschool.quiz.databinding.FragmentQuestion2Binding

class Question2 : Fragment() {

    private var fragmentQuestion2Binding: FragmentQuestion2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestion2Binding = FragmentQuestion2Binding.inflate(layoutInflater)
        fragmentQuestion2Binding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question2_to_question3)
        }
        fragmentQuestion2Binding?.nextButton?.isEnabled = false
        fragmentQuestion2Binding?.question?.text = questionAnswer[1].question
        val listRadioButtons = arrayListOf(
            fragmentQuestion2Binding?.optionOne,
            fragmentQuestion2Binding?.optionTwo,
            fragmentQuestion2Binding?.optionThree,
            fragmentQuestion2Binding?.optionFour,
            fragmentQuestion2Binding?.optionFive
        )
        for (i in listRadioButtons.indices) {
            listRadioButtons[i]?.text = questionAnswer[1].arrayAnswers[i]
        }
        fragmentQuestion2Binding?.previousButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question2_to_question1)
        }
        checkedRadioGroup()
        savePositionRadioGroup()
        return fragmentQuestion2Binding!!.root
    }

    private fun savePositionRadioGroup() {
        when (q2) {
            0 -> {
                fragmentQuestion2Binding?.optionOne?.isChecked = true
            }
            1 -> {
                fragmentQuestion2Binding?.optionTwo?.isChecked = true
            }
            2 -> {
                fragmentQuestion2Binding?.optionThree?.isChecked = true
            }
            3 -> {
                fragmentQuestion2Binding?.optionFour?.isChecked = true
            }
            4 -> {
                fragmentQuestion2Binding?.optionFive?.isChecked = true
            }
        }
    }


    private fun checkedRadioGroup() {
        fragmentQuestion2Binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                fragmentQuestion2Binding?.optionOne?.id -> {
                    fragmentQuestion2Binding?.nextButton?.isEnabled =
                        true
                    q2 = 0
                }
                fragmentQuestion2Binding?.optionTwo?.id -> {
                    fragmentQuestion2Binding?.nextButton?.isEnabled =
                        true
                    q2 = 1
                }
                fragmentQuestion2Binding?.optionThree?.id -> {
                    fragmentQuestion2Binding?.nextButton?.isEnabled =
                        true
                    q2 = 2
                }
                fragmentQuestion2Binding?.optionFour?.id -> {
                    fragmentQuestion2Binding?.nextButton?.isEnabled =
                        true
                    q2 = 3
                }
                fragmentQuestion2Binding?.optionFive?.id -> {
                    fragmentQuestion2Binding?.nextButton?.isEnabled =
                        true
                    q2 = 4
                    right2 = 20
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentQuestion2Binding = null
    }
}