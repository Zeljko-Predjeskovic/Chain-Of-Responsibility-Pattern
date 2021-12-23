package request.domain.model;

import request.service.RequestChain;


public class Request {
    private String requestDescription;
    private RequestTypes requestType;
    private boolean requestDone;

    public Request(String requestDescription, RequestTypes requestType, boolean requestDone) {
        this.requestDescription = requestDescription;
        this.requestType = requestType;
        this.requestDone = requestDone;
    }

    public String getRequestDescription() {
        return requestDescription;
    }

    public RequestTypes getRequestType() {
        return requestType;
    }

    public boolean isRequestDone() {
        return requestDone;
    }

    public void setRequestDone(boolean requestDone) {
        this.requestDone = requestDone;
    }
}
