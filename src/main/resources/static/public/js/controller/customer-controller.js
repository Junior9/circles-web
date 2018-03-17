angular.module('circles-main').controller('CustomerController',function ($scope, $http,$location,$route){
	
	$scope.customers = {};
	
	$http.get('customer/all')
	.success(function(customers){	
		$scope.customers = customers;
		console.log("[Customer finded");
	})
	.catch(function(error){
		console.log("Error to find customers ");
		console.log(error)
	});	
	
});