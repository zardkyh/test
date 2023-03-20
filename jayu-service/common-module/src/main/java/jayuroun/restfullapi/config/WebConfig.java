package jayuroun.restfullapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.Arrays;
import java.util.List;

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
 * WebMvcConfigurer 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.common.config.WebMvcConfigurer
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@Configuration
class WebConfig implements WebMvcConfigurer {

    private final String uploadImagesPath;

    public WebConfig(@Value("${spring.servlet.multipart.location}") String uploadImagesPath) {
        this.uploadImagesPath = uploadImagesPath;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        List<String> imageFolders = Arrays.asList("/members");
        for(String imageFolder : imageFolders) {
            registry.addResourceHandler("/images" +imageFolder +"/**")
                    .addResourceLocations("file:///" + uploadImagesPath + imageFolder +"/")
                    .setCachePeriod(3600)
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver());
        }

        registry.addResourceHandler("/api-doc/**").addResourceLocations("classpath:/static/docs/");
    }

//    @Override
//    public void addCorsMappings(CorsRegistry cr) {
//        cr.addMapping("/**")
//                .allowedOrigins("http://127.0.0.1:4200")
//                .allowedOrigins("http://127.0.0.1:4400")
//                .allowedOrigins("http://127.0.0.1:8000")
//                .allowedMethods("*");
////                .allowedHeaders("X-AUTH-TOKEN","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials")
////                .exposedHeaders("X-AUTH-TOKEN","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials")
////                .allowCredentials(false).maxAge(3600);
//    }
//    @Override
//    public void addCorsMappings(CorsRegistry cr) {
//        cr.addMapping("/**")
//                .allowedOrigins("http://127.0.0.1:4200")
//                .allowedOrigins("http://13.209.19.100:4200")
//                .allowedMethods("*");
////                .allowedHeaders("X-AUTH-TOKEN","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials")
////                .exposedHeaders("X-AUTH-TOKEN","Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Credentials")
////                .allowCredentials(false).maxAge(3600);
//    }
}
