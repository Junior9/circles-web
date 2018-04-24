angular.module('circles-main').controller('CourseController',function ($scope, $http,$location){
	
	$scope.course = {};
	$scope.courses = {};
	$scope.message = '';

	$http.get('/course/all/')
	.success(function(courses){
		$scope.courses = courses;
	})
	.catch(function(error){
		console.log(error)
	});	

	
	$scope.save = function(){
		$http.post('/course/save',$scope.course)
		.success(function(course){
			$scope.course = course;
			
			if($scope.course.name != ""){
				console.log("New course : " + $scope.course.name );
				//sessionService.set('manager',user.id);
				$location.path("/circles/home/course");
			}else{
				console.log("Erro at are save course");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles/home/course");
		});		
	}
	
	$scope.update = function(){
		
		$location.path("/circles/course/edite");
	}
	
});