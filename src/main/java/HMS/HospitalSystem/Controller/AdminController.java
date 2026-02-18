package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Appointment;
import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Service.AppointmentService;
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
    private AppointmentService appointmentService;

    public AdminController(PatientService patientService,
                           DoctorService doctorService,
                           SlotService slotService,
                           AppointmentService appointmentService){
        this.patientService=patientService;
        this.doctorService=doctorService;
        this.slotService=slotService;
        this.appointmentService=appointmentService;
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

    @GetMapping("/doctors/specializations/{specialization}")
    public List<Doctor> getDoctorBySpecialization(@PathVariable String specialization){
        return appointmentService.getDoctorsBySpecialization(specialization);
    }

    @PostMapping("/slots")
    public void addSlot(@RequestParam int doctorId,
                        @RequestParam LocalTime startTime, @RequestParam LocalTime endTime){
        slotService.addSlot(doctorId,startTime,endTime);
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

    @PostMapping("/slots/status/{slotId}")
    public void setSlotStatus(@PathVariable int slotId,@RequestParam String status){
        slotService.setStatusOfSlot(slotId,status);
    }

    @PostMapping("/appointments/{patientId}/doctors/{doctorId}")
    public void createAppointment(@PathVariable int patientId,@PathVariable int doctorId,
                                  @RequestParam LocalTime startTime){
        appointmentService.createAppointment(patientId,doctorId,startTime);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAppointments(){
        return appointmentService.getAppointments();
    }

    @DeleteMapping("/appointments/{appointmentId}")
    public void deleteAppointment(@PathVariable int appointmentId){
        appointmentService.deleteById(appointmentId);
    }

    @PutMapping("/appointments/{appointmentId}")
    public void updateAppointmentStatus(@PathVariable int appointmentId,
                                        @RequestParam String status){
        appointmentService.updateStatus(appointmentId,status);
    }

    @GetMapping("/appointments/{appointmentId}")
    public Optional<Appointment> getAppointmentById(@PathVariable int appointmentId){
        return appointmentService.getById(appointmentId);
    }
}
