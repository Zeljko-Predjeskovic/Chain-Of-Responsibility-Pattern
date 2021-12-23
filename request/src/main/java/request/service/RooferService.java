package request.service;

import request.domain.model.Request;
import request.domain.model.RequestTypes;

public class RooferService implements RequestChain{
    private RequestChain nextRequestChain;

    public void nextRequestChain(RequestChain requestChain) {
        this.nextRequestChain = requestChain;
    }

    public void doAndCloseRequest(Request request) {
        if(request.getRequestType()== RequestTypes.ROOFER){
            /*do the work*/
            System.out.println("Roofer building roofs");
            request.setRequestDone(true);
        }
        else {
            nextRequestChain.doAndCloseRequest(request);
        }
    }
}
