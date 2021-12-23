package request.service;

import request.domain.model.Request;
import request.domain.model.RequestTypes;

public class CarpenterService implements RequestChain{
    private RequestChain nextRequestChain;

    public void nextRequestChain(RequestChain requestChain) {
        this.nextRequestChain = requestChain;
    }

    public void doAndCloseRequest(Request request) {
        if(request.getRequestType() == RequestTypes.CARPENTER ){
            /*do the work*/
            System.out.println("Carpenter building tables");
            request.setRequestDone(true);
        }
        else {
            nextRequestChain.doAndCloseRequest(request);
        }
    }
}
