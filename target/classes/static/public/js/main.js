	angular.module('circles-main', ['ngRoute','ngResource','menu'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/circles', {
         templateUrl: 'public/partials/circles-home.html',
         controller: 'HomeController'
     });	 
	 
	 $routeProvider.when('/circles/home/customer', {
         templateUrl: 'public/partials/circles-customer.html',
         controller: 'HomeController'
     });
	 
	 $routeProvider.when('/circles/home/employeer', {
         templateUrl: 'public/partials/circles-employeer.html',
         controller: 'HomeController'
     });
	 
	 $routeProvider.when('/circles/home/room', {
         templateUrl: 'public/partials/circles-room.html',
         controller: 'HomeController'	
     });
	 
	 $routeProvider.when('/circles/home/course', {
         templateUrl: 'public/partials/circles-courses.html',
         controller: 'HomeController'
     });	 
	 
	 
	 
	 
	 //Add and edit 
	 
	 $routeProvider.when('/circles/home/customer/perfil', {
         templateUrl: 'public/partials/circles-add-customer.html',
         controller: 'CustomerController'
     });
	 
	 $routeProvider.when('/circles/home/employeer/perfil', {
         templateUrl: 'public/partials/circles-add-employeer.html',
         controller: 'EmployeerController'
     });
	 
	 $routeProvider.when('/circles/home/room/perfil', {
         templateUrl: 'public/partials/circles-add-room.html',
         controller: 'RoomController'
     });
	 
	
	 
	 //$routeProvider.otherwise({redirectTo:'/home'});
	
});  	