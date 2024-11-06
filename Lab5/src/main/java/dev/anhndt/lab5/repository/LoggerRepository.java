package dev.anhndt.lab5.repository;

import dev.anhndt.lab5.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<Logger, Long> {
}
