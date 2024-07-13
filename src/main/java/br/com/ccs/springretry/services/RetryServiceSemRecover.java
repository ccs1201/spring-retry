package br.com.ccs.springretry.services;

import br.com.ccs.springretry.exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryServiceSemRecover {

    private int tentativas = 0;

    @Retryable(retryFor = CustomException.class, maxAttempts = 3, backoff = @Backoff(delay = 500))
    public <T extends CustomException> void retry(T t) {
        log.info("Tentativa {} para {}", ++tentativas, t.getClass().getSimpleName());
        throw t;
    }
}
