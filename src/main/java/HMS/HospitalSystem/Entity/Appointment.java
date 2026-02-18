package HMS.HospitalSystem.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private int patientId;

    private int doctorId;

    private int slotId;

    private String status;

    private LocalTime localTime;

    public Appointment(int patientId, int doctorId, int slotId, String status, LocalTime localTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.slotId = slotId;
        this.status = status;
        this.localTime = localTime;
    }

    public Appointment(int patientId, int doctorId,String status, LocalTime localTime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.status = status;
        this.localTime = localTime;
    }

    public Appointment(int patientId, int doctorId, int slotId, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.slotId = slotId;
        this.status = status;
    }

    public Appointment(int patientId,int slotId, String status) {
        this.patientId = patientId;
        this.slotId = slotId;
        this.status = status;
    }



    public Appointment() {

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", slotId=" + slotId +
                ", status='" + status + '\'' +
                ", localTime=" + localTime +
                '}';
    }
}
