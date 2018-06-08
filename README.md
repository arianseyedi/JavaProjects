# JavaProjects
  This repository is dedicated to my Java projects that I have done which may include personal work or coursework, the details of which you will read below.
## The following projects are currently up on the repo: (*JUnit test cases exist but not mentioned here*):

   1. **Graphs**:  
   
      * **courseRequisites**:  
         This is part of my coursework from EECS 2011Z W 2018 taught by James Elder which you can check out [here](https://www.eecs.yorku.ca/course_archive/2017-18/W/2011Z/ "EECS2011Z by James Elder") which containts a full implementation of directed acyclic graph (DAG). On top, this data structure is used to create a forest of courses and their requisites (pre-requisites is the only supported type at the moment). This is an extremely useful data structure since cycles in the graph are not allowed, which otherwise could cause serious problems. For example, you do not want course A to be the pre-requisite of course B and vice versa! this makes no sense, but not to worry, DAG will help us. Check out **Courses.java** for the results. Here are some usefull methods of **Courses.java**:  
         - **getCourse(CourseNumber)**: get course in the forest
         - **getRequisite(CourseNumber, CourseNumber)**: get requisite of a given course (if exists)
         - **putCourse(CourseNumber, String)**: add a new course to the forest
         - **putRequisite(CourseNumber, CourseNumber, CourseRequisite)**: set an existing course the requisite of another one.
 2.  **Fractal Patterns**:  
       This is my Lab6 coursework from EECS 2030 F 2017 taught by Matthew Kyan which you can check out [here](https://www.eecs.yorku.ca/course_archive/2017-18/F/2030b/labs/lab6/EECS2030Lab6_F2017.html"EECS2030 Lab6") which is a visual representation of fractal patterns done recursively. If you want to get a grip of how complex problems can be elegantly solved using recursive approach, check this one out.   
       Here is the result of running **recursiveTasks.java**:  
        ![fractal pattern example](https://github.com/arianseyedi/JavaProjects/blob/master/FractalPatterns/fp.png "Fractal Patterns Example")
