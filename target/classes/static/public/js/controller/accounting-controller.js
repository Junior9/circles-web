angular.module('circles-main').controller('AccountingController',function ($scope, $http){
	
	$scope.courses = {}
	$scope.months = {}
	$scope.monthsCourse = {}
	$scope.isAdm = sessionStorage.getItem("isADM");
	
	if($scope.isAdm == 1){
	
		$http.get('/accounting/all/course')
		.success(function(courses){
			$scope.courses = courses;
			$scope.dasboardCursos();
		})
		.catch(function(error){
			console.log(error)
		});	
		
		$http.get('accounting/all/months')
		.success(function(months){
			$scope.months = months;
			$scope.dashboardMonth();
		})
		.catch(function(error){
			console.log(error)
		});	
		
		$http.get('accounting/all/months/courses')
		.success(function(monthsCourse){
			$scope.monthsCourse = monthsCourse;
			$scope.dashboardMonthCourse();
		})
		.catch(function(error){
			console.log(error)
		});	
		
	}
	
	$scope.dasboardCursos = function(){
		
		Highcharts.chart('coursesDasboard', {
		    chart: {
		        type: 'column'
		    },
		    title: {
		        text: 'Profict courses'
		    },
		    subtitle: {
		        text: 'Year : '
		    },
		    xAxis: {
		        categories: $scope.courses.categore,
		        crosshair: true
		    },
		    yAxis: {
		        min: 0,
		        title: {
		            text: 'Pounds'
		        }
		    },
		    tooltip: {
		        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		            '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
		        footerFormat: '</table>',
		        shared: true,
		        useHTML: true
		    },
		    plotOptions: {
		        column: {
		            pointPadding: 0.2,
		            borderWidth: 0
		        }
		    },
		    series: [{
		        data: $scope.courses.series
		    },
		    ]
		});
		
	}
	
	$scope.dashboardMonth = function(){
		Highcharts.chart('coursesDasboard1', {

		    title: {
		        text: 'Profit month'
		    },
		    subtitle: {
		        text: 'Year : '
		    },
		    xAxis: {
		        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 
		            'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
		    },
		    yAxis: {
		        min: 0,
		        title: {
		            text: 'Pounds'
		        }
		    },
		    series: [{
		        data: $scope.months.series 
		    }]
		});
	}
	
	
	$scope.dashboardMonthCourse = function(){

		Highcharts.chart('coursesDasboard2', {

		    title: {
		        text: 'Profit of courses per month'
		    },

		    subtitle: {
		        text: 'Year'
		    },

		    yAxis: {
		        title: {
		            text: 'Pounds'
		        }
		    },
		    legend: {
		        layout: 'vertical',
		        align: 'right',
		        verticalAlign: 'middle'
		    },

		    plotOptions: {
		        series: {
		            label: {
		                connectorAllowed: false
		            },
		            pointStart: 2010
		        }
		    },
		    series: $scope.monthsCourse
		    ,

		    responsive: {
		        rules: [{
		            condition: {
		                maxWidth: 500
		            },
		            chartOptions: {
		                legend: {
		                    layout: 'horizontal',
		                    align: 'center',
		                    verticalAlign: 'bottom'
		                }
		            }
		        }]
		    }

		});

	}
	
});