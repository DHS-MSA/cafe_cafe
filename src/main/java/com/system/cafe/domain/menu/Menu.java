package com.system.cafe.domain.menu;

import com.system.cafe.domain.cafe.Cafe;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafe_uuid")
    private Cafe cafe;

    private String category;
    private String name;

    private int price;

    private String signatureMenuYn;

    private int sortNo;
}

