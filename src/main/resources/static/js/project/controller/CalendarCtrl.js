app.controller('CalendarCtrl', CalendarCtrl);

function CalendarCtrl (moment) {
  var vm = this; 
  vm.calConfig = {
          calendarView : 'day',
          calendarDay : new Date()
      };
  vm.viewDate = new Date();
  vm.calendarTitle='asdasd';
  vm.events = [
    {
      title: 'My event title', 
      type: 'info',
      startsAt: new Date("Jan 29, 2018 00:00:00"), // BREAKING CHANGE
      endsAt: new Date("Jan 29, 2018 12:13:00"), // BREAKING CHANGE
      editable: true, 
      deletable: false, 
      
      incrementsBadgeTotal: true
    }
  ];
  vm.eventClicked = function(calendarEvent){
	  console.log(calendarEvent);
  }
  vm.eventTimesChanged = function(calendarEvent){
	  console.log(calendarEvent);
  }
};