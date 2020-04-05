package wamlambez.wamnyonyez.courses.model;


//we will need to map this model class to the database table
//the number of variables i.e id, name, description , will be the column
//while other instances of our list becomes the rows

import kapadokia.nyandoro.databaseapi.model.Topics;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity  //tells jpa that this is an entity class
public class Courses {

    //tying this course to topic,
    // assumption one topic contains many courses
    // so we will use an @ManyToOne annotation to signify this
    @ManyToOne
    private Topics topics;
    //by tying it we are able to capture the instance of the topicId which will be used in the course service class




    //the jpa will automatically use below variables as the member columns of the table
    // however, you must specify the primary key
    private String name;

    @Id   //this specifies that the below variable is the id
    private Integer id;
    private String description;

    //empty constructor
    public Courses(){

    }

    public Courses(Integer id, String name , String description, Integer topicId){
        this.name =name;
        this.id = id;
        this.description = description;
        this.topics = new Topics(topicId, " ", ""); //topic instance
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }
}
