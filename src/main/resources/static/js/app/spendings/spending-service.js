(function () {
    'use strict';

    angular
        .module("app.spendings")
        .factory("SpendingsService", ['$resource', SpendingsService]);


    function SpendingsService($resource) {

        return $resource("../spending/:path", {id: "@id"}, {
            getListItems: {
                method: "GET",
                params: {
                    path: "list"
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
