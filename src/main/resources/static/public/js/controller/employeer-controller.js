angular.module('circles-main').controller('EmployeerController',function ($scope, $http,$location){

	$scope.employeer = {};
	$scope.employeers = {};
	$scope.message = '';
	
	
	$http.get('/employeer/all/')
	.success(function(employeers){
		$scope.employeers = employeers;
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
	
	$scope.delete = function(id){
		
		console.log("to aqui");
		
		$http.delete('/employeer/delete/' + id)
		.success(function(){
			
			console.log("certo");
			
			$location.path("circles/home/employeer");
		})
		.catch(function(error){
			console.log(error)
			$location.path("circles/home/employeer");
		});		
	}
	
	
	$scope.update = function(id){
		$http.get('/employeer/' + id)
		.success(function(employeer){
			$scope.employeer = employeer;
			$location.path("circles/home/employeer/perfil");
		})
		.catch(function(error){
			console.log(error)
		});		
	}
	
});