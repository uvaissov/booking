app.controller('Setting_PositionCtrl', Setting_PositionCtrl);

function Setting_PositionCtrl () {
  var pos = this; 
  pos.type = 'list';
  console.log(pos.type);
  pos.switchContent=function(type){
	  pos.type = type;
  }
};