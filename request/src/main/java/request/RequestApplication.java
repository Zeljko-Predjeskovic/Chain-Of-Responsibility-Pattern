package request;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import request.domain.model.Request;
import request.domain.model.RequestTypes;
import request.service.CarpenterService;
import request.service.ElectricianService;
import request.service.RequestChain;
import request.service.RooferService;

@SpringBootApplication
public class RequestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RequestApplication.class, args);

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
