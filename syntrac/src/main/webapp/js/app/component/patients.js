define(['ko','Patient'], function(ko,Patient) {
	
	function Patients() {
		var self = this;
		self.patients=ko.observableArray();
		self.filter=ko.observable('');
		
		self.fetchAll = function() {
			$.get('/api/patient',{},function(data){
				self.patients.removeAll();
				ko.utils.arrayForEach(data,function(myPatient){
					self.patients.push(new Patient({"patient":myPatient}));
				});
			});
		};
		
		self.remove = function(patient) {
			if(patient.remove()) {
				self.patients.remove(function(value){return value.id() == patient.id();});
				self.patients.valueHasMutated();
			}
		}
		
		self.fetchAll();
	}
	
	return Patients;
});