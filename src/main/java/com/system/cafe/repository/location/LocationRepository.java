package com.system.cafe.repository.location;

import com.system.cafe.domain.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository  extends JpaRepository<Location, Long> {
}
