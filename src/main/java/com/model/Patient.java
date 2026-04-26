package com.model;


public class Patient {
    private int patientID;
    private String patientName;
    private int age;
    private String gender;
    private String admissionDate;
    private String ailment;
    private String assignedDoctor;

    public Patient(int id, String name, int age, String gender,
                   String date, String ailment, String doctor) {
        this.patientID = id;
        this.patientName = name;
        this.age = age;
        this.gender = gender;
        this.admissionDate = date;
        this.ailment = ailment;
        this.assignedDoctor = doctor;
    }

    // Getters
    public int getPatientID() { return patientID; }
    public String getPatientName() { return patientName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getAdmissionDate() { return admissionDate; }
    public String getAilment() { return ailment; }
    public String getAssignedDoctor() { return assignedDoctor; }
}