/**
 * 
 */

define(['ko','Patient'], function(ko,Patient) {

    describe('Patient Creation Test Suite', function() {
        it('Initialize patient', function() {
        	var value = {"patient":{"id":20}};
        	var patient = new Patient(value);
        	expect(patient.patientUri()).toEqual('#patient/20');
        });

    });

});