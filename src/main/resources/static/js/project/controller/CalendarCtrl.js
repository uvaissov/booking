app.controller('CalendarCtrl', CalendarCtrl);

function CalendarCtrl (moment) {
  var vm = this; 
  vm.viewDate = new Date();
  vm.calendarTitle='asdasd';
  
  vm.events = [
    {
      title: 'My event title', 
      type: 'info',
      startsAt: moment().hours(5).minutes(0).toDate(), // BREAKING CHANGE
      endsAt: moment().hours(6).minutes(0).toDate(), // BREAKING CHANGE
      //actions:actions,
      draggable: true,
      resizable: true
    },
    {
        title: 'My event title1', 
        type: 'info',
        startsAt: moment().hours(6).minutes(0).toDate(), // BREAKING CHANGE
        endsAt: moment().hours(6).minutes(30).toDate(), // BREAKING CHANGE
        //actions:actions,
        draggable: true,
        resizable: true
      }
  ];
  
  
  vm.eventEdited = function(calendarEvent){
	  console.log('eventEdited');
	  console.log(calendarEvent);
  }
  vm.eventDeleted = function(calendarEvent){
	  console.log('eventDeleted');
	  console.log(calendarEvent);
  }
  vm.eventClicked = function(calendarEvent){
	  console.log('eventClicked');
	  console.log(calendarEvent);
  }
  vm.eventTimesChanged = function(calendarEvent){
	  console.log('eventTimesChanged');
	  console.log(calendarEvent);
  };
  vm.cellModifier = function(cell) {
      cell.cssClass = 'calendar_row_style';
  }
  vm.timespanClicked = function(date) {
	  console.log('timespanClicked');
	  console.log(date);
  };
};