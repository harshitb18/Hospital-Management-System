package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Entity.Appointment;
import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Repository.AppointmentRepository;
import HMS.HospitalSystem.Repository.DoctorRepository;
import HMS.HospitalSystem.Repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;
    private SlotService slotService;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository,
                              SlotService slotService){
        this.appointmentRepository=appointmentRepository;
        this.doctorRepository=doctorRepository;
        this.slotService=slotService;
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization){
        return doctorRepository.findBySpecialization(specialization);
    }

    public void createAppointment(int patientId, int doctorId, LocalTime startTime){

        slotService.addSlot(doctorId,startTime,startTime.plusMinutes(30));
        Appointment appointment=new Appointment(patientId,doctorId,"Pending",startTime);

        appointmentRepository.save(appointment);
    }

    public List<Appointment> getAppointments(){
        return appointmentRepository.findAll();
    }

    public void deleteById(int appointmentId){
        appointmentRepository.deleteById(appointmentId);
    }

    public void updateStatus(int appointmentId,String status){
        Optional<Appointment> appointment=appointmentRepository.findById(appointmentId);
        appointment.orElseThrow().setStatus(status);
        appointmentRepository.save(appointment.orElseThrow());
    }

    public Optional<Appointment> getById(int appointmentId){
        return appointmentRepository.findById(appointmentId);
    }

    public List<Appointment> findByPatientId(int patientId){
        return appointmentRepository.findByPatientId(patientId);
    }
}
