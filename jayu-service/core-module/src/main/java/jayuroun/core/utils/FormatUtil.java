package jayuroun.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

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
 * FormatUtil 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.core.utils.FormatUtil
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

public class FormatUtil {

    /**
     * 휴대폰 번호 형식 변환 (-)
     * @param 전화번호
     * @return - 변환 된 번호
     */
    public static String phone(String src) {
        if (src == null) {
            return "";
        }
        if (src.length() == 8) {
            return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
        } else if (src.length() == 12) {
            return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
        }
        return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    }

    /**
     * 생년월일 yyyyMMdd -> yyyy-MM-dd
     * @param yyyyMMdd
     * @return - yyyy-MM-dd
     */
    public static String birthday(String src) {

        if (src.length() == 8) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date birth = dateFormat.parse(src);
                String processDate = new SimpleDateFormat("yyyy-MM-dd").format(birth);
                return processDate;
            } catch ( Exception e ) {
            }
        }
        return src;
    }
}
