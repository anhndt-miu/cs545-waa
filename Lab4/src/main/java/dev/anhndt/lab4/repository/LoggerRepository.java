package dev.anhndt.lab4.repository;

import dev.anhndt.lab4.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
