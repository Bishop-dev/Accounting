(function () {
    'use strict';

    angular
        .module("app", ["ngRoute", "ngResource", "app.spendings", "app.savings"])
        .controller("AppCtrl", [AppCtrl]);

    function AppCtrl() {

    }

})();
