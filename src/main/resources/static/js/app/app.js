(function () {
    'use strict';

    angular
        .module("app", ["ngRoute", "ngResource", "app.pagination", "app.spendings"])
        .controller("AppCtrl", [AppCtrl]);

    function AppCtrl() {
        var vmApp = this;
        vmApp.id = 'IDXXX';
        vmApp.content = 'This is content';

    }

})();
