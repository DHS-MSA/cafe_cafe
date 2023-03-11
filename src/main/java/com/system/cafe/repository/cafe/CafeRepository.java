package com.system.cafe.repository.cafe;

import com.system.cafe.domain.cafe.Cafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CafeRepository extends JpaRepository<Cafe, Long> {

    @Query("select i,l.address from Cafe i left join Location l")
    Page<Object[]> getCafeInfoList(Pageable pageable);

}
