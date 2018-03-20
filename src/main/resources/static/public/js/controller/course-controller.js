angular.module('circles-main').controller('CourseController',function ($scope, $http,$location){
	
	$scope.course = {};
	$scope.message = '';

	
	$scope.save = function(){
		$http.post('/course/save',$scope.course)
		.success(function(course){
			$scope.course = course;
			
			if($scope.course.name != ""){
				console.log("New course : " + $scope.user.name );
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
});