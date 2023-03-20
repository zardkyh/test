package com.jayu.testmssql.entity;

import com.jayu.testmssql.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table( name="users" )
public class User extends BaseEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long    seq;

    @Column( length = 36 )
    private String  name;

}
