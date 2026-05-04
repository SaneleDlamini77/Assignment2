# Assignment2
#  Life Hack or Urban Myth? - Flashcard Quiz App

## 📱 Project Overview

**Life Hack or Urban Myth?** is an interactive Android quiz application that helps users distinguish between genuine life hacks and common urban myths. The app presents 8 questions where users must decide if a statement is a real life hack or just a myth, providing immediate feedback and explanations.

### Purpose

In today's digital age, misinformation spreads rapidly. This app aims to:
- Educate users about common misconceptions
- Promote critical thinking about viral content
- Provide factual information about popular life hacks
- Create an engaging learning experience through gamification

---

##  Features Implemented

### 1. Welcome Screen
- Friendly welcome message greeting users as "Truth Seeker"
- Clear description of the app's purpose
- Visual appeal with emoji and centered layout
- "START QUIZ" button to begin the game

### 2. Quiz Screen
- Displays 8 carefully curated questions one at a time
- Two answer options: **HACK (TRUE)** and **MYTH (FALSE)**
- Progress indicator showing current question number
- Immediate feedback after each answer with explanation
- Visual highlighting (green for correct, red for incorrect)
- Next button navigation (disabled until answer is selected)

### 3. Score & Review Screen (Combined)
- Displays total score out of 8 in large, clear format
- Personalised feedback based on score:
  - **75%+** : "MASTER HACKER!" - Excellent work!
  - **50-74%** : "GOOD JOB!" - Getting there!
  - **Below 50%** : "STAY SAFE ONLINE!" - Keep learning!
- Review button toggles visibility of all questions
- Shows correct answer (HACK or MYTH) for each question
- Includes explanations to help users learn
- "PLAY AGAIN" button to restart the quiz

---

##  Question Bank

| # | Statement | Answer | Explanation |
|---|-----------|--------|-------------|
| 1 | Putting a spoon in an open champagne bottle will keep it bubbly longer | MYTH | The spoon does nothing to preserve carbonation |
| 2 | Drinking a glass of water first thing in the morning boosts your metabolism | HACK | Helps kickstart your metabolism after sleep |
| 3 | You should wait an hour after eating before swimming | MYTH | Not medically necessary |
| 4 | Using your phone while charging damages the battery | MYTH | Modern devices have safety circuits |
| 5 | Putting a wet phone in rice helps dry it out | MYTH | Air drying or silica gel works better |
| 6 | Turning your thermostat down when away saves energy | HACK | Reduces energy costs by 10-15% |
| 7 | Cracking your knuckles causes arthritis | MYTH | No scientific proof of link |
| 8 | Using the two-minute rule improves productivity | HACK | Proven productivity technique |

---

## 🏗️ App Architecture

LifeHackQuizApp/
├── app/
│ ├── src/main/java/com/example/lifehackquiz/
│ │ ├── MainActivity.kt # Welcome screen
│ │ ├── QuizActivity.kt # Quiz logic & questions
│ │ └── ScoreAndReviewActivity.kt # Results & review
│ └── src/main/res/
│ ├── layout/
│ │ ├── activity_main.xml
│ │ ├── activity_quiz.xml
│ │ └── activity_score_and_review.xml
│ ├── drawable/
│ │ ├── welcome_background.xml
│ │ └── review_card_background.xml
│ └── values/
│ ├── colors.xml
│ └── strings.xml
├── .github/workflows/
│ └── build.yml # GitHub Actions CI/CD
└── README.md

text

---

## 🛠️ Technology Stack

| Technology | Purpose |
|------------|---------|
| **Kotlin** | Primary programming language |
| **Android SDK** | Mobile development framework |
| **XML** | UI layout design |
| **CardView** | Styled question cards |
| **Intents** | Screen navigation |
| **GitHub Actions** | Automated builds and testing |

---

## 📦 Installation Guide

### Prerequisites
- Android Studio (Hedgehog or later)
- JDK 17 or higher
- Android SDK API 24+

git hub link https://github.com/SaneleDlamini77/Assignment2/edit/main/README.md
youtube video: https://youtu.be/doS5fzOh4El?si=kb0W8wGli6K369
References

Wangereka, H. (2024) Mastering Kotlin for Android 14: build powerful Android apps from scratch using Jetpack libraries and Jetpack Compose. Birmingham: Packt Publishing. 
Wangereka, H. (2024) Mastering Kotlin for Android 14: build powerful Android apps from scratch using Jetpack libraries and Jetpack Compose. Birmingham: Packt Publishing. 
Google Developers (2024) Android Developer Documentation: Activities and Intents. Available at: https://developer.android.com/guide/components/activities/intro-activities 



