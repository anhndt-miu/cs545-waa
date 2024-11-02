package dev.anhndt.lab4.logger.impl;

import dev.anhndt.lab4.entity.Logger;
import dev.anhndt.lab4.logger.LoggerService;
import dev.anhndt.lab4.repository.LoggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoggerServiceImpl implements LoggerService {

    private final LoggerRepository loggerRepository;

    @Override
    public void save(Logger log) {
        loggerRepository.save(log);
    }
}
