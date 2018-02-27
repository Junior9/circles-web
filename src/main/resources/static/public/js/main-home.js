	angular.module('circles-home', ['ngRoute','ngResource','menu'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/circles/customers', {
         templateUrl: 'public/partials/circles-customer.html',
         controller: 'CustomerController'
     });
	 

		 
	 $routeProvider.when('/sair', {
		 redirectTo:'/home'
	 });
	 
	
});  	