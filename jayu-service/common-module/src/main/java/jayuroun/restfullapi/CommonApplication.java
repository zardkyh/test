package jayuroun.restfullapi;

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
 * CommonApplication 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.common.CommonApplication
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
@ComponentScan({"jayuroun.core", "jayuroun.restfullapi"})
// Database를 생성할 Entity를 지정된 패키지에 포함되어있지 않은 Entity의 경우는 테이블이 생성되지 않는다
@EntityScan("jayuroun")
//@EnableJpaRepositories({"jayuroun.core", "jayuroun.restfullapi"})
public class CommonApplication {

//    @Value("${spring.servlet.multipart.location}")
//    private String uploadPath = "";

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
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
