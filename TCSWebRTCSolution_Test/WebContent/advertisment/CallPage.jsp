<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="advertisment.com.tcs.webrtc.customizeinterest.bean.* " %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
</script>
<script> 
$(document).ready(function(){
  $("#flip").click(function(){
    $("#panel").slideToggle("FAST");
  });});
  </script>

<style>
#panel,#flip
{
width:150px;
padding:16px;
text-align:center;color:#330000;
background-color:#FF9901;
border:solid 1px #c3c3c3;
}
#panel
{
width:700px;
background-color:#6599FF;
padding:25px;
display:none;

}
marquee{
background-color:blue;
align-top:10000px;
}


</style>

</head>

<body onload="load()">

<table bgcolor= "black" align="left">


<%-- <tr><td align="center">
<a href="<%=request.getContextPath() %>/CallServlet">
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/CALL1%20(2).jpg" alt="CALL"  width="150" height="40"/></a>

<a href="<%=request.getContextPath() %>/ReadCustomizeInterestServlet?action=viewcustomizeinterest">&nbsp;&nbsp;
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/EDITINTEREST1.jpg" alt="EDIT INTEREST" width="150" height="40"></a>

<a href="<%=request.getContextPath() %>/advertisment/CallStart.jsp">&nbsp;&nbsp;
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/ENDCALL1.jpg" alt="END CALL" width="150" height="40"></a>
</td></tr> --%>

<% ArrayList<CustomizeInterestBean> al1=(ArrayList<CustomizeInterestBean>)request.getAttribute("Accessorie"); %>
    <%for(CustomizeInterestBean cbi:al1){
	
	if((cbi.getAccessories()).isEmpty()){
		
	}else{
%>
<tr><td>

<script>
      
  
function load()
			{ document.getElementById('vid1').currentTime = 10;} </script>
<embed id="vid1" src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/video/Apple%20-%20iPhone%205c%20-%20Designed%20Together.mp4" width="700" height="450" >
 </embed></td>
<%}} %>
<% ArrayList<CustomizeInterestBean> al2=(ArrayList<CustomizeInterestBean>)request.getAttribute("Automobile"); %>
<%for(CustomizeInterestBean cbi:al2){
	
	if((cbi.getAutomobile()).isEmpty()){
		
	}else{%>
	  
		<td>
		<embed src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/video/New%20Toyota%20RAV%204%202013%20First%20Commercial%20Carjam%20TV%20HD%20Car%20TV%20Show%202013.mp4" width="700" height="450" >
	</embed></td>
	 <%}} %>
	 
	 <% ArrayList<CustomizeInterestBean> al3=(ArrayList<CustomizeInterestBean>)request.getAttribute("FoodAndEntertainment"); %>
<%for(CustomizeInterestBean cbi:al3){
	
	if((cbi.getFoodandEntertainment()).isEmpty()){
		
	}else{%>
	  
 <td><embed src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/video/Minion%20Madness%20at%20McDonald's!%20_%20Commercial%20_%20McDonald's%20Global.mp4" width="700" height="450" >
 </embed></td></tr>
  <%}} %>
</table>
    

<h1></h1>
<h1></h1>

<!-- <marquee behavior="scroll" direction="left" loop="repeat" >
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/nokia1.jpg" width=100 height=50 title="NokiaPhones"/><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SAMSUNG1.jpg" width=100 height=50 title="SamsungPhones"/><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/apple1.jpg" width=100 height=50 title="ApplePhone"/>
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUZUKI1.jpg" width=100 height=50 title="SuzukiMotors"/><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/TOYOTA1.jpg" width=100 height=50  title="ToyotaMotors"  /><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/HONDA1.jpg" width=100 height=50    title="HondaMotors"/>
<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/COCACOLA1.jpg" width=100 height=50  title="CocaCola"/><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/mac1.jpg" width=100 height=50  title="Mcdonals"/><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUBWAY.jpg" width=100 height=50  title="Subway"/>
</marquee> -->

</body>
</html>
