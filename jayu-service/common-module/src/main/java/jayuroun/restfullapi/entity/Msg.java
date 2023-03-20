package jayuroun.restfullapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table( name="msg" )
public class Msg {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long seq;

    @Column( length = 10, nullable = false )
    private String  name;
    @Column( length = 50, nullable = false )
    private String  msg;
    @Column( length = 50, nullable = true )
    private String  echo;

    @ColumnDefault( "GETDATE()" )
    private Date    cdate;

    @Column( nullable = true )
    private Date    mdate;

}
