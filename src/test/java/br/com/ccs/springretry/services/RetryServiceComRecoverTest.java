package br.com.ccs.springretry.services;

import br.com.ccs.springretry.exceptions.CustomException;
import br.com.ccs.springretry.exceptions.NovaCustomException;
import br.com.ccs.springretry.exceptions.OutraCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetryServiceComRecoverTest {

    @Autowired
    private RetryServiceComRecover retryServiceComRecover;

    @Test
    void testRetryCustomException() {
        Assertions.assertDoesNotThrow(() -> retryServiceComRecover.retry(new CustomException()));
    }

    @Test
    void testRetryNovaCustomException() {
        Assertions.assertDoesNotThrow(() -> retryServiceComRecover.retry(new NovaCustomException()));
    }

    @Test
    void testRetryOutraCustomException() {
        Assertions.assertDoesNotThrow(() -> retryServiceComRecover.retry(new OutraCustomException()));
    }
}