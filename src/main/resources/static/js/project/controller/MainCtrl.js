app.controller('MainCtrl', MainCtrl);
function MainCtrl () {
  var main = this; 
  main.pageUrl = contentPrefixPath+"calendar"
  main.navigationList = navItems ;
  main.calConfig = {
          calendarView : 'day',
          calendarDay : new Date()
      };
  main.changeContent=function(item){
	  angular.forEach(main.navigationList, function(value) {
		  if(value.active===true){
			  value.active=false;
		  }
		});
	  
	  item.active=true;
	  main.pageUrl = contentPrefixPath+item.itemPage
  }
};