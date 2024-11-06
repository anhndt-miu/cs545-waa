package dev.anhndt.lab5.repository;

import dev.anhndt.lab5.entity.Exception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepository extends JpaRepository<Exception, Long> {
}
