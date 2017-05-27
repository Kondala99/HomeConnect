angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://rest-service.guides.spring.io/greeting').
        then(function(response) {
            $scope.greeting = response.data;
        });
});

angular.module('demo', [])
.controller('SendData', function($scope, $http) {
    // use $.param jQuery function to serialize data from JSON
	            var data = $.param({
	                fName: $scope.firstName,
	                lName: $scope.lastName
	            });

	            var config = {
	                headers : {
	                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
	                }
	            }

	            $http.post('/ServerRequest/PostDataResponse', data, config)
	            .success(function (data, status, headers, config) {
	                $scope.PostDataResponse = data;
	            })
	            .error(function (data, status, header, config) {
	                $scope.ResponseDetails = "Data: " + data +
	                    "<hr />status: " + status +
	                    "<hr />headers: " + header +
	                    "<hr />config: " + config;
            });
});
