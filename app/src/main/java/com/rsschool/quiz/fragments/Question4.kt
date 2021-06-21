package com.rsschool.quiz.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rsschool.quiz.R
import com.rsschool.quiz.data.q4
import com.rsschool.quiz.data.questionAnswer
import com.rsschool.quiz.data.right4
import com.rsschool.quiz.databinding.FragmentQuestion4Binding

class Question4 : Fragment() {

    private var fragmentQuestion4Binding: FragmentQuestion4Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentQuestion4Binding = FragmentQuestion4Binding.inflate(layoutInflater)
        fragmentQuestion4Binding?.nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question4_to_question5)
        }
        fragmentQuestion4Binding?.nextButton?.isEnabled = false
        fragmentQuestion4Binding?.question?.text = questionAnswer[3].question
        val listRadioButtons = arrayListOf(
            fragmentQuestion4Binding?.optionOne,
            fragmentQuestion4Binding?.optionTwo,
            fragmentQuestion4Binding?.optionThree,
            fragmentQuestion4Binding?.optionFour,
            fragmentQuestion4Binding?.optionFive
        )
        for (i in listRadioButtons.indices) {
            listRadioButtons[i]?.text = questionAnswer[3].arrayAnswers[i]
        }
        fragmentQuestion4Binding?.previousButton?.setOnClickListener {
            findNavController().navigate(R.id.action_question4_to_question3)
        }
        checkedRadioGroup()
        savePositionRadioGroup()
        return fragmentQuestion4Binding!!.root
    }

    private fun savePositionRadioGroup() {
        when (q4) {
            0 -> {
                fragmentQuestion4Binding?.optionOne?.isChecked = true
            }
            1 -> {
                fragmentQuestion4Binding?.optionTwo?.isChecked = true
            }
            2 -> {
                fragmentQuestion4Binding?.optionThree?.isChecked = true
            }
            3 -> {
                fragmentQuestion4Binding?.optionFour?.isChecked = true
            }
            4 -> {
                fragmentQuestion4Binding?.optionFive?.isChecked = true
            }
        }
    }


    private fun checkedRadioGroup() {
        fragmentQuestion4Binding?.radioGroup?.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                fragmentQuestion4Binding?.optionOne?.id -> {
                    fragmentQuestion4Binding?.nextButton?.isEnabled =
                        true
                    q4 = 0
                    right4 = 20
                }
                fragmentQuestion4Binding?.optionTwo?.id -> {
                    fragmentQuestion4Binding?.nextButton?.isEnabled =
                        true
                    q4 = 1
                }
                fragmentQuestion4Binding?.optionThree?.id -> {
                    fragmentQuestion4Binding?.nextButton?.isEnabled =
                        true
                    q4 = 2
                }
                fragmentQuestion4Binding?.optionFour?.id -> {
                    fragmentQuestion4Binding?.nextButton?.isEnabled =
                        true
                    q4 = 3
                }
                fragmentQuestion4Binding?.optionFive?.id -> {
                    fragmentQuestion4Binding?.nextButton?.isEnabled =
                        true
                    q4 = 4
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        fragmentQuestion4Binding = null
    }
}