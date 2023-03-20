package jayuroun.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jayuroun.core.code.JoinCode;
import jayuroun.core.code.MFCode;
import jayuroun.core.code.YNCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jayuroun.core.converter.JoinCodeConverter;
import jayuroun.core.converter.MFCodeConverter;
import jayuroun.core.converter.YNCodeConverter;
import jayuroun.core.entity.base.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
 * Config 의 설명을 작성해주세요.
 *
 * @author :
 * @packageName : jayuroun.core.entity.User
 * @fileName :
 * @date :
 * @description :
 * =======================================================================
 * DATE                   AUTHOR                NOTE
 * -----------------------------------------------------------------------
 *
 */

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",
    uniqueConstraints = {
            @UniqueConstraint(
                    columnNames={"uid"}
            )
    }
)
public class User extends BaseEntity implements UserDetails {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Convert(converter = JoinCodeConverter.class)
    @Column(nullable = false, length = 12)
    private JoinCode joinType;

    // 회원아이디
    // 일반 : 이메일
    // 카카오 : kakao_발급번호
    // 네이버 : naver_발급번호
    // 페이스북 : facebook_발급번호
    // 애플 : apple_발급번호
    // 구글 : google_발급번호
    @Column(nullable = false, unique = true, length = 120)
    private String uid;

    // 암호 :
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false, length = 255)
    private String password;

    // 회원 이름
    @Column(length = 32)
    private String name;

    // 회원 닉네임
    @Column(length = 64, nullable = true)
    private String nickname;

    // 회원 이메일
    @Column(length = 255)
    private String email;

    // 회원 휴대폰
    @Column(length = 32)
    private String phone;

    // 회원 생년월일 yyyy-MM-dd
    @Column(length = 10)
    private String birthday;

    // 성별 (남자 M, 여자 F)
    @Convert(converter = MFCodeConverter.class)
    @Column(length = 1)
    private MFCode sex;

    // 이메일 인증 여부
    @Column(nullable = false)
    private int emailCert;

    // 회원 이미지 (사용안함)
    @Column(length = 255)
    private String photo;

    // 주소 1
    @Column(length = 255)
    private String address_line1;

    // 주소 2
    @Column(length = 255)
    private String address_line2;

    // 면읍군시
    @Column(length = 128)
    private String city;

    // 시도
    @Column(length = 256)
    private String street;

    // 우편번호
    @Column(length = 256)
    private String zipcode;

    // 국가
    @Column(length = 32)
    private String country;

    // 이용약관 동의 여부
    @Column(nullable = false)
    private int isTermsserviceAgree;

    // 개인정보
    @Column(nullable = false)
    private int isPrivacyAgree;

    // 마케팅 동의 여부
    @Column(nullable = false)
    private int isMarketingAgree;

    @Convert(converter = YNCodeConverter.class)
    @Column(nullable = false, length = 1)
    private YNCode state;


    // 삭제 여부
    @Convert(converter = YNCodeConverter.class)
    @Column(nullable = false, length = 1)
    private YNCode isBind;

    // JWT
    @Column(length = 100)
    private String provider;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public String getUsername() {
        return this.uid;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void updatePassword( String password ) {
        this.password = password;
    }


    public void updateBind( YNCode code ) {
        this.isBind = code;
    }

    public void updatePhoto( String url ) {
        this.photo = url;
    }

    public void updateDelete( String uid, YNCode code ) {
        this.uid = uid;
        this.isBind = code;
    }

    public void updateState( YNCode state ) {
        this.state = state;
    }
}
