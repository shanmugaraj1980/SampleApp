/**
 * 
 */
//var allTestFiles = [];
//var TEST_REGEXP = /(Spec|test)\.js$/i;
//
//// Get a list of all the test files to include
//Object.keys(window.__karma__.files).forEach(function(file) {
//  if (TEST_REGEXP.test(file)) {
//    // Normalize paths to RequireJS module names.
//    // If you require sub-dependencies of test files to be loaded as-is (requiring file extension)
//    // then do not normalize the paths
//    var normalizedTestModule = file.replace(/^\/base\/|\.js$/g, '');
//    allTestFiles.push(normalizedTestModule);
//  }
//});

var tests = [];
for (var file in window.__karma__.files) {
  if (window.__karma__.files.hasOwnProperty(file)) {
//    if (/Spec\.js$/.test(file)) {
      tests.push(file);
//    }
  }
}

requirejs.config({
    // Karma serves files from '/base'
    baseUrl: '/base/',

    paths: {
    	'ko': 'main/webapp/js/lib/knockout',
        'crossroads':'main/webapp/js/lib/crossroads.min',
        'signals':'main/webapp/js/lib/signals.min',
        'hasher':'main/webapp/js/lib/hasher.min',
        'router':'main/webapp/js/app/router',
        'bootstrap':'main/webapp/js/lib/bootstrap.min',
        'Patient': 'main/webapp/js/app/component/patient'
    },
    
    shim: {
        'underscore': {
            exports: '_'
        }
    },

    // ask Require.js to load these files (all our tests)
    deps: tests,

    // start test run, once Require.js is done
    callback: window.__karma__.start
});