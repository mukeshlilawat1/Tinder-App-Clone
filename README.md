# ❤️ AI-Powered Tinder Clone

A modern, intelligent dating app inspired by Tinder — built using **React.js**, **Spring Boot**, **MongoDB**, and **OpenAI API**. This app offers smart AI-powered match suggestions, AI-generated conversation starters, and chat insights, creating a next-level dating experience.

---

## 🚀 Features

- 🔐 User Authentication (Signup/Login)
- 📲 Swipe-based Matchmaking (Like/Dislike)
- 💬 Real-time Chat between matched users
- 🤖 AI Integration using OpenAI:
  - Smart match suggestions based on profiles
  - Icebreaker questions and conversation starters
  - AI-generated chat summaries & tone analysis
- 🧠 Profile analysis for compatibility insights
- 📊 Optional Admin Panel for managing users and matches

---

## 🛠 Tech Stack

- **Frontend**: React.js, Tailwind CSS
- **Backend**: Spring Boot (Java)
- **Database**: MongoDB (Atlas or Local)
- **AI Integration**: OpenAI GPT API

---

## 📁 Project Structure

```
tinder-ai-app/
├── client/               # React Frontend
├── server/               # Spring Boot Backend
├── openai-service/       # GPT logic integration
├── database/             # MongoDB setup/configs
```

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/tinder-ai-app.git
cd tinder-ai-app
```

### 2️⃣ Backend Setup (Spring Boot)

```bash
cd server
```

- Add your environment variables in `application.properties`:

```
spring.data.mongodb.uri=YOUR_MONGO_URI
openai.api.key=YOUR_OPENAI_KEY
```

- Run the Spring Boot app:

```bash
./mvnw spring-boot:run
```

### 3️⃣ Frontend Setup (React)

```bash
cd ../client
```

- Add environment variable in `.env`:

```
REACT_APP_BACKEND_URL=http://localhost:8080
```

- Install dependencies and start the frontend:

```bash
npm install
npm start
```

---

## 📡 API Overview

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/auth/register` | POST | User registration |
| `/api/auth/login` | POST | User login |
| `/api/users/{id}` | GET | Get user profile |
| `/api/match/swipe` | POST | Like or Dislike a user |
| `/api/chat/summary` | POST | Generate chat summary using OpenAI |
| `/api/ai/suggestions` | GET | Get AI-generated match suggestions |

---

## 🤖 AI Capabilities

- Suggest potential matches using AI profile analysis
- Generate engaging icebreakers for new matches
- Summarize long chat threads with GPT
- Analyze tone/emotion in chats

---

## 📸 Screenshots

> Add screenshots of swipe screen, chat, AI suggestions, etc.

---

## 🌟 Future Enhancements

- 📱 Mobile version using React Native
- 🔔 Push Notifications
- 🎥 In-app Video Calls
- 🌐 Google/Facebook OAuth Login
- 🌍 Multi-language Support

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to open a pull request or raise an issue.

---

## 📄 License

This project is licensed under the **MIT License**.

---

## ✨ Developed with ❤️ by [Mukesh Lilawat]
