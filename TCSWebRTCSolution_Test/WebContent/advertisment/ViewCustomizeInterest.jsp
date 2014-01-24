<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="advertisment.com.tcs.webrtc.customizeinterest.bean.* " %>
     <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewCustomizeInterest</title>
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
<style>
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
background-color:#1E90FF;
padding:25px;
display:none;
}
#frmflip,#frmpanel{

padding:10px;
text-color:#330000;



}
#frmpanel{


display:none;
}

#new,#new1,#new2 {border:1px solid #FF9901; float:left;
}

.hedr {background-color:#1E90FF;};
marquee {

height:10px;
padding:5px;

}
a{
text-decoration:none;
}

</style>
</head>
<body onload="load();load1();load2()">


<h2><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/Untitled.png" height="50" width="150" title="CustomizeInterest"><font color=#6599FF>  INTERESTS </font></h2>
 <marquee behavior="ALTERNATE" direction="RIGHT"  bgcolor="#FF9901"; ><FONT COLOR="blue"> YOUR INTERESTS</FONT></marquee>






<table align="center" width ="100%"><tr><td>
<table id="new" align="center" >
<% ArrayList<CustomizeInterestBean>  al= (ArrayList<CustomizeInterestBean> )request.getAttribute("Accessorie");%>

<% for(CustomizeInterestBean  Calllogs :al){%>
<tr><th class="hedr"> Accessories : </th></tr>
<% 
			String phrase = Calllogs.getAccessories();
			//System.out.println("in jsp"+phrase);
				String delims = ",+";
				String[] tokens = phrase.split(delims);
				for (int i = 0; i < tokens.length; i++){
					//System.out.println(tokens[i]);
					%>
<tr ><td><font color=""><%=tokens[i] %>  </font></td></tr>
<%} }%>

</table>
<table id="new1"   >
<% ArrayList<CustomizeInterestBean>  al1= (ArrayList<CustomizeInterestBean> )request.getAttribute("Automobile");%>
<% for(CustomizeInterestBean  Calllogs1 :al1){%>
<tr><th class="hedr"> Automobile : </th></tr>
<% 
			String phrase1 = Calllogs1.getAutomobile();
			//System.out.println("in jsp"+phrase1);
				String delims1 = ",+";
				String[] tokens1 = phrase1.split(delims1);
				for (int j = 0;j < tokens1.length;j++){
					//System.out.println(tokens1[j]);%>
<tr ><td><font color=""><%=tokens1[j] %>  </font></td></tr>
<%} }%>
</table>
<table id="new2"   >
<% ArrayList<CustomizeInterestBean>  al2= (ArrayList<CustomizeInterestBean> )request.getAttribute("FoodAndEntertainment");%>
<% for(CustomizeInterestBean  Calllogs2 :al2){%>
<tr><th class="hedr"> FoodandEntertainment : </th></tr>
<% 
			String phrase1 = Calllogs2.getFoodandEntertainment();
			//System.out.println("in jsp"+phrase1);
			
				String delims1 = ",+";
				String[] tokens1 = phrase1.split(delims1);
				for (int j = 0;j < tokens1.length;j++){
					//System.out.println(tokens1[j]);%>
<tr ><td><font color=""><%=tokens1[j] %>  </font></td></tr>
<%} }%>

      
  		
</table></td></tr></table>
 &nbsp;
<table><tr><th align="left"><a href="<%=request.getContextPath() %>/CallServlet">&nbsp;&nbsp;<img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/CALL1%20(2).jpg" alt="CALL" width="70" height="20"></a></th></tr></table>

<form action="CustomizeInterestServlet" >


 
 <TABLE><TR><TH id="frmflip" align="left" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/EDITINTEREST2.jpg" width="150" height="40" title="EDIT"/></TH></TR><TR><TD>
 <div id="frmpanel">
   <table  align="left" >
   <tr>
   <th id="flip">ACCESSORIES INTEREST</th>
   <td>
		 <div id="panel"> 
		
<%
boolean apple=false;
boolean samsung=false;
boolean nokia=false;

%>
<% for(CustomizeInterestBean  Calllogs :al){
			String phrase = Calllogs.getAccessories();
			//System.out.println("in jsp"+phrase);
			
				String delims = ",+";
				String[] tokens = phrase.split(delims);
				for (int i = 0; i < tokens.length; i++){
					//System.out.println(tokens[i]);
					if(tokens[i].equals("ApplePhone")){
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@yes@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
						apple=true;
						
					}else if(tokens[i].equals("SamsungPhone"))
					{
						samsung=true;
					} 
					else if(tokens[i].equals("NokiaPhones"))
					{
						nokia=true;
					} 
					else{
						apple=false;
						samsung=false;
						nokia=false;
					}
				} System.out.println("apple"+apple);
				System.out.println("sam"+samsung);
				System.out.println("nok"+nokia);
			}
			
			if ((apple==true)&&(samsung==true)&&(nokia==true)){
				%>
			<script type="text/javascript">
			
			function load()
			{
			document.getElementById("ApplePhone").checked=true;
			document.getElementById("SamsungPhone").checked=true;
			document.getElementById("NokiaPhones").checked=true;
			
			}
			</script>
			
			
			
			
			 
		<%}else if ((apple==true)&&(samsung==true)&&(nokia!=true)){
			%>
			<script type="text/javascript">
			
			function load()
			{
			document.getElementById("ApplePhone").checked=true;
			document.getElementById("SamsungPhone").checked=true;
			
			
			}
			</script>
			
		<%}else if ((apple==true)&&(samsung!=true)&&(nokia!=true)){
			%><script type="text/javascript">
			
			function load()
			{
			document.getElementById("ApplePhone").checked=true;
			}
			</script>
	
		<%}else if ((apple!=true)&&(samsung==true)&&(nokia!=true)){
			%><script type="text/javascript">
			
			function load()
			{
			document.getElementById("SamsungPhone").checked=true;
			}
			</script>

		<%}else if ((apple!=true)&&(samsung!=true)&&(nokia==true)){
			%>
			<script type="text/javascript">
			
			function load()
			{
		 
			document.getElementById("NokiaPhones").checked=true;
			
			}
			</script>

		<%}else if ((apple!=true)&&(samsung==true)&&(nokia==true)){
			%>
			<script type="text/javascript">
			
			function load()
			{
			
			document.getElementById("SamsungPhone").checked=true;
			document.getElementById("NokiaPhones").checked=true;
			
			}
			</script>
			
		<%}else if ((apple==true)&&(samsung!=true)&&(nokia==true)){
			%>
			<script type="text/javascript">
			
			function load()
			{
			document.getElementById("ApplePhone").checked=true;
		
			document.getElementById("NokiaPhones").checked=true;
			
			}
			</script>

		<%}else{  
		%>
		<script type="text/javascript">
			
			function load()
			{
			document.getElementById("ApplePhone").checked=false;
			document.getElementById("SamsungPhone").checked=false;
			document.getElementById("NokiaPhones").checked=false;
			
			}
			</script>  <%} %>
			
		<input type="checkbox"  name="checkboxGroup1" id="ApplePhone" value="ApplePhone" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/apple1.jpg" width=200 height=100 title="ApplePhone"/>
        <input type="checkbox" name="checkboxGroup1" id="SamsungPhone" value="SamsungPhone"><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SAMSUNG1.jpg" width=200 height=100 title="SamsungPhones"/>
      	<input type="checkbox" name="checkboxGroup1" id="NokiaPhones" value="NokiaPhones"><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/nokia1.jpg" width=200 height=100 title="NokiaPhones"/>
		     					
	`   
       </div></td></tr>
      
  		
  		
  		<tr><th id="flip1">AUTOMOBILE INTEREST </th><td>
      
		<div id="panel1">
		
<%
boolean Suzuki=false;
boolean Toyota=false;
boolean Honda=false;
for(CustomizeInterestBean  Calllogs1 :al1){
			String phrase1 = Calllogs1.getAutomobile();
			//System.out.println("in jsp"+phrase1);
				String delims1 = ",+";
				String[] tokens1 = phrase1.split(delims1);
				for (int j = 0;j < tokens1.length;j++){
					if(tokens1[j].equals("SuzukiMotors")){
						Suzuki=true;
					}
					else if (tokens1[j].equals("ToyotaMotors")){
						Toyota=true;
					
					}
					else if (tokens1[j].equals("HondaMotors")){
						Honda =true;
					
					}else{
						Suzuki=false;
						Toyota=false;
						Honda=false;
					}
					
				}System.out.println("suz"+Suzuki);
				System.out.println("toy"+Toyota);
				System.out.println("han"+Honda);}
				
				
				
			if ((Suzuki==true)&&(Toyota==true)&&(Honda==true)){	%> 
			<script type="text/javascript">
			
			function load1()
			{
			document.getElementById("SuzukiMotors").checked=true;
			document.getElementById("ToyotaMotors").checked=true;
			document.getElementById("HondaMotors").checked=true;
			
			}
			</script>  
		<%}else  if ((Suzuki==true)&&(Toyota!=true)&&(Honda!=true)){	%> 
		<script type="text/javascript">
			
			function load1()
			{
			document.getElementById("SuzukiMotors").checked=true;
			
			}
			</script>    
		 <%}else  if ((Suzuki==true)&&(Toyota==true)&&(Honda!=true)){	%> 
		<script type="text/javascript">
			
			function load1()
			{
			document.getElementById("SuzukiMotors").checked=true;
			document.getElementById("ToyotaMotors").checked=true;
			
			
			}
			</script>
		  <%}else  if ((Suzuki==true)&&(Toyota!=true)&&(Honda==true)){	%> 
			<script type="text/javascript">
			
			function load1()
			{
			document.getElementById("SuzukiMotors").checked=true;
		
			document.getElementById("HondaMotors").checked=true;
			
			}
			</script>  
			<%}else  if ((Suzuki!=true)&&(Toyota==true)&&(Honda!=true)){	%> 
			<script type="text/javascript">
			
			function load1()
			{
		
			document.getElementById("ToyotaMotors").checked=true;
	
			
			}
			</script>  
			<%}else  if ((Suzuki!=true)&&(Toyota==true)&&(Honda==true)){	%> 
			<script type="text/javascript">
			
			function load1()
			{
			
			document.getElementById("ToyotaMotors").checked=true;
			document.getElementById("HondaMotors").checked=true;
			
			}
			</script>  

			<%}else  if ((Suzuki!=true)&&(Toyota!=true)&&(Honda==true)){	%> 
			<script type="text/javascript">
			
			function load1()
			{
			
			document.getElementById("HondaMotors").checked=true;
			
			}
			</script> 
			 <%}else{%>
			 <script type="text/javascript">
			
			function load1()
			{
			document.getElementById("SuzukiMotors").checked=false;
			document.getElementById("ToyotaMotors").checked=false;
			document.getElementById("HondaMotors").checked=false;
			
			}
			</script>  
	
			<% }%>
	<input type="checkbox"  name="checkboxGroup2" id="SuzukiMotors" value="SuzukiMotors" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUZUKI1.jpg" width=200 height=100 title="SuzukiMotors"/>
	<input type="checkbox" name="checkboxGroup2" id="ToyotaMotors" value="ToyotaMotors" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/TOYOTA1.jpg" width=200 height=100  title="ToyotaMotors"  />
	<input type="checkbox" name="checkboxGroup2" id="HondaMotors" value="HondaMotors"  ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/HONDA1.jpg" width=200 height=100    title="HondaMotors"/>
			
			
			
 </div></td></tr>
           
      
       <TR><th id="flip2">FOOD & ENTERTAINMENT </th><td>
		 <div id="panel2"> 
<%
boolean CocaCola=false;
boolean Mcdonals=false;
boolean Subway=false;

for(CustomizeInterestBean  Calllogs2 :al2){%>

<% 
			String phrase1 = Calllogs2.getFoodandEntertainment();
			//System.out.println("in jsp"+phrase1);

				String delims1 = ",+";
				
				String[] tokens1 = phrase1.split(delims1);
				for (int j = 0;j < tokens1.length;j++){
					
					if(tokens1[j].equals("CocaCola")){
						CocaCola=true;
						}
					else if(tokens1[j].equals("Mcdonals")){
						Mcdonals=true;
						}
					else if(tokens1[j].equals("Subway")){
						Subway=true;
						}
					else{
						CocaCola=false;
						Mcdonals=false;
						Subway=false;
					}
					
				} 
				System.out.println("cola"+CocaCola);
				System.out.println("mac"+Mcdonals);
				System.out.println("sub"+Subway);
}

if((CocaCola==true)&&(Mcdonals==true)&&(Subway==true))
{%>
	
			 <script type="text/javascript">
			
			function load2()
			{
			document.getElementById("CocaCola").checked=true;
			document.getElementById("Mcdonals").checked=true;
			document.getElementById("Subway").checked=true;
			
			}
			</script>  
	<% }else if((CocaCola==true)&&(Mcdonals!=true)&&(Subway!=true))
{%>
	
			 <script type="text/javascript">
			
			function load2()
			{
			document.getElementById("CocaCola").checked=true;
			 
			
			}
			</script>  
		<% }else if((CocaCola==true)&&(Mcdonals==true)&&(Subway!=true))
{%>
	
			 <script type="text/javascript">
			
			function load2()
			{
			document.getElementById("CocaCola").checked=true;
			document.getElementById("Mcdonals").checked=true;
			 
			
			}
			</script>  
	<% }else if((CocaCola==true)&&(Mcdonals!=true)&&(Subway==true))
{%>
	  <script type="text/javascript">
			
			function load2()
			{
			document.getElementById("CocaCola").checked=true;
			 
			document.getElementById("Subway").checked=true;
			
			}
			</script>  	
			<%  }else if((CocaCola!=true)&&(Mcdonals==true)&&(Subway==true))
{%>
	 <script type="text/javascript">
			
			function load2()
			{
			 
			document.getElementById("Mcdonals").checked=true;
			document.getElementById("Subway").checked=true;
			
			}
			</script>  
			<% }else if((CocaCola!=true)&&(Mcdonals==true)&&(Subway!=true))
{%>
	 <script type="text/javascript">
			
			function load2()
			{
	 
			document.getElementById("Mcdonals").checked=true;
		 
			
			}
			</script> 
			 <% }else if((CocaCola!=true)&&(Mcdonals!=true)&&(Subway==true))
{%>
	 <script type="text/javascript">
			
			function load2()
			{
			
			document.getElementById("Subway").checked=true;
			
			}
			</script> 
			 	<% }else{%>
			 	 <script type="text/javascript">
			
			function load2()
			{
			document.getElementById("CocaCola").checked=false;
			document.getElementById("Mcdonals").checked=false;
			document.getElementById("Subway").checked=false;
			
			}
			</script>  
			
		<%}

%>		

		<input type="checkbox"  name="checkboxGroup3" id="CocaCola" value="CocaCola" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/COCACOLA1.jpg" width=200 height=100  title="CocaCola"/>
    <input type="checkbox" name="checkboxGroup3" id="Mcdonals"  value="Mcdonals" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/mac1.jpg" width=200 height=100  title="Mcdonals"/>
   <input type="checkbox" name="checkboxGroup3" id="Subway" value="Subway" ><img src="http://localhost:8080/TCSWebRTCSolution_Test/advertisment/image/SUBWAY.jpg" width=200 height=100  title="Subway"/>
		
         
       </div></td></tr>
  		
      
 
			
		
		<tr><td><input TYPE="reset" VALUE ="RESET"/><input type="submit" value="SUBMIT" /></td></tr>	
		</table></div>	</TD></TR></TABLE>	
   </form>
   


</body>
</html>