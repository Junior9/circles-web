angular.module('circles-main').controller('RoomEditeController',function ($scope, $http,$location){

	$scope.room = {};
	$scope.message = '';
	$scope.id = {};
	
	$http.get('/room/1')
	.success(function(room){
		$scope.room = room;
	})
	.catch(function(error){
		console.log(error)
	});
	
	$scope.save = function(){
		$http.post('/room/save',$scope.room)
		.success(function(room){
			$scope.room = room;
			
			if($scope.room.name != ""){
				console.log("New room : " + $scope.room.name );
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
	
});