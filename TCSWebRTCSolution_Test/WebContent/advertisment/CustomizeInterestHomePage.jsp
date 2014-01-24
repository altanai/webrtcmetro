<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomizeInterestHomePage</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("FAST");
  });
  $("#flip1").click(function(){
	    $("#panel1").slideToggle("FAST");
	  });
  $("#flip2").click(function(){
	    $("#panel2").slideToggle("FAST");
	  });
});
$(document).ready(function(){
	$("#frmflip").click(function(){
		  $("#frmpanel").slideToggle("FAST");
	});
	});
</script>

<style type="text/css"> 



#panel,#flip,#panel1,#panel2,#flip1,#flip2
{
width:150px;
padding:16px;
text-align:center;color:#330000;
background-color:#FF9901;
border:solid 1px #c3c3c3;

}
#panel,#panel1,#panel2
{
width:700px;
background-color:#6599FF;
padding:25px;
display:none;
}
marquee {

height:10px;
padding:5px;
background-color:#FF9901;
}

</style>

</head>
<body>

<form action="CustomizeInterestServlet">

<h2><img src="image/Untitled.png" height="50" width="150" title="CustomizeInterest"><font color=#6599FF>  INTERESTS </font></h2>
 <marquee behavior="ALTERNATE" direction="RIGHT"   ><FONT COLOR=blue>SELECT YOUR INTEREST</FONT></marquee>
 <h3></h3>
   <table  border="0" >
   <tr>
   <th id="flip">ACCESSORIES INTEREST </th>
   <td>
		 <div id="panel"> 
		
		     	<script type="text/javascript">document.getElementById("ApplePhone").checked = true;
		     	</script>				
	`  <input type="checkbox"  name="checkboxGroup1" id="ApplePhone" value="ApplePhone" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/apple1.jpg" width=200 height=100 title="ApplePhone"/>
        <input type="checkbox" name="checkboxGroup1" id="SamsungPhone" value="SamsungPhone"><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SAMSUNG1.jpg" width=200 height=100 title="SamsungPhones"/>
      	<input type="checkbox" name="checkboxGroup1" id="NokiaPhones" value="NokiaPhones"><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/nokia1.jpg" width=200 height=100 title="NokiaPhones"/>
		 
       </div></td></tr>
      
  		
  		
  		<tr><th id="flip1">AUTOMOBILE INTEREST </th><td>
      
		<div id="panel1"> 
        <input type="checkbox"  name="checkboxGroup2" id="SuzukiMotors" value="SuzukiMotors" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUZUKI1.jpg" width=200 height=100 title="SuzukiMotors"/>
	<input type="checkbox" name="checkboxGroup2" id="ToyotaMotors" value="ToyotaMotors" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/TOYOTA1.jpg" width=200 height=100  title="ToyotaMotors"  />
	<input type="checkbox" name="checkboxGroup2" id="HondaMotors" value="HondaMotors"  ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/HONDA1.jpg" width=200 height=100    title="HondaMotors"/>
	 </div></td></tr>
       
       
       <TR><th id="flip2">FOOD & ENTERTAINMENT </th><td>
		 <div id="panel2"> 
       <input type="checkbox"  name="checkboxGroup3" id="CocaCola" value="CocaCola" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/COCACOLA1.jpg" width=200 height=100  title="CocaCola"/>
    <input type="checkbox" name="checkboxGroup3" id="Mcdonals"  value="Mcdonals" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/mac1.jpg" width=200 height=100  title="Mcdonals"/>
   <input type="checkbox" name="checkboxGroup3" id="Subway" value="Subway" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUBWAY.jpg" width=200 height=100  title="Subway"/>
		
       </div></td></tr>
  		
      
 
			
		
		<tr><td><input TYPE="reset" VALUE ="RESET"/><input type="submit" value="SUBMIT" /></td></tr>	
		</table>		
   </form>



</body>
</html>