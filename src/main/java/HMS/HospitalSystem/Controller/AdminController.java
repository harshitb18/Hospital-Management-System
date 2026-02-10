package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Service.DoctorService;
import HMS.HospitalSystem.Service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private PatientService patientService;
    private DoctorService doctorService;

    public AdminController(PatientService patientService,
                           DoctorService doctorService){
        this.patientService=patientService;
        this.doctorService=doctorService;
    }

    @GetMapping("/patients")
    public List<Patient> getPatients(){
        return patientService.getPatients();
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient){
        patientService.addPatient(patient);
    }

    @GetMapping("/patients/{patientId}")
    public Optional<Patient> getById(@PathVariable int patientId){
        return patientService.getById(patientId);
    }

    @PutMapping("/patients/{patientId}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable int patientId){
        patientService.updatePatient(patientId,patient);
    }

    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable int patientId){
        patientService.deletePatient(patientId);
    }

    @PostMapping("/doctors")
    public void addDoctor(@RequestBody Doctor doctor){
        doctorService.addDoctor(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getDoctors(){
        return doctorService.getDoctors();
    }

    @GetMapping("/doctors/{doctorId}")
    public Optional<Doctor> getDoctorById(@PathVariable int doctorId){
        return doctorService.getDoctorById(doctorId);
    }

    @PutMapping("/doctors/{doctorId}")
    public void updateDoctor(@PathVariable int doctorId,@RequestBody Doctor doctor){
        doctorService.updateDoctor(doctorId,doctor);
    }

    @DeleteMapping("/doctors/{doctorId}")
    public void deleteDoctor(@PathVariable int doctorId){
        doctorService.deleteDoctor(doctorId);
    }
}
