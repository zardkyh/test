package com.jayuron.restfulmssql.entity;

import com.jayuron.restfulmssql.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Statement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    seq;        // 전표 고유번호

    @Column( length = 10)
    private String  isu_date;   // 전표 생성 날짜 20220512
    private Long    isu_seq;    // 전표 번호

    @Column( length = 100 )
    private String  isu_doc;    // 품의내역

    @Column( length = 1 )
    private String  doc_type;   // 유형       1~8

    @Column( length = 10 )
    private String  fill_date;  // 기표 날짜    20220512

    private Long    fill_seq;   // 기표번호

    @Column( length = 16 )
    private String  admin_id;   // 승인자 ID

}
