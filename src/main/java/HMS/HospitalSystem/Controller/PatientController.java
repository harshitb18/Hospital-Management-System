package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Service.PatientService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    private PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @PutMapping("/patients/{patientId}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable int patientId){
        patientService.updatePatient(patientId,patient);
    }

    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable int patientId){
        patientService.deletePatient(patientId);
    }
}
