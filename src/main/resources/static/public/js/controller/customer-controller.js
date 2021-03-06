angular.module('circles-main').controller('CustomerController',function ($scope, $http,$location,$rootScope){
	
	$scope.customer = {};
	$scope.customers = {};
	$scope.user = {};
	
	$http.get('customer/all')
	.success(function(customers){	
		$scope.customers = customers;
		console.log("[Customer finded");
	})
	.catch(function(error){
		console.log("Error to find customers ");
		console.log(error)
	});	
	
	
	$scope.save = function(){
		
		console.log($scope.customer.name);
		
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
	
	$scope.update = function(id){
		sessionStorage.setItem("customer",id);
		$location.path("/circles/customer/edite");
	}
	
	$scope.customerPayment = function(id){
		$rootScope.customer = { id: id};		
		$location.path("/circles/home/payment");
	}
});