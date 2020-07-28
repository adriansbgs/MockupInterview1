package com.ftw.mockupinterview1

class PresenterDice (val view: InterfaceDice.View): InterfaceDice.Presenter {

    override fun process(currentDice: Int) {
        var score = 0
        score = if (currentDice % 2 == 0) {
            -3
        } else 5
        view.scoreResult(score)
    }
}