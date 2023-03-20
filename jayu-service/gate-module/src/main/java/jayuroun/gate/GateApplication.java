package jayuroun.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * -------------------------------------------------------------------------------------
 * ::::::'OO::::'OOO::::'OO:::'OO:'OO::::'OO:'OOOOOOOO:::'OOOOOOO::'OO::::'OO:'OO....OO:
 * :::::: OO:::'OO OO:::. OO:'OO:: OO::::.OO: OO.....OO:'OO.....OO: OO:::: OO: OOO...OO:
 * :::::: OO::'OO:..OO:::. OOOO::: OO::::.OO: OO::::.OO: OO::::.OO: OO:::: OO: OOOO..OO:
 * :::::: OO:'OO:::..OO:::. OO:::: OO::::.OO: OOOOOOOO:: OO::::.OO: OO:::: OO: OO.OO.OO:
 * OO:::: OO: OOOOOOOOO:::: OO:::: OO::::.OO: OO.. OO::: OO::::.OO: OO:::: OO: OO..OOOO:
 * :OO::::OO: OO.....OO:::: OO:::: OO::::.OO: OO::. OO:: OO::::.OO: OO:::: OO: OO:..OOO:
 * ::OOOOOO:: OO:::..OO:::: OO::::. OOOOOOO:: OO:::. OO:. OOOOOOO::. OOOOOOO:: OO::..OO:
 * :......:::..:::::..:::::..::::::.......:::..:::::..:::.......::::.......:::..::::..::
 * <p>
 * GateApplication 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.gate.GateApplication
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@EnableEurekaClient
@SpringBootApplication
public class GateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateApplication.class, args);
    }


//    @Bean
//    @Primary
//    public RoutePredicateHandlerMapping passCorsRoutePredicateHandlerMapping(
//            FilteringWebHandler webHandler, RouteLocator routeLocator,
//            GlobalCorsProperties globalCorsProperties, Environment environment) {
//        return new PassCorsRoutePredicateHandlerMapping(webHandler, routeLocator,
//                globalCorsProperties, environment);
//    }
}
