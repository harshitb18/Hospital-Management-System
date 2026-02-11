package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Service.DoctorService;
import HMS.HospitalSystem.Service.PatientService;
import HMS.HospitalSystem.Service.SlotService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private PatientService patientService;
    private DoctorService doctorService;
    private SlotService slotService;

    public AdminController(PatientService patientService,
                           DoctorService doctorService,
                           SlotService slotService){
        this.patientService=patientService;
        this.doctorService=doctorService;
        this.slotService=slotService;
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

    @PostMapping("/slots")
    public void addSlot(@RequestParam int doctorId, @RequestParam LocalDate date,
                        @RequestParam LocalTime startTime, @RequestParam LocalTime endTime){
        slotService.addSlot(doctorId,date,startTime,endTime);
    }

    @GetMapping("/slots")
    public List<Slot> getSlots(){
        return slotService.getSlots();
    }

    @GetMapping("/slots/{slotId}")
    public Optional<Slot> getSlotById(@PathVariable int slotId){
        return slotService.getSlotById(slotId);
    }

    @PutMapping("/slots/{slotId}")
    public void updateSlotById(@PathVariable int slotId,@RequestParam int doctorId,
                               @RequestParam LocalDate date,
                               @RequestParam LocalTime startTime, @RequestParam LocalTime endTime,
                               @RequestParam String status){
        slotService.updateSlot(slotId,doctorId,date,startTime,endTime,status);
    }

    @DeleteMapping("/slots/{slotId}")
    public void deleteSlotById(@PathVariable int slotId){
        slotService.deleteSlotById(slotId);
    }
}
