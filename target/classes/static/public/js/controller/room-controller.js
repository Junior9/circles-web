angular.module('circles-main').controller('RoomController',function ($scope, $http, $location){

	$scope.room = {};
	$scope.rooms = {};
	$scope.mensage = '';
	
	$http.get('/room/all/')
	.success(function(rooms){
		$scope.rooms = rooms;
	})
	.catch(function(error){
		console.log(error)
	});	
	
	
	$scope.save = function(){
		$http.post('/room/save',$scope.room)
		.success(function(room){
			$scope.room = room;
			
			if($scope.room.name != ""){
				console.log("New room : " + $scope.room.tenant );
				//sessionService.set('manager',user.id);
				$location.path("/circles/home/room");
			}else{
				console.log("Erro at are save room");
				$location.path("/circles");
			}
		})
		.catch(function(error){
			console.log(error);
			$location.path("/circles/home/room");
		});
	}
	
	$scope.update = function(){
		$location.path("/circles/room/edite");
	}
});