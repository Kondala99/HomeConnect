app.controller('demo', function($scope, $http) {
    $http.get("http://localhost:8080/api/home/security/")
    .then(function (response) {$scope.security = response.data.records;});
});


