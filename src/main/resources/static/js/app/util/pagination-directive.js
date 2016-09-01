(function () {
    'use strict';

    angular
        .module("app.pagination")
        .directive("pagination", [pagination]);

    function pagination(){
        return {
            restrict: "E",
            templateUrl: "util/pagination.html",
            scope: {
                total: "=",
                sizeItems: "=",
                defaultPageNumber: "=",
                defaultPageSize: "=",
                onChange: "&"
            },
            link: function(scope) {
                scope.sizeItems = scope.sizeItems || [10, 25, 50, 100];
                scope.minPageSize = scope.sizeItems[0];
                scope.pageSize = scope.defaultPageSize || scope.sizeItems[0];
                scope.pageNumber = scope.defaultPageNumber || 1;
                scope.getPagesCount = getPagesCount;
                scope.setPageNumber = setPageNumber;
                scope.setPageSize = setPageSize;
                scope.getNavigatedPages = getNavigatedPages;
                scope.back = goBack;
                scope.next = goNext;

                function goBack() {
                    scope.setPageNumber(scope.pageNumber - 1);
                }

                function goNext() {
                    scope.setPageNumber(scope.pageNumber + 1);
                }

                function setPageNumber(page) {
                    var number = parseInt(page);
                    if(isNaN(number) || number <= 0 || number > getPagesCount() || number == scope.pageNumber) {
                        return;
                    }
                    scope.pageNumber = number;
                    changed();
                }

                function setPageSize(size) {
                    scope.pageNumber = 1;
                    scope.pageSize = parseInt(size);
                    changed();
                }

                function getNavigatedPages() {
                    var current = scope.pageNumber;
                    var start = Math.max( current - 2, 1);
                    var end = Math.min( current + 2, getPagesCount());
                    var range = [];
                    for(var i = start; i <= end; ++i) {
                        range.push(i);
                    }
                    return range;
                }

                function changed() {
                    scope.onChange && scope.onChange({
                        params: {
                            pageNumber: scope.pageNumber,
                            pageSize: parseInt(scope.pageSize)
                        }
                    });
                }

                function getPagesCount() {
                    return Math.ceil(scope.total / scope.pageSize);
                }

            }
        }
    }

})();
