## 📱 Project Overview

**Life Hack or Urban Myth?** is an interactive Android quiz application that helps users distinguish between genuine life hacks and common urban myths. The app presents questions where users must decide if a statement is a real life hack or just a myth, providing immediate feedback and explanations.

## 🎯 Purpose

In today's digital age, misinformation spreads rapidly. This app aims to:
- Educate users about common misconceptions
- Promote critical thinking about viral content
- Provide factual information about popular life hacks
- Create an engaging learning experience through gamification

---

## 📸 Screenshots
 <img width="1170" height="2532" alt="IMG_3288" src="https://github.com/user-attachments/assets/76d97331-a701-4475-a590-45034fd30e6e" />
<img width="1170" height="2532" alt="IMG_3289" src="https://github.com/user-attachments/assets/10611e60-591f-4ef4-90ac-d40e36da7dd8" />
<img width="1170" height="2532" alt="IMG_3290" src="https://github.com/user-attachments/assets/8aafc37e-f3ac-411d-b8bf-71b4b3960462" />
<img width="1170" height="2532" alt="IMG_3291" src="https://github.com/user-attachments/assets/350ec4f3-84d9-42e3-b135-d036c9b49fd1" />


---

## ✨ Features Implemented

### 1. Quiz Screen
- Displays questions one at a time
- Two answer options: **HACK (TRUE)** and **MYTH (FALSE)**
- Immediate feedback after each answer with explanation
- Shows correct/incorrect status with emoji feedback (✓/✗)
- "Next" button navigation

### 2. Score Screen
- Displays total score (e.g., 2/5)
- Personalised feedback message based on performance
- "Review" button to see all questions and answers

### 3. Review Screen
- Shows all questions with correct answers marked
- Displays "Hack" or "Myth" designation for each statement
- Helps users learn from their mistakes

---

## 📋 Question Bank

| # | Statement | Answer | Explanation |
|---|-----------|--------|-------------|
| 1 | You should drink at least 8 glasses of water every day no matter what | **MYTH** | Water needs depend on your body, activity and environment |
| 2 | Multitasking helps you get more work done efficiently | **HACK** | (Users learn correct answer) |
| 3 | Taking short breaks while studying improves focus | **MYTH** | (Users learn correct answer) |
| 4 | Cracking your knuckles causes arthritis | **HACK** | (Users learn correct answer) |
| 5 | Using dark mode on your phone always saves battery life | **MYTH** | (Users learn correct answer) |

---

## 🏗️ App Architecture
LifeHackQuizApp/
├── app/
│ ├── src/main/java/com/example/lifehackquiz/
│ │ ├── MainActivity.kt # Welcome screen
│ │ ├── QuizActivity.kt # Quiz logic & questions
│ │ ├── ScoreActivity.kt # Results display
│ │ └── ReviewActivity.kt # Review all answers
│ └── src/main/res/
│ ├── layout/
│ │ ├── activity_main.xml
│ │ ├── activity_quiz.xml
│ │ ├── activity_score.xml
│ │ └── activity_review.xml
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
| **Intents** | Screen navigation between activities |
| **GitHub Actions** | Automated builds and testing |

---

## 📦 Installation Guide

### Prerequisites
- Android Studio (Hedgehog or later)
- JDK 17 or higher
- Android SDK API 24+

### Steps to Run

1. **Clone the repository**
```bash
git clone https://github.com/yourusername/LifeHackQuiz.git
cd LifeHackQuiz
Open in Android Studio

Select "Open an Existing Project"

Navigate to the cloned folder

Sync Gradle Files

Click "Sync Now" when prompted

Run the App

Connect an Android device or start an emulator

Click the green "Run" button (▶)

Direct APK Installation
Download the latest APK from the Actions tab in GitHub → Select workflow → Download "app-debug" artifact

🎮 How to Play
Read the statement displayed on screen

Choose your answer - Tap "HACK (TRUE)" if you think it's a real life hack, or "MYTH (FALSE)" if you think it's fake

View feedback - Immediate explanation appears with ✓ or ✗ emoji

Tap Next - Move to the next question

Complete all questions - See your final score

Review answers - Tap review button to see all correct answers

Play again - Restart the quiz anytime

📊 Scoring & Feedback
Performance	Message
High Score	"Excellent! You're a true life hack expert!"
Medium Score	"Good job! Keep learning!"
Low Score	"Keep practicing! You can do better."
🧪 Testing & GitHub Actions
Automated Testing
The project uses GitHub Actions for continuous integration:

yaml
Triggers:
  - Push to main/master branch
  - Pull requests
  - Manual workflow dispatch

Jobs:
  - Build with JDK 17
  - Run Gradle tests
  - Generate debug APK
  - Upload APK as artifact
Manual Testing Performed
App launches without crashing

Navigation between all screens works

Score calculation is accurate

Feedback displays correctly with emojis

Review screen shows all questions and correct answers

Play again/restart functionality

🎨 UI Design Features
Emoji feedback - ✓ for correct, ✗ for incorrect answers

Clear visual distinction between Hack and Myth buttons

Progress tracking throughout the quiz

Clean, readable typography

Consistent color scheme throughout the app

👨‍💻 Developer Information
Field	Information
Module Name	Introduction to Mobile Application Development
Module Code	IMAD5112/p/w
Assignment	Assignment 2
Student Name	Sanele Dlamini
Student Number	ST10172088
📹 Video Demonstration
A video demonstration of the app showing all features: https://youtube.com/shorts/sIoGu_4piHw?si=nJeRMeF6YVTkNkGq

Welcome screen and starting the quiz

Answering questions with immediate feedback

Viewing final score and personalised message

Using the review feature to see all correct answers

gihub - https://github.com/SaneleDlamini77/Assignment2/edit/main/README.md
