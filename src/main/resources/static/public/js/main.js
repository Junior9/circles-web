	angular.module('circles-main', ['ngRoute','ngResource','menu','header'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/circles', {
         templateUrl: 'public/partials/circles-home.html',
         controller: 'UserController'
     });	 
	 	 
	 $routeProvider.when('/circles/home/customer', {
         templateUrl: 'public/partials/circles-customer.html',
         controller: 'HomeController'
     });	 
	 
	 $routeProvider.when('/circles/home/employeer', {
         templateUrl: 'public/partials/circles-employeer.html',
         controller: 'EmployeerController'
     });
	 
	 $routeProvider.when('/circles/home/room', {
         templateUrl:'public/partials/circles-room.html',
         controller: 'RoomController'	
     });
	 
	 $routeProvider.when('/circles/home/course', {
         templateUrl: 'public/partials/circles-courses.html',
         controller: 'CourseController'
     });	 
	 
	 $routeProvider.when('/circles/home/acconunting', {
         templateUrl: 'public/partials/circles-accounting.html',
         controller: 'AccountingController'
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
	 
	 $routeProvider.when('/circles/home/course/perfil', {
         templateUrl: 'public/partials/circles-add-course.html',
         controller: 'CourseController'
     });
	 
	 $routeProvider.when('/circles/home/user', {
         templateUrl: 'public/partials/circles-add-user.html',
         controller: 'UserController'
     });
	 
	 //$routeProvider.otherwise({redirectTo:'/home'});
	
});  	