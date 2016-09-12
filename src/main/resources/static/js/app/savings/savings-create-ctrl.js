(function () {
    'use strict';

    angular
        .module("app.savings")
        .controller("SavingsCreateCtrl", ["SavingsService", SavingsCreateCtrl]);

    function SavingsCreateCtrl(SavingsService) {
        var vm = this;
        vm.save = save;

        init();

        function init() {
            $("#savingDate").datepicker();
        }

        function save() {
            if (!vm.saving) {
                return;
            }
            SavingsService.saveRecord(vm.saving, function(response) {
                delete vm.saving;
            })
        }

    }
})();
