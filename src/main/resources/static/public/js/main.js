	angular.module('circles-main', ['ngRoute','ngResource','menu'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/circles', {
         templateUrl: 'public/partials/circles-index.html',
         controller: 'HomeController'
     });
	 
	 
	 $routeProvider.when('/circles/home', {
         templateUrl: 'public/partials/circles-home.html',
         controller: 'HomeController'
     });
		 
	 $routeProvider.when('/sair', {
//		 sessionService.destroy('user');
		 redirectTo:'/home'
	 });
	 
	 //$routeProvider.otherwise({redirectTo:'/home'});
	
});  	