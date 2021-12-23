package request.service;

import request.domain.model.Request;
import request.domain.model.RequestTypes;

public class ElectricianService implements RequestChain{

    private RequestChain nextRequestChain;

    public void nextRequestChain(RequestChain requestChain) {
        this.nextRequestChain = requestChain;
    }

    public void doAndCloseRequest(Request request) {
        if(request.getRequestType()== RequestTypes.ELECTRICIAN){
            /*do the work*/
            System.out.println("Electrician doing electrician stuff");
            request.setRequestDone(true);
        }
        else {
            nextRequestChain.doAndCloseRequest(request);
        }
    }
}
