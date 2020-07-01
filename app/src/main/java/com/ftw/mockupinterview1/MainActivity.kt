package com.ftw.mockupinterview1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), InterfaceDice.View {
    private var userList = mutableListOf<User>()
    private var userName = ""
    private var presenter = PresenterDice(this)
    private var currentScore = 0
    private var totalPlayers = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Masukkan jumlah pemain")
        totalPlayers = readLine()!!.toInt()

        for (i in 0..totalPlayers) {
            println("Masukan nama kamu")
            userName = readLine().toString()
            val score = play()
            println("Halo $userName")
        }

        val sortedList = userList.sortedBy {
            it.score
        }
        println(sortedList[0].nama + " adalah pemenang dengan skor " + sortedList[0].score)
    }

    private fun play() {
        val rands = (1..6).random()

        for (i in 0..4) {
            presenter.process(rands)
        }
        userList.add(User(userName, currentScore))
    }

    override fun scoreResult(score: Int) {
        currentScore += score
    }
}