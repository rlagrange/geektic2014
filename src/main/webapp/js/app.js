var app = angular.module("geektic", ['ngRoute', 'angular-md5']);

app.controller('UsersCtrl', function($scope, $http) {
    // On récupère via le http
    $http.get('http://localhost:8080/api/utilisateur/list').success(function(data, status, headers, config) {
        $scope.users = data;
    });
});

app.controller('UserCtrl', function($scope, $route, $routeParams, $http, md5) {
    $http.get('http://localhost:8080/api/utilisateur/show/' + $route.current.params.id).success(function(data, status, headers, config) {
        $scope.user = data;
        $scope.user.gravatar = md5.createHash(data.mail);
    });
});

app.controller('rechercheInitCtrl', function($scope, $http) {
    $http.get('http://localhost:8080/api/centre_interet/list').success(function(data, status, headers, config) {
        $scope.cis = data;
    });
});


app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/', {
        templateUrl: 'views/main.html',
      })
      .when('/utilisateurs', {
    	  templateUrl: 'views/utilisateurs.html',
    	  controller: 'UsersCtrl'
      }).when('/utilisateur', {
    	 templateUrl: 'views/utilisateur.html',
    	 controller: 'UserCtrl'
      }).when('/recherche', {
    	  templateUrl: 'views/recherche.html',
    	  controller: 'rechercheInitCtrl'
      });
  }]);