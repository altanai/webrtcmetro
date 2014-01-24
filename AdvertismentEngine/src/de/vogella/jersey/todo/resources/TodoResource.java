package de.vogella.jersey.todo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import de.vogella.jersey.todo.dao.*;
import de.vogella.jersey.todo.model.Todo;
import org.apache.log4j.Logger;


public class TodoResource {
  
  @Context
  UriInfo uriInfo;
  @Context
  Request request;
  String id;
  
  // logger 
  static Logger log = Logger.getLogger(TodoResource.class.getName());
  
  public TodoResource(UriInfo uriInfo, Request request, String id) {
	  log.info("------------------------Todo Resource -----------------------");
    this.uriInfo = uriInfo;
    this.request = request;
    this.id = id;
  }
  
  //------------------------------------GET------------------------
  //Application integration     
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Todo getTodo() {
	  log.info("Todo Resource - GET - applicationxml , Applicationjson");
    Todo todo = TodoDao.instance.getModel().get(id);
    if(todo==null)
      throw new RuntimeException("Get: Todo with " + id +  " not found");
    return todo;
  }
  
  // for the browser
  @GET
  @Produces(MediaType.TEXT_XML)
  public Todo getTodoHTML() {
	  log.info("Todo Resource - GET - textxml");
    Todo todo = TodoDao.instance.getModel().get(id);
    if(todo==null)
      throw new RuntimeException("Get: Todo with " + id +  " not found");
    return todo;
  }

  //--------------------------PUT-----------------------------
  @PUT
  @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public Response putTodo(JAXBElement<Todo> todo) {
	  log.info("Todo Resource - PUT - applicationxml , Applicationjson");
    Todo c = todo.getValue();
    return putAndGetResponse(c);
  }
  
  
  //-------------------------DELETE--------------------------------
  @DELETE
  public void deleteTodo() {
    Todo c = TodoDao.instance.getModel().remove(id);
    if(c==null)
      throw new RuntimeException("Delete: Todo with " + id +  " not found");
  }
  
  //-----------------------------others------------------------------------
  private Response putAndGetResponse(Todo todo) {
	  log.info("Todo Resource - putandgetresponse");
    Response res;
    if(TodoDao.instance.getModel().containsKey(todo.getId())) {
      res = Response.noContent().build();
    } else {
    	
    	
      TodoDaowrite t=new TodoDaowrite();
      t.write(todo);
    
      res = Response.created(uriInfo.getAbsolutePath()).build();
 
    }
    TodoDao.instance.getModel().put(todo.getId(), todo);
    return res;
  }
  
  

} 