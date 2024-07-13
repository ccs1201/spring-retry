package br.com.ccs.springretry.services;

import br.com.ccs.springretry.exceptions.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RetryServiceComRecover {

    private int tentativas = 0;
    private int customException = 0;
    private int novaCustomException = 0;
    private int outraCustomException = 0;

    @Retryable(
            retryFor = CustomException.class,
            maxAttempts = 3,
            backoff = @Backoff(delay = 10)
    )
    public <T extends CustomException> void retry(T t) {
        log.info("Tentativa {}", ++tentativas);
        throw t;
    }

    @Recover
    public void recover(CustomException e) {
        log.info("Recover, zerando contadores.");
        customException = 0;
    }

}
