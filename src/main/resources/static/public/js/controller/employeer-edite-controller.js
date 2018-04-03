angular.module('circles-main').controller('EmployeerEditeController',function ($scope, $http,$location){

	$scope.employeer = {};
	$scope.message = '';
	$scope.id = {};
	
	$http.get('/employeer/1')
	.success(function(employeer){
		$scope.employeer = employeer;
	})
	.catch(function(error){
		console.log(error)
	});
	
	$scope.save = function(){
		$http.post('/employeer/save',$scope.employeer)
		.success(function(employeer){
			$scope.employeer = employeer;
			
			if($scope.employeer.name != ""){
				console.log("New employeer : " + $scope.employeer.name );
				//sessionService.set('manager',user.id);
				$location.path("/circles/home/employeer");
			}else{
				console.log("Erro at are save employeer");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles/home/employeer");
		});		
	}
	
});