package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }
}
