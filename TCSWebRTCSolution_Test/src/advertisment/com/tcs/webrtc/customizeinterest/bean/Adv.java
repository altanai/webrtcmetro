package advertisment.com.tcs.webrtc.customizeinterest.bean;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Adv {
  private String id; // id of advertisment 
  private String summary; // link of video 
  private String description; // decsription of advertisment 
  
  //empty constructor
  public Adv(){
    
  }
  
  // coinstructor with 2 arguments 
  public Adv (String id, String summary){
    this.id = id;
    this.summary = summary;
  }
  
  // coinstructor with 3 arguments 
  public Adv (String id, String summary , String description){
    this.id = id;
    this.summary = summary;
    this.description = description;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  } 
} 