package lk.D24.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ReserveDetails")
public class ReserveDetails implements SuperEntity{
    @Id
    @Column(name="res_id",columnDefinition = "VARCHAR(255)")
    private String res_id;

    @Column(name="Reserved Date",columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "Expired Date",columnDefinition = "DATE")
    private String ExpiredDate;

    @ManyToOne(targetEntity = Student.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name="student_ID",referencedColumnName = "studentID"
    )
    private Student student;

    @ManyToOne(targetEntity = Room.class, fetch = FetchType.EAGER)
    @JoinColumn(
            name="room_type_id",referencedColumnName = "room_type_id"
    )
    private Room room;

    @Column(name="status",columnDefinition = "VARCHAR(255)")
    private String status;

    @Override
    public String toString() {
        return "ReserveDetails{" +
                "res_id='" + res_id + '\'' +
                ", date=" + date +
                ", ExpiredDate='" + ExpiredDate + '\'' +
                ", student=" + student +
                ", room=" + room +
                ", status='" + status + '\'' +
                '}';
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getExpiredDate() {
        return ExpiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        ExpiredDate = expiredDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ReserveDetails() {
    }

    public ReserveDetails(String res_id, LocalDate date, String expiredDate, Student student, Room room, String status) {
        this.res_id = res_id;
        this.date = date;
        ExpiredDate = expiredDate;
        this.student = student;
        this.room = room;
        this.status = status;
    }
}
