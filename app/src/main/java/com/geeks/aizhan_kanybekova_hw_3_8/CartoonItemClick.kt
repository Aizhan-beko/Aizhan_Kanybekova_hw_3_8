package com.geeks.aizhan_kanybekova_hw_3_8

interface CartoonItemClick {
    abstract val FirstFragmentDirections: Any

    fun onItemClick(cartoon: Cartoon)
}