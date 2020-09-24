$(document)
		.ready(
				function() {
					"use strict";
					// toat popup js
					/*$
							.toast({
								heading : 'Welcome to Ample admin',
								text : 'Use the predefined ones, or specify a custom position object.',
								position : 'top-right',
								loaderBg : '#fff',
								icon : 'warning',
								hideAfter : 3500,
								stack : 6
							})*/

					var option = document.getElementById("option").value; // 차트
					// 옵션 값
					console.log(option);
					var getarray = "";

					for (var i = 0; i < 12; i++) {
						var name = "val" + i;
						var getData = document.getElementById(name).value;
						getarray += getData;

						if (i == 11) {
							break;
						}
						getarray += "~";
					}
					var array2020 = getarray.split("~");

					var getarray = "";

					for (var i = 12; i < 24; i++) {
						var name = "cval" + i;
						var getData = document.getElementById(name).value;
						getarray += getData;

						if (i == 23) {
							break;
						}
						getarray += "~";
					}
					var array2019 = getarray.split("~");

					// ct-visits //차트 기본 값(Sales)
					new Chartist.Line('#ct-visits', {
						labels : [ 'January', 'Febrary', 'March', 'April',
								'May', 'June', 'July', 'August', 'September',
								'October', 'November', 'December' ],
						series : [ array2019// 2019데이터
						, array2020 // 2020데이터
						]
					}, {
						top : 0,
						low : 0,
						showPoint : true,
						fullWidth : true,
						plugins : [ Chartist.plugins.tooltip() ],
						axisY : {

							labelInterpolationFnc : function(value) {

								return (value / 1);
							}
						},
						showArea : true
					});

					// counter
					$(".counter").counterUp({
						delay : 100,
						time : 1200
					});

					var sparklineLogin = function() {
						$('#sparklinedash').sparkline(
								[ 0, 5, 6, 10, 9, 12, 4, 9 ], {
									type : 'bar',
									height : '30',
									barWidth : '4',
									resize : true,
									barSpacing : '5',
									barColor : '#7ace4c'
								});
						$('#sparklinedash2').sparkline(
								[ 0, 5, 6, 10, 9, 12, 4, 9 ], {
									type : 'bar',
									height : '30',
									barWidth : '4',
									resize : true,
									barSpacing : '5',
									barColor : '#7460ee'
								});
						$('#sparklinedash3').sparkline(
								[ 0, 5, 6, 10, 9, 12, 4, 9 ], {
									type : 'bar',
									height : '30',
									barWidth : '4',
									resize : true,
									barSpacing : '5',
									barColor : '#11a0f8'
								});
						$('#sparklinedash4').sparkline(
								[ 0, 5, 6, 10, 9, 12, 4, 9 ], {
									type : 'bar',
									height : '30',
									barWidth : '4',
									resize : true,
									barSpacing : '5',
									barColor : '#f33155'
								});
					}
					var sparkResize;
					$(window).on("resize", function(e) {
						clearTimeout(sparkResize);
						sparkResize = setTimeout(sparklineLogin, 500);
					});
					sparklineLogin();
				
					var concept = document.getElementById('hc0').value;
					var rescount = document.getElementById('rhc0').value;
					var getarray="";
					
					for (var i = 0; i < 100; i++) {
						var name = "hc"+i;
						var name2 = "rhc"+i;
						console.log(name);
	
						getarray+= document.getElementById(name).value;
						getarray+= ",";
						getarray+= document.getElementById(name2).value;
						
						 name="hc"+(i+1);
						if(document.getElementById(name)==null){
							break;
						}
						getarray+="~";
						console.log(getarray);
						
					}
					var chartarray = getarray.split("~");
	
					for (var i = 0; i < chartarray.length; i++) {
						chartarray[i] = chartarray[i].split(",");
						chartarray[i][1]*=1;
						
						
					}
					
					console.log(chartarray);
					
					// 구글 파이차트
					google.charts.load('current', {
						'packages' : [ 'corechart' ]
					});
					google.charts.setOnLoadCallback(drawChart);
					function drawChart() {
						var data = new google.visualization.DataTable();
						data.addColumn('string', 'concept');
						data.addColumn('number', '비중');

						data.addRows(
								chartarray

						);
						var opt = {
							'title' : '컨셉 별 예약 비율',
							'width' : 350,
							'height' : 350,
							pieSliceText : 'label',
							legend : 'none'
						};
						var chart = new google.visualization.PieChart(document
								.getElementById('piChart'));
						chart.draw(data, opt);
						window.addEventListener('resize',drawChart,false);
					}

				});

function change() {// 차트 옵션 콤보박스가 바뀔 때 실행

	$('.preloader').show();

	var option = document.getElementById("option").value; // 차트 옵션
	// 값reservation
	console.log(option);

	$.ajax({
		type : "GET",
		url : "getChart.mdo",
		data : {
			'option' : option
		},
		success : function(data) {

			console.log(data);

			$('#ct-visits').remove();// 차트 비워주기
			$('#ct-box').append(
					'<div id="ct-visits" style="height: 405px;"></div>');
			var array2020 = "";
			var array2019 = "";
			var m1 = "";
			var m2 = "";

			for (var i = 0; i < 12; i++) {
				m1 += data[i];
				if (i == 11) {
					break;
				}
				m1 += "~";

			}
			for (var i = 12; i < 24; i++) {
				m2 += data[i];
				if (i == 23) {
					break;
				}
				m2 += "~";

			}
			array2020 = m1.split("~");// 받은 값들 배열에 넣기
			array2019 = m2.split("~");

			// 차트
			new Chartist.Line('#ct-visits', {
				labels : [ 'January', 'Febrary', 'March', 'April', 'May',
						'June', 'July', 'August', 'September', 'October',
						'November', 'December' ],
				series : [ array2019// 2019데이터
				, array2020 // 2020데이터

				]
			}, {
				top : 0,
				low : 0,
				showPoint : true,
				fullWidth : true,
				plugins : [ Chartist.plugins.tooltip() ],
				axisY : {

					labelInterpolationFnc : function(value) {
						console.log(value);
						if (option == "Reservation") {
							return (value / 1);
						} else {
							return (value / 1000) + 'k';
						}

					}
				},
				showArea : true
			});

			$('.preloader').hide();// 프리로더 제거

		}// success-end

	});// ajax-end

}// change()--end
