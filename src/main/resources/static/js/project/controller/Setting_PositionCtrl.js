app.controller('Setting_PositionCtrl', Setting_PositionCtrl);

function Setting_PositionCtrl ($http) {
  var pos = this; 
  pos.type = 'list';
  pos.switchContent=function(type){
	  pos.type = type;
  }
  pos.message = null;
  pos.positions = [];
  
  pos.addPosition = function(position){
		if(	angular.isDefined(position) &&
	  		angular.isDefined(position.name)){
			$http.post('/setting/position', position)
			.then(
				       function(response){
				    	   pos.positions.push(response.data);
				       }, 
				       function(response){
				    	   console.log(response);
				       }
				    );
	  	}
  }
  pos.getPosition = function(){
	  $http.get('/setting/position', null)
		.then(
			       function(response){
			    	   pos.positions = response.data;
			       }, 
			       function(response){
			    	   console.log(response);
			       }
			    ); 
  }
  pos.getPosition();
  
};