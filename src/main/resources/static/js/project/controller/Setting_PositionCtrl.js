app.controller('Setting_PositionCtrl', Setting_PositionCtrl);

function Setting_PositionCtrl () {
  var pos = this; 
  pos.type = 'list';
  pos.switchContent=function(type){
	  pos.type = type;
  }
  pos.positions = [{id:0,name:'test',description:'desc test'}];
  pos.addPosition = function(position){
		if(	angular.isDefined(position) &&
	  		angular.isDefined(position.name)){
		   pos.positions.push(position);
	  	}
	  
  }
};