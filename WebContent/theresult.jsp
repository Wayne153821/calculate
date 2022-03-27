<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成绩单</title>
</head>
<style>
 body{
	text-align: center;
	color:red;
	font-size: 30px;
	background-image: url('https://bpic.588ku.com/back_origin_min_pic/19/04/12/325e0c7365dd4ba9e824b6730197ebd8.jpg!/fw/750/quality/99/unsharp/true/compress/true');
}      
.button {
    background-color:  green;
    border: none;
    color: white;
    padding: 5px 10px;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 2px 2px;
    cursor: pointer;
 }
</style>
<body>
<form action="getGrade" method="get">
<br>
<br>
<h1 style="text-align: center; font-size: xx-large;font-weight: bolder;">成绩</h1>
<hr>
<br>
<%
String []names=request.getParameterValues("tempresult");
String results[]=request.getParameterValues("result");
double count=0;
for(int i=0;i<results.length;i++)
    if(results[i].equals(names[i]))
        count++;
out.print("您的分数："+count*100/results.length+"<br>"+"正确率："+Math.floor(Math.round((count/results.length)*100))+"%");
out.print("<br>");
int score=(int)(count*100/results.length);
%>
    <input type="hidden" name="score" value=<%=score %>>
	<input class="button" type="submit" value="提交成绩">
</form>
<a href="init.jsp" style="color: white;">再做一次</a>
</body>
</html>