# Chain of Responsibility Pattern

## Real life scenario

A Client requests an electrician to repair his roof. The electrician takes the request but he doe not know how to build a roof. So the electrician sends the request to the roofer. (We can already see the disadvantage. If he sends it to the carpenter he has to send it so the roofer)

![actor](Actors.png)

## Java inplementation example

![class](Classdiagramm.png)

## Test

    public static void main(String[] args) {
        SpringApplication.run(RequestApplication.class, args);

        RequestChain carpenterService = new CarpenterService();
        RequestChain electricianService = new ElectricianService();
        RequestChain rooferService = new RooferService();

        carpenterService.nextRequestChain(electricianService);
        electricianService.nextRequestChain(rooferService);
        rooferService.nextRequestChain(carpenterService);

        Request request = new Request("repair roof",RequestTypes.ROOFER,false);

        carpenterService.doAndCloseRequest(request);
        electricianService.doAndCloseRequest(request);
        rooferService.doAndCloseRequest(request);
    }

output:

Roofer building roofs

Roofer building roofs

Roofer building roofs