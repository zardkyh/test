package jayuroun.restfullapi.entity;

import jayuroun.core.entity.base.BaseEntity;
import lombok.*;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


@Builder
@Entity
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

}
