'use strict';

var angular = require('angular');
var interact;
try {
  interact = require('interactjs');
} catch (e) {
  /* istanbul ignore next */
  interact = null;
}

angular
  .module('BookingApp')
  .constant('interact', interact);
