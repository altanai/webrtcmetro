package de.vogella.jersey.todo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.vogella.jersey.todo.model.Todo;

public enum TodoDao {
  instance;
  
  private Map<String, Todo> contentProvider = new HashMap<String, Todo>();
  
  private TodoDao() {

/*
 * Hardcoded hashmap     
 */
/*    Todo todo = new Todo("1", "Learn REST");
    todo.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
    contentProvider.put("1", todo);
    
    todo = new Todo("2", "Do something");
    todo.setDescription("Read complete http://www.vogella.com");
    contentProvider.put("2", todo);
    
    todo = new Todo("3", "Design");
    todo.setDescription("Design the structure");
    contentProvider.put("3", todo);*/
	  
	  /*
	   * JDBC transaction
	   */
	  todojdbc jdbc=new todojdbc();
	  Todo todo=new Todo();
	  
	  ArrayList<Todo> arr= jdbc.read();
	  
	  for(int i=0;i<arr.size();i++){
		  contentProvider.put(String.valueOf(i), arr.get(i));
	  }
	
    
  }
  
  public Map<String, Todo> getModel(){
    return contentProvider;
  }
  
  public void write(Todo t){
	  
	  todojdbc jdbc=new todojdbc();
	  
	   jdbc.write(t);
  }
  
  
  
}