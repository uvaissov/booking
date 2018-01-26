app.controller('MainCtrl', MainCtrl);

function MainCtrl () {
  var main = this; 
  main.title = 'Developer';
  main.navigationList = [] ;
  alert(/*[[${userName}]]*/);
  main.changeContent=function(item){
	  main.title =  item.currentTarget.attributes['data-page'].value;
  }
};