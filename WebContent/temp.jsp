<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>题目</title>
<style> 
 body{
	text-align: center;
	color:#fff;
	font-size:20px;
	background-image: url('https://bpic.588ku.com/back_origin_min_pic/19/04/12/325e0c7365dd4ba9e824b6730197ebd8.jpg!/fw/750/quality/99/unsharp/true/compress/true');
}                    
.button,.show{
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

#bk {
    border: 3px solid #a1a1a1;
    padding: 5px 2px;
    /*     background:#dddddd; */
    border-radius: 15px;
    text-align: center;
    outline: none;
    }
 .result {
    color:red;
    border: 3px solid #a1a1a1;
    padding: 5px 2px;
    /*     background:#dddddd; */
    border-radius: 15px;
    text-align: center;
    outline: none;
    }
table{
margin: auto;
}
</style>
</head>
<%!String expression=null;
int sum,row;
%>
<%! public int getNum()
{
    return (int)(Math.random()*100)+1;
}
public int getKey()
{
    return (int)(Math.random()*10)%4;  
}
public int getResult(int num1,int num2,int num3,int key1,int key2)
{
    int sum=0;
    if(key1==0){
    	if(key2==0) sum=num1+num2+num3;
    	if(key2==1) sum=num1+num2-num3;
    	if(key2==2) sum=num1+num2*num3;
    	if(key2==3) sum=num1+num2/num3;
    }
    else if(key1==1){
    	if(key2==0) sum=num1-num2+num3;
    	if(key2==1) sum=num1-num2-num3;
    	if(key2==2) sum=num1-num2*num3;
    	if(key2==3) sum=num1-num2/num3;
    }
    else if(key1==2){
    	if(key2==0) sum=num1*num2+num3;
    	if(key2==1) sum=num1*num2-num3;
    	if(key2==2) sum=num1*num2*num3;
    	if(key2==3) sum=num1*num2/num3;
    }
    else if(key1==3){
    	if(key2==0) sum=num1/num2+num3;
    	if(key2==1) sum=num1/num2-num3;
    	if(key2==2) sum=num1/num2*num3;
    	if(key2==3) sum=num1/num2/num3;
    }
    return sum;
}
public  String getStr()
{
    boolean flag=false;
    String strsult=null;
    String str1=null;
    String str2=null;
    while(!flag){
        flag=true;
        int num1,num2,num3,key1,key2;
        num1=getNum();
        num2=getNum();
        num3=getNum();
        key1=getKey();
        key2=getKey();
        int temp=num1;
        num1=Math.max(num1,num2);
        num2=Math.min(temp,num2);
        switch(key1)
        {
        case 0:str1="+";break;
        case 1:str1="-";break;
        case 2:str1="x";break;
        case 3:{
            str1="/";
            if(num1%num2!=0)
                flag=false;
        }break;
        default:break;
        }
        switch(key2)
        {
        case 0:str2="+";break;
        case 1:str2="-";break;
        case 2:str2="x";break;
        case 3:{
            str2="/";
            if(key1==2){
                if((num1*num2)%num3!=0)
            	flag=false;
                }
            else if(key1==3){
            	if(num1%num2!=0||(num1/num2)%num3!=0)
            	flag=false;
                }
            else{
            	if(num2%num3!=0)
            		flag=false;
            	}
        }break;
        default:break;
        }
        if(flag)
            {
                strsult=num1+str1+num2+str2+num3+"="+getResult(num1, num2, num3, key1, key2);
            }
    }
    return strsult;
}
%>
<%sum=Integer.parseInt(request.getParameter("sty1"));
row=Integer.parseInt(request.getParameter("sty2"));
%>
<body>
<br>
<br>
<h1 style="text-align: center; font-size: xx-large;font-weight: bolder;">数学题</h1>
<hr>
<br>
<form action="theresult.jsp" method="get">
<table>
<%for(int i=1;i<=sum/row;i++) {%>
<tr>
<%for(int j=1;j<=row;j++) {%>
<td style="text-align:left;" width="200px">
<%=(j+(i-1)*row)%>
、
<%expression=getStr(); %>
<%=expression.substring(0,expression.split("=")[0].length()+1)%>
</td>
<td>
<input class="record" id="bk" name="tempresult" type="text" size="2" maxlength="5" style="margin-right: 30px" >
<input class="result" style="display:none" size="2" name="result" value=<%=expression.split("=")[1] %>>
</td>
<%}} %>
</tr>

<tr >
<%for(int j=1;j<=sum%row;j++) {%>
<td style="text-align: left;" width="200px">
<%=(j+sum/row*row)%>
、
<%expression=getStr(); %>
<%=expression.substring(0,expression.split("=")[0].length()+1)%>
</td>
<td>
<input class="record" id="bk" name="tempresult" type="text" size="2" maxlength="5" style="margin-right: 30px" >
<input  class="result" style="dispaly:none;" size="2" name="result" value=<%=expression.split("=")[1] %>>
</td>
<%} %>
</tr>
</table>
<h3 style="color:red;">查看正确答案后不能继续答题或者修改答案：</h3>
<input class="show" type="button" value="查看正确答案">
<br>
<input class="button" type="submit" value="查看成绩">
</form>
<script src='./jquery.min.js'></script>
<script type="text/javascript">

$(".show").click(function(){
	var answer=document.getElementsByClassName('record')
	for(let i=0;i<answer.length;i++){
		answer[i].style.display='none';
	}
	var answer1=document.getElementsByClassName('result')
	for(let i=0;i<answer1.length;i++){
		answer1[i].style.display='block';
	}
	
})
</script>
</body>
</html>