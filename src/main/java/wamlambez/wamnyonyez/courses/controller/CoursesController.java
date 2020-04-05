package wamlambez.wamnyonyez.courses.controller;


import wamlambez.wamnyonyez.courses.model.Courses;
import wamlambez.wamnyonyez.courses.service.CoursesService;
import kapadokia.nyandoro.databaseapi.model.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoursesController {

    //request for Course service member variable
    @Autowired //means that we need a dependency injection of courseservice class
    private CoursesService coursesService;

    @RequestMapping("/topics/{id}/courses")
    public List<Courses> getAllCourses(@PathVariable Integer id){

        //when a get request is made, this method will return a list of courses
        //this method's return type is list of courses
        // the fact that will have annotated this class to a rest controller means that the output is in
        //  json format

        //call the method on the service to get the list of courses
        return coursesService.getAllCourses(id);
    }

    // spring to pass id param to the method
    // use {} to show that it is a variable name
    // use @PathVariable to tell the method that whatever parameter we are accepting is actually in the path
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Courses getCourse(@PathVariable Integer id){
        return coursesService.getCourse(id);
    }

    //making a post request
    // we want to add items to our list
    // use @RequestBody to pick the instance and send it to the list
    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@RequestBody Courses course, @PathVariable Integer topicId){
        course.setTopics(new Topics(topicId, "",""));
        //create an instance that adds Course to the service
        coursesService.addCourse(course);

    }

    // updating a specific item{id} in the list
    //the method will be accepting two parameters which will contain two annotations
    // i.e @RequestBody and @PathVariable
    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Courses course, @PathVariable Integer topicId, @PathVariable Integer id){
        course.setTopics(new Topics(topicId, "",""));
        coursesService.updateCourse(course);
    }

    //deleting a particular item from the list
    //it has the same mapping url as the get Course url
    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable Integer id){
       coursesService.deleteCourse(id);
    }

//    the above sample code is a simple operation on an api.  performing several request operations query.
//we've used an hardcoded list.
}
