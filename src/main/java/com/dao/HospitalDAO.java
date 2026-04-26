package com.dao;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.model.Patient;

public class HospitalDAO {

    private String url = "jdbc:mysql://localhost:3306/hospitaldb";
    private String user = "root";
    private String pass = "root123";

    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, user, pass);
    }

    // ADD
    public boolean addPatient(Patient p) {
        String sql = "INSERT INTO Patients VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, p.getPatientID());
            ps.setString(2, p.getPatientName());
            ps.setInt(3, p.getAge());
            ps.setString(4, p.getGender());
            ps.setDate(5, java.sql.Date.valueOf(p.getAdmissionDate()));
            ps.setString(6, p.getAilment());
            ps.setString(7, p.getAssignedDoctor());

            int rows = ps.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();   // 👈 THIS WILL SHOW REAL ERROR
        }
        return false;
    }
    // UPDATE
    public boolean updatePatient(Patient p) {
        String sql = "UPDATE Patients SET PatientName=?, Age=?, Ailment=?, AssignedDoctor=? WHERE PatientID=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getPatientName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getAilment());
            ps.setString(4, p.getAssignedDoctor());
            ps.setInt(5, p.getPatientID());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM Patients WHERE PatientID=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // DISPLAY
    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM Patients")) {

            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getInt("Age"),
                    rs.getString("Gender"),
                    rs.getDate("AdmissionDate").toString(),
                    rs.getString("Ailment"),
                    rs.getString("AssignedDoctor")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // REPORTS
    public List<Patient> getByDoctor(String doctor) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patients WHERE AssignedDoctor=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getInt("Age"),
                    rs.getString("Gender"),
                    rs.getDate("AdmissionDate").toString(),
                    rs.getString("Ailment"),
                    rs.getString("AssignedDoctor")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Patient> getByAilment(String ailment) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patients WHERE Ailment=?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, ailment);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getInt("Age"),
                    rs.getString("Gender"),
                    rs.getDate("AdmissionDate").toString(),
                    rs.getString("Ailment"),
                    rs.getString("AssignedDoctor")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Patient> getByDateRange(String from, String to) {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Patients WHERE AdmissionDate BETWEEN ? AND ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Patient(
                    rs.getInt("PatientID"),
                    rs.getString("PatientName"),
                    rs.getInt("Age"),
                    rs.getString("Gender"),
                    rs.getDate("AdmissionDate").toString(),
                    rs.getString("Ailment"),
                    rs.getString("AssignedDoctor")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
   
}