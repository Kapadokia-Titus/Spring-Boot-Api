package kapadokia.nyandoro.databaseapi.controller;


import kapadokia.nyandoro.databaseapi.model.Topics;
import kapadokia.nyandoro.databaseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    //request for topic service member variable
    @Autowired //means that we need a dependency injection of TopicService class
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topics> getTopics(){

        //when a get request is made, this method will return a list of topics
        //this method's return type is list of topics
        // the fact that will have annotated this class to a rest controller means that the output is in
        //  json format

        //call the method on the service to get the list of topics
        return topicService.getAllTopics();
    }

    // spring to pass id param to the method
    // use {} to show that it is a variable name
    // use @PathVariable to tell the method that whatever parameter we are accepting is actually in the path
    @RequestMapping("/topics/{id}")
    public Topics getTopic(@PathVariable Integer id){
        return topicService.getTopic(id);
    }

    //making a post request
    // we want to add items to our list
    // use @RequestBody to pick the instance and send it to the list
    @PostMapping("/topics")
    public void addTopic(@RequestBody Topics topic){
        //create an instance that adds topic to the service
        topicService.addTopic(topic);

    }

    // updating a specific item{id} in the list
    //the method will be accepting two parameters which will contain two annotations
    // i.e @RequestBody and @PathVariable
    @PutMapping("topics/{id}")
    public void updateTopic(@RequestBody Topics topic, @PathVariable Integer id){

         topicService.updateTopic(topic, id);
    }

    //deleting a particular item from the list
    //it has the same mapping url as the get topic url
    @DeleteMapping("/topics/{id}")
    public void deleteTopic(@PathVariable Integer id){
       topicService.deleteTopic(id);
    }

//    the above sample code is a simple operation on an api.  performing several request operations query.
//we've used an hardcoded list.
}
