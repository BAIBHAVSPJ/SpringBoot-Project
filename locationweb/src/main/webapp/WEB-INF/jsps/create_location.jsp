<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location | create</title>
</head>
<body>

 <h2>Location | Add new location</h2>
 
 
 <form action="saveLocation" method="post">
   <pre>   
     Id <input type= "text" name="id"/>
     Name <input type= "text" name="name"/>
     Code <input type="text" name="code"/>
     Type:
     urban <input  type="radio" Value="urban" name="type"/>
     rural <input  type="radio" Value="rural" name="type"/>
     
     <input type="submit" value="save"/>
   </pre>
 
 
 
 </form>
   ${msg} 

</body>
</html>