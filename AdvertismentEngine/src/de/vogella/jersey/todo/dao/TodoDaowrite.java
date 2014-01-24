package de.vogella.jersey.todo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import de.vogella.jersey.todo.model.Todo;

public class TodoDaowrite {
 
  public void write(Todo t){
	  
	  todojdbc jdbc=new todojdbc();
	  
	   jdbc.write(t);
  }
  
  
}