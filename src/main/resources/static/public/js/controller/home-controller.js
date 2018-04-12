angular.module('circles-main').controller('HomeController',function ($scope, $http, $location,sessionServive){
	$scope.user = {};
	$scope.mensagem = '';

	$scope.login = function(){
		$http.post('/login',$scope.user)
		.success(function(user){
			$scope.user = user;
			$scope.mensagem = "Login realizado";
			sessionService.set('user',user.id);
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
			console.log("[Action - login] [login : " + $scope.user.login + "]");
		})
		.catch(function(error){
			console.log(error)
		});	
	}

});	