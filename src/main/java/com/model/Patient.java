package com.model;


public class Patient {

    private int patientID;
    private String patientName;
    private int age;
    private String gender;
    private String admissionDate;
    private String ailment;
    private String assignedDoctor;

    // ✅ Constructor WITHOUT ID (USED FOR INSERT)
    public Patient(String patientName, int age, String gender,
                   String admissionDate, String ailment, String assignedDoctor) {

        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.admissionDate = admissionDate;
        this.ailment = ailment;
        this.assignedDoctor = assignedDoctor;
    }

    // ✅ Constructor WITH ID (USED FOR DISPLAY)
    public Patient(int patientID, String patientName, int age, String gender,
                   String admissionDate, String ailment, String assignedDoctor) {

        this.patientID = patientID;
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.admissionDate = admissionDate;
        this.ailment = ailment;
        this.assignedDoctor = assignedDoctor;
    }

    // getters
    public int getPatientID() { return patientID; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getAdmissionDate() { return admissionDate; }
    public String getAilment() { return ailment; }
    public String getAssignedDoctor() { return assignedDoctor; }
}
