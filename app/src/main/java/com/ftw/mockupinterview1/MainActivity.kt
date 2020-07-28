package com.ftw.mockupinterview1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object : InterfaceDice.View {

        private var userList = mutableListOf<User>()
        private var userName = ""
        private var presenter = PresenterDice(this)
        private var currentScore = 0
        private var totalPlayers = 0

        @JvmStatic
        fun main(args: Array<String>) {
            println("Masukkan jumlah pemain")
            totalPlayers = readLine()!!.toInt()

            for (i in 1..totalPlayers) {
                currentScore = 0
                println("Masukan nama kamu")
                userName = readLine().toString()
                play()
                println("Halo $userName")
            }

            val sortedList = userList.sortedByDescending {
                it.score
            }
            println(sortedList[0].nama + " adalah pemenang dengan skor " + sortedList[0].score)
            println("=========================================")
            println("Berikut datanya:")
            println(sortedList.forEach {
                println("${it.nama} ${it.score}")
            })
        }

        private fun play() {

            for (i in 0..4) {
                val rands = (1..6).random()
                presenter.process(rands)
            }
            userList.add(User(userName, currentScore))
        }

        override fun scoreResult(score: Int) {
            currentScore += score
        }
    }
}