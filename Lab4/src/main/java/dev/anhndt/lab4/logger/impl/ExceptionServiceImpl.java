package dev.anhndt.lab4.logger.impl;

import dev.anhndt.lab4.entity.Exception;
import dev.anhndt.lab4.logger.ExceptionService;
import dev.anhndt.lab4.repository.ExceptionRepository;
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
