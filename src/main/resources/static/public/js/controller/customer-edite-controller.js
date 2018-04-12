angular.module('circles-main').controller('CustomerEditeController',function ($scope, $http,$location, $rootScope){

	$scope.customer = {};
	$scope.message = '';
	$scope.payments = {};
	$scope.idCourse = {};
	
	$scope.customer.id = $rootScope.customer.id;
	
	$http.get('/customer/'+ $scope.customer.id)
	.success(function(customer){
		$scope.customer = customer;
		$scope.monthPayment($scope.customer.id,$scope.customer.course.id);
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
	
	$scope.monthPayment = function(idCustomer,idCourse){
	
		$http.get('/customer/payment/'+idCustomer+'/'+idCourse)
		.success(function(payment){
			$scope.payment = payment;
		})	
		.catch(function(error){
			console.log(error)
		});
	}
	
	$scope.pay = function(iduser,idCourse,month){
		
		$http.get('/customer/pay/'+iduser+'/'+idCourse +'/'+ month)
		.success(function(){
			$scope.payment.payments[month] = 1;
		})	
		.catch(function(error){
			console.log(error)
		});
		
	}
	
	$scope.clearPayment = function(iduser,idCourse,month){
		$http.get('/customer/pay/clean/'+iduser+'/'+idCourse +'/'+ month)
		.success(function(){
			$scope.payment.payments[month] = 0;
		})	
		.catch(function(error){
			console.log(error)
		});
	}
});