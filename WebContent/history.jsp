<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ page import="com.size.entity.Grade" %>
		<%@ page import="com.size.service.GradeServiceImp" %>
			<%@ page import="java.util.Calendar" %>
				<%@ page import="java.util.List" %>
					<!DOCTYPE html>
					<html>

					<head>
						<meta charset="UTF-8">
						<title>成绩分析</title>
						<script src="./echarts.js"></script>

						<script src='./jquery.min.js'></script>
						<link rel="stylesheet" href="./history.css">
					</head>

					<body>
						<a href="index1.html">返回</a>
						<div class="wrap">
							<div class="table">
								<div class="table-title">
								<div class="title-text">答题次数</div>
								<div class="title-text">得分</div>
								<div class="title-text">完成时间</div>
								</div>
								<% GradeServiceImp gs=new GradeServiceImp(); List<Grade> list =
								gs.findAllGrades();
								for(Grade grade : list){
								%>
									<div class="table-content">
									<div class="content-item">
										<%=grade.getId() %>
									</div>
									<div class="content-item">
										<%=grade.getScore() %>
									</div>
									<div class="content-item">
										<%=grade.getTime() %>
									</div>
									</div>
								<% } %>
								</div>

							<div class='main'></div>
						</div>
						

						<script>


							console.log(echarts, 'ddd');
							var myChart = echarts.init(document.getElementsByClassName('main')[0]);
							var url = '/Calculate/score';


							$.getJSON(url).done(function (json) {
								console.log(json);
								let xData = [];
								let yData = [];
								for (let i = 0; i < json.length; i++) {
									let str = '第' + (json[i].id) + '次';
									xData.push(str);
									yData.push(json[i].score);
								}
								console.log(xData, yData);
								var option = {
									title: {
										text: '最近五次成绩表'
									},
									toolbox: {
										feature: {
											magicType: {
												type: ['line', 'bar']
											}
										}
									},
									xAxis: {
										data: xData
									},
									yAxis: {},
									series: [
										{
											name: 'xx',
											type: 'bar',
											data: yData
										}
									]
								};
								myChart.setOption(option);
							})


						</script>


					</body>

					</html>