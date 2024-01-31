package com.example.basketballscore

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.basketballscore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var myViewModel: MyViewModel? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        restoreScores()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this)[MyViewModel::class.java]
        binding?.data = myViewModel
        binding?.lifecycleOwner = this
    }

    override fun onPause() {
        super.onPause()
        saveScores()
    }

    override fun onResume() {
        super.onResume()
        restoreScores()
    }

    private fun saveScores() {
        val sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putInt("TeamAScore", myViewModel?.getScoreTeamA()?.value ?: 0)
            putInt("TeamBScore", myViewModel?.getScoreTeamB()?.value ?: 0)
            apply()
        }
    }

    private fun restoreScores() {
        val sharedPref = getSharedPreferences("ScorePref", Context.MODE_PRIVATE)
        myViewModel?.getScoreTeamA()?.value = sharedPref.getInt("TeamAScore", 0)
        myViewModel?.getScoreTeamB()?.value = sharedPref.getInt("TeamBScore", 0)
    }
}