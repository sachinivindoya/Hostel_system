package lk.D24.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Student implements SuperEntity{
    @Id
    private String studentID;
    private String Name;
    private String Address;
    private String Contact;
    private String DoB;
    private String Gender;

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", DoB='" + DoB + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Student(String studentID, String name, String address, String contact, String doB, String gender) {
        this.studentID = studentID;
        this.Name = name;
        this.Address = address;
        this.Contact = contact;
        this.DoB = doB;
        this.Gender = gender;
    }

    public Student() {
    }
}
