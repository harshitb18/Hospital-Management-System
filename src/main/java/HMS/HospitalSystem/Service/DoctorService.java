package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;


    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }

    public void addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(int id){
        return doctorRepository.findById(id);
    }

    public void updateDoctor(int id,Doctor doctor){
        doctor.setDoctorId(id);
        doctorRepository.save(doctor);
    }

    public void deleteDoctor(int id){
        doctorRepository.deleteById(id);
    }



}
