<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String str=request.getParameter("r1");
String final_output="";
float num1;
float num2;
float total=0;
num1=Float.parseFloat(request.getParameter("num1"));
num2=Float.parseFloat(request.getParameter("num2"));
if("add".equals(str))
{
	total=num1+num2;
}
else if("sub".equals(str))
{
	total=num1-num2;
}
else if("mul".equals(str))
{
	total=num1*num2;
}
else if("div".equals(str))
{
	total=num1/num2;
}
Float result=new Float(total);
out.println(result.toString());
%>
</body>
</html>