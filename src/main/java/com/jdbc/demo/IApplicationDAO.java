package com.jdbc.demo;

import java.util.List;

interface IApplicationDAO {
    void addApplication(Application application);
    void updateApplication(Application application);
    void deleteApplication(int applicationId);
    Application getApplicationById(int applicationId);
    List<Application> getAllApplications();
}
