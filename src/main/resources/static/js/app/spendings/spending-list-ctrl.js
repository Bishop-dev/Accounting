(function () {
    'use strict';

    angular
        .module("app.spendings")
        .controller("SpendingListCtrl", ["SpendingsService", SpendingListCtrl]);

    function SpendingListCtrl(SpendingsService) {
        var vm = this;
        vm.pagedRecords = {
            records: [],
            pageNumber: 0,
            pageSize: 10,
            total: 0,
            onChange: function (params) {
                vm.pagedRecords.pageNumber = params.pageNumber || 1;
                vm.pagedRecords.pageSize = params.pageSize || 10;
                loadRecordsFromServer();
            }
        };

        init();

        function init() {
            loadRecordsFromServer();
        }

        function loadRecordsFromServer() {
            var start = new Date().getTime() - 7*24*60*60*1000;
            var request = {
                start: new Date(start).toISOString().slice(0, 10).replace(/-/g, '/'),
                finish: new Date().toISOString().slice(0, 10).replace(/-/g, '/'),
                pageNumber: vm.pagedRecords.pageNumber,
                pageSize: vm.pagedRecords.pageSize,
                userId: 1
            };
            SpendingsService.getListItems(request, function(response) {
                vm.pagedRecords.items = response.result.content;
                vm.pagedRecords.total = response.result.total;
            });
        }

    }
})();
