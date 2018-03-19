angular.module('circles-main').controller('UserController',function ($scope, $http, $location){
	
	$scope.user = {};
	$scope.manager = {};
	$scope.mensagem = '';

	$scope.login = function(){
		$http.post('/login',$scope.user)
		.success(function(user){
			$scope.user = user;
			console.log("user login : " + $scope.user.login );
			//sessionService.set('manager',user.id);
			$location.path("/circles/home/customer");
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles");
		});		
	}
});