package dev.anhndt.lab5.logger.impl;

import dev.anhndt.lab5.entity.Exception;
import dev.anhndt.lab5.logger.ExceptionService;
import dev.anhndt.lab5.repository.ExceptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExceptionServiceImpl implements ExceptionService {
    private final ExceptionRepository exceptionRepository;

    @Override
    public void logException(Exception e) {
        this.exceptionRepository.save(e);
    }
}
