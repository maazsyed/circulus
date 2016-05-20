<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" type="text/css" href="../resource/css/normalize.css" />
 <link rel="stylesheet" type="text/css" href="../resources/css/style.css" />
<!--  <link href='http://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'> -->

<script>
function selectMultiple()
{
    $('#form1').submit(function(){
         var options = $('#tags > option:selected');
         if(options.length == 0){
             alert('no tag selected');
             return false;
         }
    });
}
</script>

</head>
<body>


<form:form method="Post" action="registrationform.html"	commandName="registration" id="form1" name="form1">
		<div id="card">
 <!--  <h2>Sign-up  </h2> -->
  <div class="login-page">
  <div class="form">
  <table >
<tr> Sign-up</tr>
<br>
		<tr>
					<td>User Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		
		<tr>
			<td><form:input id="name" path="userName" /></td>
		</tr>

		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>

		<tr>
			<td>Confirm Password:<FONT color="red"><form:errors
				path="confirmPassword" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="confirmPassword" /></td>
		</tr>

		<tr>
			<td>Email:<FONT color="red"><form:errors path="email" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="email" /></td>
		</tr>
		
		<tr>
			<td>Biography:<%-- <FONT color="red"><form:errors path="email" /></FONT> --%></td>
		</tr>
		<tr>
			<td><form:input path="biography" /></td>
		</tr>
			<tr><td>
			<table align="center">
			<tr>
			<td> Select Tags: </td> </tr>
			<tr>
			<td>
			<select size = "4" name="tags" id = "tags" multiple>
			<!-- <select size="5" name="sampleMut[]" multiple="multiple" id="sampleMut"> -->
			<option value="Science"> Science</option>
			<option value="Technology"> Technology</option>
			<option value="Food and Drinks"> Food and Drinks</option>
			
			<option value="Travel"> Travel</option>
			<option value="Politics"> Politics</option>
			<option value="News"> News</option>
			
			<option value="Life Pro Tips"> Life Pro Tips</option>
			<option value="Ideas"> Ideas</option>
			<option value="Motivation"> Motivation</option>
			
			<option value="Relationships"> Relationships</option>
			<option value="Facts and Trivia"> Facts and Trivia</option>
			<option value="Wildlife"> Wildlife</option>
			
			<option value="Automobile"> Automobile</option>
			<option value="Health and Fitness"> Health and Fitness</option>
			<option value="Fashion"> Fashion</option>
			
			<option value="Design"> Design</option>
			<option value="Business"> Business</option>
			<option value="Finance"> Finance</option>
			
			<option value="Entertainment"> Entertainment</option>
			<option value="Movies"> Movies</option>
			<option value="TV Shows"> TV Shows</option>
			
			<option value="Music"> Music</option>
			<option value="Literature"> Literature</option>
			<option value="History"> History</option>
			
			<option value="Pictures"> Pictures</option>
			<option value="Short Stories"> Short Stories</option>
			<option value="Gaming"> NewsGaming</option>
			
			<option value="Jokes"> Jokes</option>
			
			</select>			
		</td>
		<tr>
			<td>
			Press CTRL to select multiple tags</td> 
			</tr>
			</table>
			</tr>
		<tr>
			<td><input type="submit" onclick="selectMultiple()" value="Submit" /></td>
		</tr>
	</table>
	</div>
	</div>
	</form:form>

<!-- <img src="C:\Users\Venkat\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\wtpwebapps\springmvclogin\/images/5.jpg" alt="W3Schools.com"> -->



<!-- Select your tags:
<input type="checkbox" id="tos" name="tos" />
  <label for="tos">Politics </label>
  <input type="checkbox" id="news" name="news">
  <label for="news">Sports</label>
   <input type="checkbox" id="weather" name="news">
  <label for="news">Weather</label> -->

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
 <script src="../resources/js/normalize.js"></script>
   <script src="../resources/js/index.js"></script>
</body>
</html>