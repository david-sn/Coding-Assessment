# Getting Started

1-install java 8 on machine
2-clone project from github https://github.com/david-sn/Coding-Assessment.git
3-open project from IDE(NetBeans)
4-build project to download requied dependencies
5-make sure port 8080 is free
6- run and enjoy

# Example of API

Note: All API are secured with basic64 Authentication (see how to use base64 authentication in request)

1- Register New Student(Not Secured)
http://localhost:8080/student/  	 POST
{   "name":"shiref",
    "email":"david@yah21oo.co",
    "username":"dav1id",
    "gender":"MALE",
    "password":"1234567_@89"
}

2-Register New Course
http://localhost:8080/course/		POST
{
    "name": "math",
    "description": "math 1",
    "publishDate": 1558425040419,
    "instructor": "david",
    "totalHours": 5
}



3- register in course
http://localhost:8080/action/registerInCourse/		POST
{
    "studentId": 1,
    "courseId": 1,
}

4-get user Courses   	GET
http://localhost:8080/action/getUserCourses/1

