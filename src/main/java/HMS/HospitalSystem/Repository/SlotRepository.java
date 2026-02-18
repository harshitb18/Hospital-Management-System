package HMS.HospitalSystem.Repository;

import HMS.HospitalSystem.Entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {

    List<Slot> findByDoctorId(int doctorId);
}
