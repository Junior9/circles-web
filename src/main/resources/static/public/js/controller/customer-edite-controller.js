angular.module('circles-main').controller('CustomerEditeController',function ($scope, $http,$location){

	$scope.customer = {};
	$scope.message = '';
	$scope.id = {};
	
	$http.get('/customer/1')
	.success(function(customer){
		$scope.customer = customer;
	})
	.catch(function(error){
		console.log(error)
	});
	
	$scope.save = function(){
		$http.post('/customer/save',$scope.customer)
		.success(function(customer){
			$scope.customer = customer;
			
			if($scope.customer.name != ""){
				console.log("New customer : " + $scope.customer.name );
				//sessionService.set('manager',user.id);
				$location.path("/circles/home/customer");
			}else{
				console.log("Erro at are save customer");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles/home/customer");
		});		
	}
	
});