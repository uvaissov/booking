/**
 * Контроллер для управления должностями
 * 
 */
app.controller('Setting_EmployeesCtrl', Setting_EmployeesCtrl);

function Setting_EmployeesCtrl ($http) {
  var emp = this; 
  emp.type = 'list';
  emp.switchContent=function(type){
	  emp.position = null;
	  emp.type = type;
  }
  emp.message = null;
  emp.employees = [];
  
  emp.addEmp = function(employ){
		if(	angular.isDefined(employ) &&
	  		angular.isDefined(employ.name)){
			if(angular.isDefined(employ.id)){
				$http.put('/setting/position/'+position.id, position)
				.then(
					       function(response){
					    	   emp.employees.push(response.data);
					    	   emp.type = 'list';
					    	   emp.getPosition();
					       }, 
					       function(response){
					    	   console.log(response);
					    	   emp.message = response.message;
					       }
					    );
			} else {
			$http.post('/setting/position', employ)
			.then(
				       function(response){
				    	   emp.employees.push(response.data);
				    	   emp.type = 'list';
				       }, 
				       function(response){
				    	   console.log(response);
				    	   emp.message = response.message;
				       }
				    );
			}
	  	}
  };
  emp.updateEmp = function(employ){
	  emp.type = 'add';
	  emp.employ = employ;
  };
  
  emp.removeEmp = function(item,index){
  		$http.delete('/setting/position/'+item.id, null)
		.then(
			       function(response){
			    	   emp.getEmployees();
			       }, 
			       function(response){
			    	   console.log(response);
			    	   emp.message = response.message;
			       }
			    ); 
  };
  
  emp.getEmployees = function(){
	  $http.get('/setting/position', null)
		.then(
			       function(response){
			    	   emp.positions = response.data;
			       }, 
			       function(response){
			    	   console.log(response);
			    	   emp.message = response.message;
			       }
			    ); 
  }
  
  // load positions
  emp.getEmployees();
  
};