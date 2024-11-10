package com.jdbc.demo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class ApplicationDAOImpl implements IApplicationDAO {
    private final Connection conn;

    public ApplicationDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addApplication(Application application) {
        String sql = "INSERT INTO Applications (adopter_id, pet_id, status, application_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, application.getAdopterId());
            stmt.setInt(2, application.getPetId());
            stmt.setString(3, application.getStatus());
            stmt.setTimestamp(4, application.getApplicationDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding application " + e.getMessage());
        }
    }

    @Override
    public void updateApplication(Application application) {
        String sql = "UPDATE Applications SET adopter_id = ?, pet_id = ?, status = ?, application_date = ? WHERE application_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, application.getAdopterId());
            stmt.setInt(2, application.getPetId());
            stmt.setString(3, application.getStatus());
            stmt.setTimestamp(4, application.getApplicationDate());
            stmt.setInt(5, application.getApplicationId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding application " + e.getMessage());
        }
    }

    @Override
    public void deleteApplication(int applicationId) {
        String sql = "DELETE FROM Applications WHERE application_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, applicationId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while adding application " + e.getMessage());
        }
    }

    @Override
    public Application getApplicationById(int applicationId) {
        String sql = "SELECT * FROM Applications WHERE application_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, applicationId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Application application = new Application();
                application.setApplicationId(rs.getInt("application_id"));
                application.setAdopterId(rs.getInt("adopter_id"));
                application.setPetId(rs.getInt("pet_id"));
                application.setStatus(rs.getString("status"));
                application.setApplicationDate(rs.getTimestamp("application_date"));
                return application;
            }
        } catch (SQLException e) {
            System.out.println("Error while adding application " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM Applications";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Application application = new Application();
                application.setApplicationId(rs.getInt("application_id"));
                application.setAdopterId(rs.getInt("adopter_id"));
                application.setPetId(rs.getInt("pet_id"));
                application.setStatus(rs.getString("status"));
                application.setApplicationDate(rs.getTimestamp("application_date"));
                applications.add(application);
            }
        } catch (SQLException e) {
            System.out.println("Error while adding application " + e.getMessage());
        }
        return applications;
    }
}

