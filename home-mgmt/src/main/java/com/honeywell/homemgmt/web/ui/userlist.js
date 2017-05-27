app.controller('demo', function($scope, $http) {
    $http.get("http://localhost:8080/api/users/")
    .then(function (response) {$scope.users = response.data.records;});
});


