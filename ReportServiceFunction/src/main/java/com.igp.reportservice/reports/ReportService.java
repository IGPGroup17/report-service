package com.igp.reportservice.reports;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.igp.reportservice.model.Report;
import com.igp.reportservice.util.IService;
import com.igp.reportservice.util.ResponseEntity;

public interface ReportService extends IService {

    ResponseEntity<Report> createReport(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Report> readReport(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Report> updateReport(APIGatewayProxyRequestEvent event, Context context);

    ResponseEntity<Report> deleteReport(APIGatewayProxyRequestEvent event, Context context);
}
