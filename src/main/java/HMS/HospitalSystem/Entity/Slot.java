package HMS.HospitalSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slotId;

    private int doctorId;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private String status;

    public Slot(int doctorId, LocalDate date, LocalTime startTime, LocalTime endTime, String status) {
        this.doctorId = doctorId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Slot() {

    }
}
