package jayuroun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

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
 * EurekaApplication 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.eureka.EurekaApplication
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApplication {

//    @Value("${spring.servlet.multipart.location}")
//    private String uploadPath = "";

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }

//    @Bean
//    public void deleteTemp() {
//        // temp 파일 제거
//        String path = uploadPath + "/temp";
//        File deleteFolder = new File(path);
//
//        if(deleteFolder.exists()) {
//            File[] deleteFolderList = deleteFolder.listFiles();
//            for (int j = 0; j < deleteFolderList.length; j++) {
//                deleteFolderList[j].delete();
//            }
//        }
//    }

}
