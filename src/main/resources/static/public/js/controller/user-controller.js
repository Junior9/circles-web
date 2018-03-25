angular.module('circles-main').controller('UserController',function ($scope, $http, $location,sessionService){
	
	$scope.user = {};
	$scope.message = '';

	$scope.login = function(){
		$http.post('/login',$scope.user)
		.success(function(user){
			$scope.user = user;
			if($scope.user.login != ""){
				console.log("User login : " + $scope.user.login );
//				sessionService.set('user',user.id);
				$location.path("/circles/home/customer");
			}else{
				console.log("User not found");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$scope.message = 'User not found';
			$location.path("/circles");
		});		
	}
	
	
	$scope.save = function(){
		$http.post('/user/save',$scope.user)
		.success(function(user){
			$scope.user = user;
			if($scope.user.login != ""){
				console.log("New user : " + $scope.user.login );
				//sessionService.set('manager',user.id);
				$location.path("/circles/home/customer");
			}else{
				console.log("Erro at are save user");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles");
		});		
	}
	
});