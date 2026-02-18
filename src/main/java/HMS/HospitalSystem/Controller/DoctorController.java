package HMS.HospitalSystem.Controller;

import HMS.HospitalSystem.Entity.Doctor;
import HMS.HospitalSystem.Entity.Slot;
import HMS.HospitalSystem.Service.DoctorService;
import HMS.HospitalSystem.Service.SlotService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorController {

    private DoctorService doctorService;
    private SlotService slotService;

    public DoctorController(DoctorService doctorService,
                            SlotService slotService){
        this.doctorService=doctorService;
        this.slotService=slotService;
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

    @GetMapping("doctors/{doctorId}/slots")
    public List<Slot> getSlotsByDoctor(@PathVariable int doctorId){
        return slotService.getSlotByDoctor(doctorId);
    }

    @PostMapping("/doctors/{doctorId}/slots")
    public void addSlot(@PathVariable int doctorId,
                        @RequestParam LocalTime startTime, @RequestParam LocalTime endTime){
        slotService.addSlot(doctorId,startTime,endTime);
    }


    /*
    @PutMapping("/doctors/{doctorId}/{slotId}")
    public void updateSlotByDoctor(@PathVariable int doctorId,@PathVariable int slotId){
        doctorService.updateSlotByDoctor(doctorId,slotId);
    }
*/
    @PutMapping("/doctors/{doctorId}/slots/status/{slotId}")
    public void setSlotStatus(@PathVariable int slotId,@RequestParam String status){
        slotService.setStatusOfSlot(slotId,status);
    }

}
