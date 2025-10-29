#  School Management System (Backend)

 **Database Normalization Justification (as per assessment)**  
Instead of using JSON fields to store related data, normalized tables were created (teacher_sub and teacher_class).  
This ensures:
- Data integrity  
- Easier querying and maintenance  
- Avoids duplication and inconsistency  

---

## 🧩 Project Structure
```
com.school.manageschool
│ Student.java
│ Teacher.java
│ Subject.java
│ ClassInfo.java
│
├── repository
│   ├── StudentRepository.java
│   ├── TeacherRepository.java
│   ├── SubjectRepository.java
│   └── ClassInfoRepository.java
│
├── service
│   ├── StudentService.java
│   └── StudentServiceImpl.java
│
└── controller
    ├── StudentController.java
    ├── TeacherController.java
    ├── DashboardController.java
    └── StatsController.java
```


