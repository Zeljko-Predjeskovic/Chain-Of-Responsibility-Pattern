package request.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import request.domain.model.Request;
import request.domain.model.RequestTypes;

@SpringBootTest
public class TestChainServices {



    @Test
    public void TestRequestChain(){
        RequestChain carpenterService = new CarpenterService();
        RequestChain electricianService = new ElectricianService();
        RequestChain rooferService = new RooferService();

        carpenterService.nextRequestChain(electricianService);
        electricianService.nextRequestChain(rooferService);
        rooferService.nextRequestChain(carpenterService);

        Request request = new Request("repair roof",
                RequestTypes.ROOFER,false);

        carpenterService.doAndCloseRequest(request);
        electricianService.doAndCloseRequest(request);
        rooferService.doAndCloseRequest(request);
    }
}
