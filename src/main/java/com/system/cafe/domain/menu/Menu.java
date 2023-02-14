package com.system.cafe.domain.menu;

import com.system.cafe.domain.cafe.Cafe;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MENU")
public class Menu {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CAFE_ID")
    private Cafe cafe;

    @Column(length = 50)
    private String name;

    private int price;

    private String signatureMenuYn;

    private int sortNo;
}

