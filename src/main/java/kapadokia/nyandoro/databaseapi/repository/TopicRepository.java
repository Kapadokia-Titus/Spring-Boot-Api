package kapadokia.nyandoro.databaseapi.repository;


import kapadokia.nyandoro.databaseapi.model.Topics;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository <Topics,Integer> {

    //since we will be repeating the same methods as in the topic model class,
    // jpa has a simpler way of automating the tasks.
    //we will change this to an interface so that we use the existing data repository called CrudRepository
    // it contains the logic for any entity class
    // CrudRepository is a generic type
    //the generic class accepts two generics i.e the class object (Topics) and the ID type
    // by the fact that the TopicRepository extends the CrudRepository, it will come with all the possible CRUD operations

}
