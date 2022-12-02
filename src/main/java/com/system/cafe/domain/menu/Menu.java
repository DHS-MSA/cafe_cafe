package com.system.cafe.domain.menu;

import com.system.cafe.domain.info.Info;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String name;

    @Column
    private int price;

    @Column(length = 1)
    private String seasonYn;

    @Column
    private int ranking;

    @ManyToOne(fetch = FetchType.LAZY)
    private Info info;
    
}

