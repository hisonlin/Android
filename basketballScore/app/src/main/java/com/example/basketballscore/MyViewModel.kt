package com.example.basketballscore

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var scoreTeamA: MutableLiveData<Int>? = null
    private var scoreTeamB: MutableLiveData<Int>? = null

    private var scoreTeamA_prev: Int = 0
    private var scoreTeamB_prev: Int = 0

    fun getScoreTeamA(): MutableLiveData<Int> {
        if (scoreTeamA == null) {
            scoreTeamA = MutableLiveData<Int>().apply { value = 0 }
        }
        return scoreTeamA!!
    }

    fun getScoreTeamB(): MutableLiveData<Int> {
        if (scoreTeamB == null) {
            scoreTeamB = MutableLiveData<Int>().apply { value = 0 }
        }
        return scoreTeamB!!
    }

    fun addScoreTeamA(score: Int) {
        scoreTeamA_prev = scoreTeamA?.value ?: 0
        scoreTeamB_prev = scoreTeamB?.value ?: 0
        scoreTeamA?.value = (scoreTeamA?.value ?: 0) + score
    }

    fun addScoreTeamB(score: Int) {
        scoreTeamA_prev = scoreTeamA?.value ?: 0
        scoreTeamB_prev = scoreTeamB?.value ?: 0
        scoreTeamB?.value = (scoreTeamB?.value ?: 0) + score
    }

    fun undoScore() {
        scoreTeamA?.value = scoreTeamA_prev
        scoreTeamB?.value = scoreTeamB_prev
    }

    fun resetScore() {
        scoreTeamA?.value = 0
        scoreTeamB?.value = 0
    }

    fun restartGame() {
        scoreTeamA?.value = 0
        scoreTeamB?.value = 0
        scoreTeamA_prev = 0
        scoreTeamB_prev = 0
    }

}