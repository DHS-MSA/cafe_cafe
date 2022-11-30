package com.system.cafe.domain.info;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InfoRepository extends JpaRepository<Info, Long> {

    @Query("select i,l from Info i left join Location l")
    Page<Object[]> getCafeInfoList(Pageable pageable);

}
