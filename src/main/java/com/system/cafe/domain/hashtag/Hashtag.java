package com.system.cafe.domain.hashtag;

import com.system.cafe.domain.cafe.Cafe;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @GeneratedValue
    @Column(name = "hashtag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    private Cafe cafe;

    private String name;
}
