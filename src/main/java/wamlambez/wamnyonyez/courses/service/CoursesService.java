package wamlambez.wamnyonyez.courses.service;


import wamlambez.wamnyonyez.courses.model.Courses;
import wamlambez.wamnyonyez.courses.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//we need to tell the service to connect to the database and run the commands.
// e.g saving topic instances.
@Service //marks this class as a spring business service
public class CoursesService {

    //get the topic instance to the service so that it'll be easy to make call from here
    @Autowired
    private CoursesRepository coursesRepository;




    public List<Courses> getAllCourses(Integer topicId){


        List<Courses> topics = new ArrayList<>(); //create a list which will store the information

        // .findAll() is a method that performs database connection and fetching of all data items
        // checkout java 8 lambdas and method reference tutorial
        coursesRepository.findByTopicsId(topicId).forEach(topics::add); //add all each information to the list

         return topics;
    }

    //a method that returns an item from the list that matches the Id passed
    public Courses getCourse(Integer id){

        //filter by id
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

       return  coursesRepository.findById(id).get();
    }

    public void addCourse(Courses course) {
        coursesRepository.save(course);
    }

    public void updateCourse(Courses topic) {
         //loop through every topic
        //find the one that matches the is
        coursesRepository.save(topic);
    }

    public void deleteCourse(Integer id) {
        coursesRepository.deleteById(id);
    }
}
