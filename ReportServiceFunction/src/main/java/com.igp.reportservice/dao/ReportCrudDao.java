package com.igp.reportservice.dao;

import com.igp.reportservice.model.Report;

public interface ReportCrudDao {
     Report createReport(Report user);
     Report readReport(String reportId);
     Report updateReport(Report report);
     void deleteReport(String reportId);
}
