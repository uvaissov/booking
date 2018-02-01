app.factory('alert', function($uibModal) {
    function show(action, event) {
      return $uibModal.open({
        templateUrl: 'modalContent.html',
        controller: function() {
          var vm1 = this;
          vm1.action = action;
          vm1.event = event;
        },
        controllerAs: 'vm1'
      });
    }

    return {
      show: show
    };

  });