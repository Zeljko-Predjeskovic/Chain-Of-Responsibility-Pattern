package request.service;

import request.domain.model.Request;

public interface RequestChain {

    void nextRequestChain(RequestChain requestChain);

    void doAndCloseRequest(Request request);

}
