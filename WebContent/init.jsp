<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <title>设置题目格式</title>
 <script type="text/javascript">
 function check(){                /*检查用户输入的数据是否合法*/
     var reg=/^[1-9][0-9]*$/;
     var flag=false;
     if(!(reg.test(sty.sty1.value)&&reg.test(sty.sty2.value)))
         {
             alert("请输入正整数");
         }
     else flag=true;
     return flag;
 }
 </script>
 <style>    
 body{
	text-align: center;
	color:#fff;
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
 #bk {
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
 <body>
 <br>
 <br>
 <br>
 <h3 align="center" style="font-weight: bolder;color:white;font-size: xx-large;">数学考试</h3>
 <hr>
 <form action="temp1.jsp" method="post" name="sty" onsubmit="return check(this);">
 <div style="text-align: center;">
 <h2>简单模式</h2>
     <table >
         <tr>
             <td style="color: white;text-align: left;">题目数量  </td>
             <td><input id="bk" type="text" name="sty1" size="2" maxlength="5" ></td>
         </tr>
         <tr></tr>
         <tr>
             <td style="color:white;">每行题目数量</td>
             <td><input id="bk" type="text" name="sty2" size="2" maxlength="2"></td>
         </tr>
         <tr></tr>
         <tr>
             <td colspan="2"><input class ="button" type="submit" value="确认" ></td>
             <td colspan="2"></td>
         </tr>
     </table>
     </div>
 </form>
  <form action="temp.jsp" method="post" name="sty" onsubmit="return check(this);">
 <div style="text-align: center;">
 <h2>进阶模式</h2>
     <table >
         <tr>
             <td style="color: white;text-align: left;">题目数量  </td>
             <td><input id="bk" type="text" name="sty1" size="2" maxlength="5" ></td>
         </tr>
         <tr></tr>
         <tr>
             <td style="color:white;">每行题目数量</td>
             <td><input id="bk" type="text" name="sty2" size="2" maxlength="2"></td>
         </tr>
         <tr></tr>
         <tr>
             <td colspan="2"><input class ="button" type="submit" value="确认" ></td>
             <td colspan="2"></td>
         </tr>
     </table>
     </div>
 </form>
 </body>
 </html>