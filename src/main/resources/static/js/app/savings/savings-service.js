(function () {
    'use strict';

    angular
        .module("app.savings")
        .factory("SavingsService", ['$resource', SavingsService]);


    function SavingsService($resource) {

        return $resource("../savings/:path", {id: "@id"}, {
            getListItems: {
                method: "GET",
                params: {
                    path: "list"
                }
            },
            total: {
                method: "GET",
                params: {
                    path: "total"
                }
            },
            saveRecord: {
                method: "POST",
                params: {
                    path: "save"
                }
            },
            remove: {
                method: "DELETE",
                params: {
                    path: "delete"
                }
            }
        });
    }
})();
