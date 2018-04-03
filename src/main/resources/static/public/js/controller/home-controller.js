angular.module('circles-main').controller('HomeController',function ($scope, $http, $location){
	$scope.manager = {};
	$scope.mensagem = '';

	$scope.login = function(){
		$http.post('/login',$scope.manager)
		.success(function(manager){
			$scope.manager = manager;
			$scope.mensagem = "Login realizado";
//			sessionService.set('manager',manager.id);

			switch(user.isAdm) {
			    case 1:
			    	$location.path("/adm/home");
			    	break;
			    
			    case 0:
			    	$location.path("/shoppig/home");
			        break;
			   
			    default:
			    	console.log("[ERROR] - Perfil nao encontrado: " + user.perfil );
			}				
			console.log("[Action - login] [login : " + $scope.manager.login + "]");
		})
		.catch(function(error){
			console.log(error)
		});	
	}

});	