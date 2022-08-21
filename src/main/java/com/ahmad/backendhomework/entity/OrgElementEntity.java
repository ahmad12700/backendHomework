package com.ahmad.backendhomework.entity;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "tbl_organization")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class OrgElementEntity {
    @Id
    @SequenceGenerator(
            name = "organization_sequence",
            sequenceName = "organization_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "organization_sequence"
    )
    private Long id;
    @Column(name = "parent_id")
    private Long parentId;
    @Column(name = "sector")
    private String sector;
    @Column(name = "department")
    private String department;
    @Column(name = "section")
    private String section;

}
