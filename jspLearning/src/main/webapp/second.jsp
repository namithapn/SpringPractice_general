<html>
<body>

<% 
String name = (String)session.getAttribute("user");
out.print("from session attribute is :" + name);
%>
</form>
</body>
</html>
