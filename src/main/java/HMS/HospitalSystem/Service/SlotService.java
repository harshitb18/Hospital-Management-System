package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Repository.SlotRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    private SlotRepository slotRepository;
    private DoctorService doctorService;

    public SlotService(SlotRepository slotRepository,
                       DoctorService doctorService){
        this.slotRepository=slotRepository;
        this.doctorService=doctorService;
    }

    public void addSlot(int doctorId, LocalDate date, LocalTime startTime,LocalTime endTime){

        Slot slot=new Slot(doctorId,date,startTime,endTime,"Booked");
        Optional<Doctor> doctor=doctorService.getDoctorById(doctorId);

        if(!doctor.orElseThrow().isActive()){
            throw new RuntimeException("Doctor not available");
        }

        doctor.orElseThrow().getSlot().add(slot);
        slot.setDoctor(doctor.orElseThrow());
        slotRepository.save(slot);
        doctorService.updateDoctor(doctorId,doctor.orElseThrow());
    }

    public List<Slot> getSlots(){
        return slotRepository.findAll();
    }

    public Optional<Slot> getSlotById(int id){
        return slotRepository.findById(id);
    }

    public void updateSlot(int slotId,int doctorId, LocalDate date,
                           LocalTime startTime,LocalTime endTime,String status){
        Slot slot=new Slot(doctorId,date,startTime,endTime,status);
        slot.setSlotId(slotId);
        slotRepository.save(slot);
    }

    public void deleteSlotById(int slotId){
        slotRepository.deleteById(slotId);
    }
}
