package com.system.cafe.domain.cafe;

import com.system.cafe.domain.category.Category;

import javax.persistence.*;

@Entity
public class CafeCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cafe_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_uuid")
    private Cafe cafe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
