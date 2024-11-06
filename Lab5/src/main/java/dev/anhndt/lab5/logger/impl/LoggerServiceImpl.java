package dev.anhndt.lab5.logger.impl;

import dev.anhndt.lab5.entity.Logger;
import dev.anhndt.lab5.logger.LoggerService;
import dev.anhndt.lab5.repository.LoggerRepository;
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
