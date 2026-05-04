package com.example.a2

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class ScoreAndReviewActivity : AppCompatActivity() {

    // UI Elements
    private lateinit var tvScore: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnReview: Button
    private lateinit var btnPlayAgain: Button
    private lateinit var reviewContainer: LinearLayout
    private lateinit var scrollView: ScrollView

    // Data
    private var score = 0
    private var total = 0
    private var reviewVisible = false

    // Questions
    private val questions = listOf(
        QuizActivity.Question(1, "Putting a spoon in an open champagne bottle will keep it bubbly longer.", false, "Myth! The spoon does nothing to preserve carbonation."),
        QuizActivity.Question(2, "Drinking a glass of water first thing in the morning boosts your metabolism.", true, "Real! It helps kickstart your metabolism."),
        QuizActivity.Question(3, "You should wait an hour after eating before swimming.", false, "Myth! Not medically necessary."),
        QuizActivity.Question(4, "Using your phone while charging damages the battery.", false, "Myth! Modern devices are safe."),
        QuizActivity.Question(5, "Putting a wet phone in rice helps dry it.", false, "Mostly a myth! Air drying is better."),
        QuizActivity.Question(6, "Turning your thermostat down when away saves energy.", true, "Real! It reduces energy use."),
        QuizActivity.Question(7, "Cracking knuckles causes arthritis.", false, "Myth! No scientific proof."),
        QuizActivity.Question(8, "Using the two-minute rule improves productivity.", true, "Real! It boosts efficiency.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get data from intent
        score = intent.getIntExtra("SCORE", 0)
        total = intent.getIntExtra("TOTAL", 8)

        initViews()
        displayScore()
        setupButtons()
    }

    private fun initViews() {
        tvScore = findViewById(R.id.tvScore)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnReview = findViewById(R.id.btnReview)
        btnPlayAgain = findViewById(R.id.btnPlayAgain)
        reviewContainer = findViewById(R.id.reviewContaine)
        scrollView = findViewById(R.id.ScrollView)
    }

    @SuppressLint("SetTextI18n")
    private fun displayScore() {
        // Show score
        tvScore.text = "$score / $total"

        // Personalised feedback based on score
        val percentage = (score.toDouble() / total) * 100

        val feedbackText = when {
            percentage >= 75 -> {
                "🏆 MASTER HACKER!\n\nExcellent work! You really know your life hacks from urban myths!"
            }
            percentage >= 50 -> {
                "👍 GOOD JOB!\n\nNot bad! You're getting there. Review the answers below to learn more!"
            }
            else -> {
                "🛡️ STAY SAFE ONLINE!\n\nDon't worry! Learn the facts below so you won't be fooled by myths."
            }
        }

        tvFeedback.text = feedbackText
    }

    @SuppressLint("SetTextI18n")
    private fun setupButtons() {
        // Review button - shows/hides all questions with correct answers
        btnReview.setOnClickListener {
            if (reviewVisible) {
                // Hide review
                scrollView.visibility = ScrollView.GONE
                btnReview.text = "📋 REVIEW ANSWERS"
                reviewVisible = false
            } else {
                // Show review
                displayAllQuestionsAndAnswers()
                scrollView.visibility = ScrollView.VISIBLE
                btnReview.text = "📋 HIDE REVIEW"
                reviewVisible = true
            }
        }

        // Play again button
        btnPlayAgain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }

    private fun displayAllQuestionsAndAnswers() {
        // Clear old content
        reviewContainer.removeAllViews()

        // Loop through all questions and display them
        for (i in questions.indices) {
            val question = questions[i]

            // Create a card for each question
            val card = createQuestionCard(question, i + 1)
            reviewContainer.addView(card)

            // Add divider between cards (except after last one)
            if (i < questions.size - 1) {
                val divider = View(this)
                divider.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    1
                )
                divider.setBackgroundColor(ContextCompat.getColor(this, R.color.divider))
                reviewContainer.addView(divider)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun createQuestionCard(question: QuizActivity.Question, number: Int): LinearLayout {
        val card = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            setPadding(20, 20, 20, 20)
            background = ContextCompat.getDrawable(this@ScoreAndReviewActivity, R.drawable.review_card_background)
        }

        // Question number and statement
        val questionText = TextView(this).apply {
            text = "$number. ${question.statement}"
            textSize = 16f
            setTextColor(ContextCompat.getColor(this@ScoreAndReviewActivity, R.color.primary_text))
            typeface = Typeface.DEFAULT_BOLD
        }

        // Correct answer (HACK or MYTH)
        val answerText = TextView(this).apply {
            val correctAnswer = if (question.isHack) "✓ Correct answer: HACK (Real Life Hack)" else "✓ Correct answer: MYTH (Urban Myth)"
            text = correctAnswer
            textSize = 14f
            setTextColor(ContextCompat.getColor(this@ScoreAndReviewActivity, R.color.correct_green))
            setPadding(0, 12, 0, 8)
        }

        // Explanation
        val explanationText = TextView(this).apply {
            text = "📝 Explanation: ${question.explanation}"
            textSize = 13f
            setTextColor(ContextCompat.getColor(this@ScoreAndReviewActivity, R.color.secondary_text))
        }

        card.addView(questionText)
        card.addView(answerText)
        card.addView(explanationText)

        return card
    }
}