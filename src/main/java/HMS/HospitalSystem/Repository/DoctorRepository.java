package HMS.HospitalSystem.Repository;

import HMS.HospitalSystem.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    List<Doctor> findBySpecialization(String specialization);
}
