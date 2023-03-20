package jayuroun.core.model.response.dto;

import jayuroun.core.code.JoinCode;
import jayuroun.core.code.MFCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jayuroun.core.entity.User;

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
 * UserDto 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.core.model.response.dto.UserDto
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@Builder
@Data
@AllArgsConstructor
public class UserDto {

    private long id;

    private JoinCode joinType;

    private String uid;

    private String name;

    private String email;

    private String phone;

    private String birthday;

    private MFCode sex;

    private String position;

    private String employee_number;

    private long group_id;

    private String group_name;

    private String photo_url;

    private String address_line1;

    private String address_line2;

    private String state;

    private int privacy_term;

    private long point;

    public UserDto(User item) {
        this.id = item.getId();
        this.joinType = item.getJoinType();
        this.uid = item.getUid();
        this.name = item.getName();
        this.email = item.getEmail();
        this.phone = item.getPhone();
        this.birthday = item.getBirthday();
        this.sex = item.getSex();
        this.address_line1 = item.getAddress_line1();
        this.address_line2 = item.getAddress_line2();
        this.state = item.getState().getValue();
    }

}
