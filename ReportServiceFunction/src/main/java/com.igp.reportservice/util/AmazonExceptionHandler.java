package com.igp.reportservice.util;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import lombok.experimental.UtilityClass;

import java.util.function.Supplier;

@UtilityClass
public class AmazonExceptionHandler {

    public <T> T handle(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (AmazonServiceException ase) {
            System.err.println("Could not complete operation");
            System.err.println("Error Message:  " + ase.getMessage());
            System.err.println("HTTP Status:    " + ase.getStatusCode());
            System.err.println("AWS Error Code: " + ase.getErrorCode());
            System.err.println("Error Type:     " + ase.getErrorType());
            System.err.println("Request ID:     " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.err.println("Internal error occurred communicating with DynamoDB");
            System.out.println("Error Message:  " + ace.getMessage());
        }
        return null;
    }
}
