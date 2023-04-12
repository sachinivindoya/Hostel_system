package lk.D24.view.tm;

import com.jfoenix.controls.JFXButton;
import lombok.*;



public class StudentTm {
    private String studentID;
    private String Name;
    private String Address;
    private String Contact;
    private String DoB;
    private String Gender;
    private JFXButton Option;

    @Override
    public String toString() {
        return "StudentTm{" +
                "studentID='" + studentID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                ", DoB='" + DoB + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Option=" + Option +
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

    public JFXButton getOption() {
        return Option;
    }

    public void setOption(JFXButton option) {
        Option = option;
    }

    public StudentTm(String studentID, String name, String address, String contact, String doB, String gender, JFXButton option) {
        this.studentID = studentID;
        Name = name;
        Address = address;
        Contact = contact;
        DoB = doB;
        Gender = gender;
        Option = option;
    }

    public StudentTm() {
    }
}
