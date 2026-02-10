package HMS.HospitalSystem.Service;

import HMS.HospitalSystem.Repository.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class SlotService {

    private SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository){
        this.slotRepository=slotRepository;
    }
}
