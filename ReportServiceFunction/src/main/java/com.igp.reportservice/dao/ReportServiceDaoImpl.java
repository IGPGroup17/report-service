package com.igp.reportservice.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.igp.reportservice.config.DynamoDBConfig;
import com.igp.reportservice.dao.ReportCrudDao;
import com.igp.reportservice.model.Report;

import java.util.HashMap;
import java.util.Map;

public class ReportServiceDaoImpl implements ReportCrudDao {
    private DynamoDBMapper dynamoDBMapper;

    public ReportServiceDaoImpl() {
        this.dynamoDBMapper = DynamoDBConfig.dynamoDBMapper();
    }

    @Override
    public Report createReport(Report user) {
        dynamoDBMapper.save(user);
        return user;
    }

    @Override
    public Report readReport(String reportId) {
        return dynamoDBMapper.load(Report.class, reportId);
    }

    @Override
    public Report updateReport(Report report) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("reportId", new ExpectedAttributeValue(new AttributeValue().withS(report.getReportId())));
        DynamoDBSaveExpression saveExpression = new DynamoDBSaveExpression().withExpected(expectedAttributeValueMap);
        dynamoDBMapper.save(report, saveExpression);
        return report;
    }

    @Override
    public void deleteReport(String reportId) {
        Map<String, ExpectedAttributeValue> expectedAttributeValueMap = new HashMap<>();
        expectedAttributeValueMap.put("reportId", new ExpectedAttributeValue(new AttributeValue().withS(reportId)));
        DynamoDBDeleteExpression deleteExpression = new DynamoDBDeleteExpression().withExpected(expectedAttributeValueMap);
        Report report = Report.builder()
                .reportId(reportId)
                .build();
        dynamoDBMapper.delete(report, deleteExpression);
    }
}
