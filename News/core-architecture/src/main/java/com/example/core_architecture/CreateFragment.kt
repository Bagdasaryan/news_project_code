package com.example.core_architecture

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class CreateFragment(fragmentName: Fragment, fragmentManager: FragmentManager, id: Int) {
    private val mFragmentName = fragmentName
    private val mFragmentManager = fragmentManager
    private val mId = id

    fun move() {
        val detailsFragment = mFragmentName
        val fManager: FragmentManager = mFragmentManager
        val fTransaction: FragmentTransaction = fManager.beginTransaction()
        fTransaction
            .replace(mId, detailsFragment)
            .addToBackStack(null)
            .commit()
    }
}