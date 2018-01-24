app.controller('MainCtrl', MainCtrl);

function MainCtrl () {
  var main = this; 
  main.title = 'Developer';
  main.navigationList = [] ;
  angular.forEach(navigationList, function(value,index) {
	  var active = main.navigationList.length ===0; //первый елемент всегда выбран
	  main.navigationList.push({name:value , active:active});
	});
  main.changeContent=function(nav){
	  main.title = nav.name;
  }
};