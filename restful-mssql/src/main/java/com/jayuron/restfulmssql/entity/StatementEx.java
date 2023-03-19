package com.jayuron.restfulmssql.entity;

import com.jayuron.restfulmssql.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatementEx extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long    seq;

    @Column( length = 1 )
    private String  drcr_flag;
    @Column( length = 8 )
    private String  acct_code;

    @Column( length = 10 )
    private String  trade_code;
    @Column( length = 60 )
    private String  trade_name;
    @Column( length = 20 )
    private String  trade_sn;
    private Integer money;

    @Column( length = 80 )
    private String  rmk_name;

    @Column( length = 8 )
    private String  attr_code;
}
