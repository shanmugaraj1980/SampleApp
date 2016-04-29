define(['ko','crossroads','hasher'], function(ko,crossroads,hasher) {
	function activateCrossroads() {
		function parseHash(newHash, oldHash) {
			crossroads.parse(newHash);
		}
		crossroads.normalizeFn = crossroads.NORM_AS_OBJECT;
		hasher.initialized.add(parseHash);
		hasher.changed.add(parseHash);
		hasher.init();
	};
	
	return function Router(config) {
		var self = this;
		self.currentRoute = ko.observable();
		
		ko.utils.arrayForEach(config.routes, function (route) {
			 crossroads.addRoute(route.url, function (requestParams) {
				 self.currentRoute(ko.utils.extend(requestParams, route.params));
			 });
		});
		 
		crossroads.routed.add(console.log, console);
		activateCrossroads();
	};
});