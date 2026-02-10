package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Entity.Patient;
import HMS.HospitalSystem.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }

    public void addPatient(Patient patient){
        patientRepository.save(patient);
    }

    public List<Patient> getPatients(){
        return patientRepository.findAll();
    }

    public Optional<Patient> getById(int id){
        return  patientRepository.findById(id);
    }

    public void updatePatient(int id,Patient patient){
        patient.setPatientId(id);
        patientRepository.save(patient);
    }

    public void deletePatient(int id){
        patientRepository.deleteById(id);
    }
}
