package kapadokia.nyandoro.databaseapi.service;


import kapadokia.nyandoro.databaseapi.model.Topics;
import kapadokia.nyandoro.databaseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//we need to tell the service to connect to the database and run the commands.
// e.g saving topic instances.
@Service //marks this class as a spring business service
public class TopicService {

    //get the topic instance to the service so that it'll be easy to make call from here
    @Autowired
    private TopicRepository topicRepository;


    List<Topics> topics = new ArrayList<>(Arrays.asList(
            new Topics(1,"mongoDB","Java database Tutorial"),
                new Topics(2,"Android","Application development Tutorial"),
                new Topics(3,"Spring","MVC framework")
        ));

    public List<Topics> getAllTopics(){


        List<Topics> topics = new ArrayList<>(); //create a list which will store the information

        // .findAll() is a method that performs database connection and fetching of all data items
        // checkout java 8 lambdas and method reference tutorial
        topicRepository.findAll().forEach(topics::add); //add all each information to the list

         return topics;
    }

    //a method that returns an item from the list that matches the Id passed
    public Topics getTopic(Integer id){

        //filter by id
        //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

       return  topicRepository.findById(id).get();
    }

    public void addTopic(Topics topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topics topic, Integer id) {
         //loop through every topic
        //find the one that matches the id
        topicRepository.save(topic);
    }

    public void deleteTopic(Integer id) {
        topicRepository.deleteById(id);
    }
}
