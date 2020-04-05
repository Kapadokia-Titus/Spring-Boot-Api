package kapadokia.nyandoro.databaseapi.model;


//we will need to map this model class to the database table
//the number of variables i.e id, name, description , will be the column
//while other instances of our list becomes the rows

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //tells jpa that this is an entity class
public class Topics {

    //the jpa will automatically use below variables as the member columns of the table
    // however, you must specify the primary key
    private String name;

    @Id   //this specifies that the below variable is the id
    private Integer id;
    private String description;

    //empty constructor
    public Topics(){

    }

    public Topics(Integer id, String name , String description){
        this.name =name;
        this.id = id;
        this.description = description;
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
}
