Nocturne - Full-Stack Music Streaming Application
🎵 A feature-rich music streaming platform built with Java Spring Boot (developed in Spring Tool Suite 4) and Thymeleaf for the frontend, providing a seamless experience for users and admins alike.



🚀 Key Features
🔐 User Authentication & Security
Login & Signup System – Secure user registration with password encryption.

Forgot Password? – OTP-based password reset sent via SMTP Email.

Session Management – Secure user sessions with Spring Security.

🎧 User Dashboard
Browse & Play Songs – Intuitive music player with play/pause, skip, and volume controls.

Search & Filter – Easily find songs by title, artist, or genre.

Favorites & Playlists – Save favorite tracks and create custom playlists.

🛠 Admin Dashboard (For Content Management)
Upload/Delete Songs – Admins can manage the music library.

User Management – View, block, or delete users.

Analytics – Monitor user activity and song popularity.

💳 Payment Integration (Razorpay Test Mode)
Premium Subscriptions – Users can upgrade to a premium plan for ad-free listening.

Test Payment Flow – Safe transactions in sandbox mode.

🎨 Frontend (Thymeleaf, HTML, CSS, JS)
Responsive Design – Works on desktop, tablet, and mobile.

Interactive UI – Smooth animations and dynamic content loading.

Modern Styling – Clean, visually appealing interface.

🛠 Technologies Used
Backend
Java Spring Boot (REST APIs, MVC Architecture)

Spring Security (Authentication & Authorization)

Spring Data JPA (Database Operations)

SMTP (JavaMailSender) for OTP-based password reset

Razorpay API (Test Mode) for payments

Frontend
Thymeleaf (Server-side templating)

HTML5, CSS3, JavaScript (UI & Interactivity)

Bootstrap (Optional) for responsive design

Database
MySQL 

Development Tools
Spring Tool Suite 4 (STS 4) – Primary IDE

Postman – API Testing

Git & GitHub – Version Control

📂 Project Structure
plaintext
HarmonyHub/  
├── src/main/java/  
│   ├── config/          # Spring Security & MVC Config  
│   ├── controller/      # REST & Thymeleaf Controllers  
│   ├── model/           # Entities (User, Song, Playlist)  
│   ├── repository/      # JPA Repositories  
│   ├── service/         # Business Logic  
│   └── util/            # Email, OTP, Payment Helpers  
├── src/main/resources/  
│   ├── static/          # CSS, JS, Images  
│   ├── templates/       # Thymeleaf HTML Pages  
│   └── application.properties # DB, SMTP, Razorpay config  
└── README.md            # Project Documentation  
🔧 How to Run the Project
Clone the Repository



Open Spring Tool Suite 4 → File → Import → Maven → Existing Project

Configure Database & SMTP

Update application.properties with your MySQL/H2 and SMTP details.

Run the Application

Right-click project → Run As → Spring Boot App

Access the App

Open http://localhost:8080 in a browser.



🎶 Happy Coding & Keep the Music Playing! 🚀
