define(['ko'], function(ko) {
	ko.bindingHandlers.datepicker = {
		    init: function(element, valueAccessor, allBindings, viewModel, bindingContext) {
		    	$(element).datepicker();
		    }
	};
	
	function isNotBlank(value) {
		return value!=null && value!='' && value!='undefined';
	}
	
	function Patient(value) {
		var self = this;
		
		self.id = ko.observable('');
		self.firstName = ko.observable('');
		self.lastName = ko.observable('');
		self.gender = ko.observable('');
		self.email = ko.observable('');
		self.dob = ko.observable('');
		self.line1 = ko.observable('');
		self.line2 = ko.observable('');
		self.city = ko.observable('');
		self.state = ko.observable('');
		self.zip = ko.observable('');
		
		self.init = function(value) {
			var patient = value.patient;
			if (patient) {
				self.id(patient.id);
				self.firstName(patient.firstName);
				self.lastName(patient.lastName);
				self.gender(patient.gender);
				self.email(patient.email);
				self.dob(patient.dob);
				self.line1(patient.line1);
				self.line2(patient.line2);
				self.city(patient.city);
				self.state(patient.state);
				self.zip(patient.zip);
			}
			else if (value.patientModel) {
				patient = value.patientModel;
				self.id(patient.id());
				self.firstName(patient.firstName());
				self.lastName(patient.lastName());
				self.gender(patient.gender());
				self.email(patient.email());
				self.dob(patient.dob());
				self.line1(patient.line1());
				self.line2(patient.line2());
				self.city(patient.city());
				self.state(patient.state());
				self.zip(patient.zip());
			}
			else if (value.id) {
				$.get('/api/patient/'+value.id,{},function(data){
					self.init({"patient":data});
				});
			}
		};
		
		self.genderDisplay = ko.pureComputed(function(){
			return self.gender()=='M'?'Male':'Female';
		});
		
		self.canSave = ko.computed(function(){
			return isNotBlank(self.firstName()) && isNotBlank(self.lastName())
			 && isNotBlank(self.email()) && isNotBlank(self.gender()) && isNotBlank(self.dob());
		});
		
		self.save = function () {
			var url = '/api/patient';
			var method='POST';
			if (self.id()) {
				url+='/'+self.id();
				method='PUT';
			}
			$.ajax({
				data:ko.toJSON(self),
				contentType:'application/json',
				method:method,
				url:url,
				complete:function(jqXhr,statusText) {
					if (jqXhr.status == 201 || jqXhr.status == 200) {
						$('#alertContainer').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> This patient has been saved successfully</div>');
					}
					else {
						$('#alertContainer').html('<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> Oops! Something went wrong</div>');
					}
				}
			});
		};
		
		self.patientUri= ko.pureComputed(function(){
			return '#patient/'+self.id();
		});
		
		self.remove = function() {
			var retVal = false;
			$.ajax({
				contentType:'application/json',
				method:'DELETE',
				url:'/api/patient/' + self.id(),
				async:false,
				complete:function(jqXhr,statusText) {
					if (jqXhr.status == 204) {
						$('#alertContainer').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> This patient has been deleted successfully</div>');
						retVal = true;
					}
					else {
						$('#alertContainer').html('<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button> Oops! Something went wrong</div>');
					}
				}
			});
			return retVal;
		};
		
		self.init(value);
	};
	
	return Patient;
});