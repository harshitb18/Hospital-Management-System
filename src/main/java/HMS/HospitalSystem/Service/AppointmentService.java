package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Repository.AppointmentRepository;
import HMS.HospitalSystem.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private AppointmentRepository appointmentRepository;
    private DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorRepository doctorRepository){
        this.appointmentRepository=appointmentRepository;
        this.doctorRepository=doctorRepository;
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization){
        return doctorRepository.findBySpecialization(specialization);
    }

}
