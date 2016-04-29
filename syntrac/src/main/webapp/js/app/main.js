(function () {

    requirejs.config({
        paths: {
            'ko': '/js/lib/knockout',
            'crossroads':'/js/lib/crossroads.min',
            'signals':'/js/lib/signals.min',
            'hasher':'/js/lib/hasher.min',
            'router':'/js/app/router',
            'bootstrap':'/js/lib/bootstrap.min',
            'Patient':'/js/app/component/patient'
        }
    });

    define(['require', 'bootstrap','ko','signals','crossroads','hasher','router'], function (require, bootstrap,ko,signals,crossroads,hasher,router) {
    	ko.components.register('home', {
    	    viewModel: { require: '../app/component/home' },
    	    template: { require: 'text!../template/home.html' }
    	});
    	ko.components.register('patient_summary', {
    	    viewModel: { require: '../app/component/patients' },
    	    template: { require: 'text!../template/patient_summary.html' }
    	});
    	ko.components.register('procedure_summary', {
    	    viewModel: { require: '../app/component/procedure' },
    	    template: { require: 'text!../template/procedure_summary.html' }
    	});
    	ko.components.register('patient_list_item',{
    		viewModel: { require: '../app/component/patient' },
    	    template: { require: 'text!../template/patient_list_item.html' }
    	});
    	ko.components.register('patient_detail',{
    		viewModel: { require: '../app/component/patient' },
    	    template: { require: 'text!../template/patient_detail.html' }
    	});
    	ko.applyBindings(new router({
    		"routes":[
    		          {url:'',params:{page:'home'}},
    		          {url:'patient',params:{page:'patient_summary'}},
    		          {url:'procedure',params:{page:'procedure_summary'}},
    		          {url:'patient/create',params:{page:'patient_detail',patient:null}},
    		          {url:'patient/{id}',params:{page:'patient_detail'}}
    		 ]
    	}));
    });
})()

