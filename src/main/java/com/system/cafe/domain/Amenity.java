package com.system.cafe.domain;

import com.system.cafe.domain.cafe.Cafe;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "amenity")
public class Amenity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "amenity_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_uuid")
    private Cafe cafe;
    private String name;

}
