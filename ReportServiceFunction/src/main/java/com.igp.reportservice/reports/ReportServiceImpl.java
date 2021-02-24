package com.igp.reportservice.reports;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.reportservice.dao.ReportCrudDao;
import com.igp.reportservice.dao.ReportServiceDaoImpl;
import com.igp.reportservice.model.Report;
import com.igp.reportservice.model.Examples;
import com.igp.reportservice.util.RequestBodyReader;
import com.igp.reportservice.util.ResponseEntity;
import com.igp.reportservice.util.path.PathParameters;

public class ReportServiceImpl implements ReportService {

    private final ReportCrudDao reportCrudDao;

    public ReportServiceImpl() {
        this.reportCrudDao = new ReportServiceDaoImpl();
    }

    @Override
    public ResponseEntity<Report> createReport(APIGatewayProxyRequestEvent event, Context context) {
        Report report = RequestBodyReader.getAsObject(event.getBody(), Report.class);
        return ResponseEntity.ok(reportCrudDao.createReport(report));
    }

    @Override
    public ResponseEntity<Report> readReport(APIGatewayProxyRequestEvent event, Context context) {
        return ResponseEntity.ok(reportCrudDao.readReport(PathParameters.getPathParameter(event,"id")));
    }

    @Override
    public ResponseEntity<Report> updateReport(APIGatewayProxyRequestEvent event, Context context) {
        Report report = RequestBodyReader.getAsObject(event.getBody(),Report.class);
        return ResponseEntity.ok(reportCrudDao.updateReport(report));
    }

    @Override
    public ResponseEntity<Report> deleteReport(APIGatewayProxyRequestEvent event, Context context) {
        reportCrudDao.deleteReport((PathParameters.getPathParameter(event,"id")));
        return null;
    }
}
