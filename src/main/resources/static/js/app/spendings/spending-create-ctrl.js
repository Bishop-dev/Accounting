(function () {
    'use strict';

    angular
        .module("app.spendings")
        .controller("SpendingCreateCtrl", ["SpendingsService", SpendingCreateCtrl]);

    function SpendingCreateCtrl(SpendingsService) {
        var vm = this;
        vm.save = save;

        init();

        function init() {
            $("#spendingDate").datepicker();
        }

        function save() {
            console.log(vm.spending);
            SpendingsService.saveRecord(vm.spending, function(response) {
                console.log(response);
            })
        }

    }
})();
