# ClassAmigo
A school management platform for data management

This application is designed to manage the daily operations of a school or educational institution. It's built using Spring Boot for the backend and uses Spring Security to control access to features based on user roles.

The platform supports three main types of users:

1. Admins are the system's superusers. They have the ability to manage all other users and core data. They can create and assign roles to new users, register new tutors and students, create and manage courses, assign tutors to specific courses, and oversee the entire system. Admins also have visibility into reports, performance metrics, and user activities.

2. Tutors are assigned to courses by the admin. They have the ability to create and manage educational content such as lectures, assignments, and quizzes for their assigned subjects. Tutors can track the progress of students enrolled in their courses, mark attendance, and provide feedback or grades. Their dashboard focuses on teaching tools and class management.

3. Students have personal dashboards where they can view their enrolled courses, access study materials, submit assignments, and see their grades and tutor feedback. Students can also track their attendance and view schedules or announcements posted by tutors or admins.

Security is handled with Spring Security. The app enforces login protection and restricts access to different parts of the system based on the user's role. Passwords are encrypted using BCrypt, and each role has specific access rights defined in the security configuration.

The application uses a relational database (like MySQL or PostgreSQL) to store all data, including users, roles, course content, and attendance records. Data is persisted using Spring Data JPA.

The frontend can be built with Thymeleaf (if it's a server-rendered application), allowing dynamic HTML rendering based on user data. If it's REST-based, the frontend might be built with a JavaScript framework like React or Angular, consuming secured APIs.

This architecture ensures that each user experiences a tailored interface and can only access the features they’re authorized for, creating a secure, efficient, and role-based learning environment.

Would you like a diagram or sample code for any part of this system?
