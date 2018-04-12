angular.module('circles-main').controller('CustomerEditeController',function ($scope, $http,$location){

	$scope.customer = {};
	$scope.message = '';
	$scope.id = {};
	$scope.payments = {};
	$scope.idCourse = {};
	
//	$scope.id = sessionService.get('user');
//	
//	console.log("User in section " + $scopo.id );
	
	
	$http.get('/customer/8')
	.success(function(customer){
		$scope.customer = customer;
		$scope.monthPayment();
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
	
	$scope.monthPayment = function(){
	
		$http.get('/customer/payment/8/3')    //+ id + '/' + idCourse)
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
			window.location.reload();
		})	
		.catch(function(error){
			console.log(error)
		});
		
	}
	
	$scope.clearPayment = function(iduser,idCourse,month){
		$http.get('/customer/pay/clean/'+iduser+'/'+idCourse +'/'+ month)
		.success(function(){
			window.location.reload();
		})	
		.catch(function(error){
			console.log(error)
		});
	}
});