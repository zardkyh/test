package jayuroun.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

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
 * AuthApplication 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.auth.AuthApplication
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@SpringBootApplication
@EnableCaching
@EnableJpaAuditing
@EnableScheduling
@ComponentScan({"jayuroun.core"})
@ComponentScan({"jayuroun.auth"})
@EntityScan("jayuroun.core")
@EnableJpaRepositories({"jayuroun.core", "jayuroun.auth"})
public class AuthApplication {

//    @Value("${spring.servlet.multipart.location}")
//    private String uploadPath = "";

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
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
