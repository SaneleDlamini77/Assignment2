package com.example.a2
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizActivity : AppCompatActivity() {

    // Question model inside the same file
    data class Question(
        val id: Int,
        val statement: String,
        val isHack: Boolean,
        val explanation: String
    )

    private lateinit var tvQuestionText: TextView
    private lateinit var tvProgress: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button

    private val questions = listOf(
        Question(
            1,
            "Putting a spoon in an open champagne bottle will keep it bubbly longer.",
            false,
            "Myth! The spoon does nothing to preserve carbonation."
        ),
        Question(
            2,
            "Drinking a glass of water first thing in the morning boosts your metabolism.",
            true,
            "Real! It helps kickstart your metabolism."
        ),
        Question(
            3,
            "You should wait an hour after eating before swimming.",
            false,
            "Myth! Not medically necessary."
        ),
        Question(
            4,
            "Using your phone while charging damages the battery.",
            false,
            "Myth! Modern devices are safe."
        ),
        Question(
            5,
            "Putting a wet phone in rice helps dry it.",
            false,
            "Mostly a myth! Air drying is better."
        ),
        Question(
            6,
            "Turning your thermostat down when away saves energy.",
            true,
            "Real! It reduces energy use."
        ),
        Question(
            7,
            "Cracking knuckles causes arthritis.",
            false,
            "Myth! No scientific proof."
        ),
        Question(
            8,
            "Using the two-minute rule improves productivity.",
            true,
            "Real! It boosts efficiency."
        )
    )

    private var currentIndex = 0
    private var score = 0
    private val userAnswers = mutableListOf<Boolean>()
    private var answerLocked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        displayQuestion()
        setupListeners()
    }

    private fun initViews() {
        tvQuestionText = findViewById(R.id.tvQuestionText)
        tvProgress = findViewById(R.id.tvProgress)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.HackBtn)
        btnMyth = findViewById(R.id.MythBtn)
        btnNext = findViewById(R.id.NextQuestionBtn)

    }

    private fun setupListeners() {
        btnHack.setOnClickListener { handleAnswer(true) }
        btnMyth.setOnClickListener { handleAnswer(false) }

        btnNext.setOnClickListener {
            if (currentIndex < questions.lastIndex) {
                currentIndex++
                displayQuestion()
            } else {
                goToScoreScreen()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun displayQuestion() {
        val question = questions[currentIndex]

        tvQuestionText.text = question.statement
        tvProgress.text = "Question ${currentIndex + 1} of ${questions.size}"

        resetUI()
    }

    private fun handleAnswer(selected: Boolean) {
        if (answerLocked) return

        answerLocked = true

        val question = questions[currentIndex]
        val isCorrect = selected == question.isHack

        userAnswers.add(isCorrect)

        if (isCorrect) score++

        showFeedback(isCorrect, question.explanation)
        highlightAnswer(question.isHack, selected)

        btnNext.isEnabled = true
        btnNext.alpha = 1f

        // Disable buttons after answering
        btnHack.isEnabled = false
        btnMyth.isEnabled = false
    }

    private fun showFeedback(isCorrect: Boolean, explanation: String) {
        tvFeedback.visibility = TextView.VISIBLE

        tvFeedback.text = if (isCorrect) {
            "✓ Correct!\n$explanation"
        } else {
            "✗ Wrong!\n$explanation"
        }

        val colorRes = if (isCorrect) R.color.correct_green else R.color.incorrect_red
        tvFeedback.setTextColor(ContextCompat.getColor(this, colorRes))
    }

    private fun highlightAnswer(correct: Boolean, selected: Boolean) {
        val neutral = ContextCompat.getColorStateList(this, R.color.button_neutral)
        val green = ContextCompat.getColorStateList(this, R.color.correct_green)
        val red = ContextCompat.getColorStateList(this, R.color.incorrect_red)

        // Reset
        btnHack.backgroundTintList = neutral
        btnMyth.backgroundTintList = neutral

        // Highlight correct
        if (correct) btnHack.backgroundTintList = green
        else btnMyth.backgroundTintList = green

        // Highlight wrong selection
        if (selected != correct) {
            if (selected) btnHack.backgroundTintList = red
            else btnMyth.backgroundTintList = red
        }
    }

    private fun resetUI() {
        answerLocked = false

        tvFeedback.visibility = TextView.GONE

        btnNext.isEnabled = false
        btnNext.alpha = 0.5f

        btnHack.isEnabled = true
        btnMyth.isEnabled = true

        val neutral = ContextCompat.getColorStateList(this, R.color.button_neutral)
        btnHack.backgroundTintList = neutral
        btnMyth.backgroundTintList = neutral
    }

    private fun goToScoreScreen() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("SCORE", score)
            putExtra("TOTAL", questions.size)
            putExtra("USER_ANSWERS", userAnswers.toBooleanArray())
        }

        startActivity(intent)
        finish()
    }
}