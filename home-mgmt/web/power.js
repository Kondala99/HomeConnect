angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8080/api/home/power/').
        then(function(response) {
            $scope.power = response.data;
        });
});
