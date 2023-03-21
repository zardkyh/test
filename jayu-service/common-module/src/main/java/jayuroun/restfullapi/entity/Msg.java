package jayuroun.restfullapi.entity;

import jayuroun.core.entity.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

////////////////////////////////////////////////////////////////////////////////////////////////////////
// 프로시저 선언 부
////////////////////////////////////////////////////////////////////////////////////////////////////////
@NamedStoredProcedureQuery(
        name = "spInitData",            // 소스코드와 바인딩 하여 사용할 프로시저 명
        procedureName = "INIT_DATA",    // 실제 데이터베이스에 구현 되어있는 프로시저 명
        resultClasses = Msg.class )     // 결과 값을 받을 Entity 클래스

// 프로시저가 파라메터를 요구하는 경우 Paramters 항목을 추가, 프로시저가 요구하는 수 만큼 추가해야 함. 누락되는 경우 프로시저 호출 시 오류 발생.
@NamedStoredProcedureQuery(
        name = "spGetAll",
        procedureName = "GETALL",
        parameters = {                  // 프로시저의 파라메터 설정
                @StoredProcedureParameter(mode=ParameterMode.OUT, name="RETCODE", type=Integer.class )
        },
        resultClasses = Msg.class )

@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table( name="msg" )
public class Msg extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long seq;

    @Column( length = 10, nullable = false )
    private String  name;
    @Column( length = 50, nullable = false )
    private String  msg;
    @Column( length = 50, nullable = true )
    private String  echo;

    // NamedStoredProcedureQuery 어노테이션 사용 시 반드시 아래와 같이 정의해야 한다
    public static final String sp_InitData = "spInitData";
    public static final String sp_GetAll = "spGetAll";

}
