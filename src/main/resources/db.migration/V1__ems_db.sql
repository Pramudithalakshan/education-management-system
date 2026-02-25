CREATE TABLE Users
(
    UserID   INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(255) NOT NULL,
    IsActive BOOLEAN DEFAULT TRUE,
    role     VARCHAR(20) NOT NULL
);

CREATE TABLE Departments
(
    DepartmentID   INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL
);

CREATE TABLE TeacherType
(
    TeacherTypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName      VARCHAR(50) NOT NULL -- Full-time, Part-time
);

CREATE TABLE Grades
(
    GradeID   INT AUTO_INCREMENT PRIMARY KEY,
    GradeName VARCHAR(50) NOT NULL
);

CREATE TABLE ExamType
(
    ExamTypeID INT AUTO_INCREMENT PRIMARY KEY,
    TypeName   VARCHAR(50) NOT NULL -- Midterm, Final, Quiz
);
CREATE TABLE Parents
(
    ParentID    INT AUTO_INCREMENT PRIMARY KEY,
    FirstName   VARCHAR(50) NOT NULL,
    LastName    VARCHAR(50) NOT NULL,
    PhoneNumber VARCHAR(20),
    Email       VARCHAR(100) UNIQUE
);

CREATE TABLE Teachers
(
    TeacherID     INT AUTO_INCREMENT PRIMARY KEY,
    UserID        INT UNIQUE,
    FirstName     VARCHAR(50) NOT NULL,
    LastName      VARCHAR(50) NOT NULL,
    Gender        VARCHAR(10),
    Address       TEXT,
    PhoneNumber   VARCHAR(20),
    DepartmentID  INT,
    TeacherTypeID INT,
    FOREIGN KEY (UserID) REFERENCES Users (UserID),
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID),
    FOREIGN KEY (TeacherTypeID) REFERENCES TeacherType (TeacherTypeID)
);

CREATE TABLE Students
(
    StudentID   INT AUTO_INCREMENT PRIMARY KEY,
    UserID      INT,
    FirstName   VARCHAR(50) NOT NULL,
    LastName    VARCHAR(50) NOT NULL,
    DateOfBirth DATE        NOT NULL,
    Gender      VARCHAR(10),
    Address     TEXT,
    PhoneNumber VARCHAR(20),
    ParentID    INT,
    FOREIGN KEY (UserID) REFERENCES Users (UserID),
    FOREIGN KEY (ParentID) REFERENCES Parents (ParentID)
);

CREATE TABLE Classrooms
(
    ClassroomID   INT AUTO_INCREMENT PRIMARY KEY,
    ClassroomName VARCHAR(100) NOT NULL,
    GradeID       INT,
    TeacherID     INT,
    FOREIGN KEY (GradeID) REFERENCES Grades (GradeID),
    FOREIGN KEY (TeacherID) REFERENCES Teachers (TeacherID)
);

CREATE TABLE Courses
(
    CourseID     INT AUTO_INCREMENT PRIMARY KEY,
    CourseName   VARCHAR(100) NOT NULL,
    Description  TEXT,
    TeacherID    INT,
    DepartmentID INT,
    FOREIGN KEY (TeacherID) REFERENCES Teachers (TeacherID),
    FOREIGN KEY (DepartmentID) REFERENCES Departments (DepartmentID)
);

CREATE TABLE StudentClassroom
(
    StudentClassroomID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID          INT,
    ClassroomID        INT,
    EnrollmentDate     DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ClassroomID) REFERENCES Classrooms (ClassroomID)
);

CREATE TABLE CourseEnrollments
(
    EnrollmentID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID      INT,
    CourseID       INT,
    EnrollmentDate DATE DEFAULT (CURRENT_DATE),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (CourseID) REFERENCES Courses (CourseID)
);

CREATE TABLE Attendance
(
    AttendanceID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID      INT,
    ClassroomID    INT,
    AttendanceDate DATE DEFAULT (CURRENT_DATE),
    Status         VARCHAR(20) NOT NULL, -- Present, Absent, Late
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ClassroomID) REFERENCES Classrooms (ClassroomID)
);

CREATE TABLE Exams
(
    ExamID     INT AUTO_INCREMENT PRIMARY KEY,
    ExamName   VARCHAR(100),
    CourseID   INT,
    ExamTypeID INT,
    ExamDate   DATE,
    FOREIGN KEY (CourseID) REFERENCES Courses (CourseID),
    FOREIGN KEY (ExamTypeID) REFERENCES ExamType (ExamTypeID)
);

CREATE TABLE ExamResults
(
    ExamResultID INT AUTO_INCREMENT PRIMARY KEY,
    StudentID    INT,
    ExamID       INT,
    Score        DECIMAL(5, 2),
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (ExamID) REFERENCES Exams (ExamID)
);

CREATE TABLE Library
(
    LibraryID INT AUTO_INCREMENT PRIMARY KEY,
    BookTitle VARCHAR(255) NOT NULL,
    Author    VARCHAR(255),
    ISBN      VARCHAR(20) UNIQUE,
    Quantity  INT DEFAULT 1
);

CREATE TABLE BorrowedBooks
(
    BorrowID   INT AUTO_INCREMENT PRIMARY KEY,
    StudentID  INT,
    LibraryID  INT,
    BorrowDate DATE DEFAULT (CURRENT_DATE),
    ReturnDate DATE,
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID),
    FOREIGN KEY (LibraryID) REFERENCES Library (LibraryID)
);

CREATE TABLE Fees
(
    FeeID     INT AUTO_INCREMENT PRIMARY KEY,
    StudentID INT,
    Amount    DECIMAL(10, 2),
    DueDate   DATE,
    PaidDate  DATE,
    FOREIGN KEY (StudentID) REFERENCES Students (StudentID)
);