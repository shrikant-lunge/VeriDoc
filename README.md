📄 VeriDoc – Document Verification System

VeriDoc is a secure document upload and verification system developed using Spring Boot and HTML, CSS, and JavaScript. It allows users to upload documents, generate a unique verification code, and verify document authenticity to detect tampering.

🚀 Key Features

• Secure document upload
• Unique verification code generation
• Document integrity verification
• Tamper detection
• Clear VALID / INVALID result display
• Modern and user-friendly interface
• REST API based backend

🛠️ Technologies Used

Backend
• Java
• Spring Boot
• Spring Data JPA
• MySQL
• Maven

Frontend
• HTML
• CSS
• JavaScript

📁 Project Structure

VeriDoc/
backend/ – Spring Boot backend
frontend/ – HTML, CSS, JavaScript
database/ – SQL schema
README.md

🔗 REST APIs

POST /veridoc/upload
POST /veridoc/verify/{code}

⚙️ How to Run the Project

Database Setup
• Run the SQL file from database/veri_doc.sql

Backend Setup
• Open terminal inside backend folder
• Update database credentials in application.properties
• Run: mvn spring-boot:run
• Server runs at http://localhost:8084

Frontend Setup
• Open frontend/index.html in a web browser

🧠 How It Works

• User uploads a document
• System generates a verification code
• Document hash is stored securely
• During verification, file hash is compared
• Match → VALID
• Mismatch → INVALID / TAMPERED

🎓 Use Cases

• Academic certificate verification
• Document authenticity validation
• Secure file verification systems
• Learning REST API integration

🔮 Future Enhancements

• User authentication
• Admin dashboard
• QR-code based verification
• Cloud storage integration
• Cloud deployment

📜 License

This project is shared for academic and demonstration purposes only.
All rights reserved.

👨‍💻 Author

Developed as an academic project using Spring Boot and Web Technologies.
