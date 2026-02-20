package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Appointment;
import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Service.AppointmentService;
import HMS.HospitalSystem.Service.PatientService;
import HMS.HospitalSystem.Service.SlotService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class PatientController {

    private PatientService patientService;
    private SlotService slotService;
    private AppointmentService appointmentService;

    public PatientController(PatientService patientService,
                             SlotService slotService,
                             AppointmentService appointmentService) {
        this.patientService = patientService;
        this.slotService = slotService;
        this.appointmentService=appointmentService;
    }

    @PostMapping("/patients")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/patients/{patientId}")
    public void updatePatient(@RequestBody Patient patient, @PathVariable int patientId) {
        patientService.updatePatient(patientId, patient);
    }

    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable int patientId) {
        patientService.deletePatient(patientId);
    }

    @GetMapping("patients/{doctorId}/slots")
    public List<Slot> getSlotsByDoctor(@PathVariable int doctorId) {
        return slotService.getSlotByDoctor(doctorId);
    }

    @PostMapping("/patients/{patientId}/slots")
    public void addSlot(@RequestParam int doctorId,
                        @RequestParam LocalTime startTime, @RequestParam LocalTime endTime) {
        slotService.addSlot(doctorId, startTime, endTime);
    }

    @GetMapping("/patients/doctors/specializations/{specialization}")
    public List<Doctor> getDoctorBySpecialization(@PathVariable String specialization){
        return appointmentService.getDoctorsBySpecialization(specialization);
    }

    @PostMapping("/patients/appointments/{patientId}/doctors/{doctorId}")
    public void createAppointment(@PathVariable int patientId,@PathVariable int doctorId,
                                  @RequestParam LocalTime startTime){
        appointmentService.createAppointment(patientId,doctorId,startTime);
    }

    @GetMapping("/patients/{patientId}/appointments")
    public List<Appointment> getAppointmentsByPatient(@PathVariable int patientId){
        return appointmentService.findByPatientId(patientId);
    }
}
