package com.igp.reportservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.igp.reportservice.service.ReportService;
import com.igp.reportservice.service.ReportServiceImpl;
import com.igp.reportservice.util.EnvironmentLogger;
import com.igp.reportservice.util.ResponseEntity;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        EnvironmentLogger.log(event, context);
        return routeRequest(event, context, new ReportServiceImpl()).toApiGatewayProxyResponseEvent();
    }

    private ResponseEntity<?> routeRequest(APIGatewayProxyRequestEvent event, Context context, ReportService service) {
        return ResponseEntity.ok("Hello world");
//        return AmazonExceptionHandler.handle(() -> {
//            String resource = event.getResource();
//            String httpMethod = event.getHttpMethod();
//
//            if (resource.equalsIgnoreCase("/v1/reports") && httpMethod.equals("POST")) {
//                return ResponseEntity.ok(service.createReport(event, context));
//            } else if (resource.equalsIgnoreCase("/v1/reports/{id}") && httpMethod.equals("GET")) {
//                return ResponseEntity.ok(service.readReport(event, context));
//            } else if (resource.equalsIgnoreCase("/v1/reports") && httpMethod.equals("UPDATE")) {
//                return ResponseEntity.ok(service.updateReport(event, context));
//            } else if (resource.equalsIgnoreCase("/v1/reports/{id}") && httpMethod.equals("DELETE")) {
//                return ResponseEntity.ok(service.deleteReport(event, context));
//            } else {
//                return ResponseEntity.notFound();
//            }
//        });
    }
}
