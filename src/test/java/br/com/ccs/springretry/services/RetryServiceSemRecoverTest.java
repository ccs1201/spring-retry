package br.com.ccs.springretry.services;

import br.com.ccs.springretry.exceptions.CustomException;
import br.com.ccs.springretry.exceptions.NovaCustomException;
import br.com.ccs.springretry.exceptions.OutraCustomException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class RetryServiceSemRecoverTest {

    @Autowired
    private RetryServiceSemRecover retryServiceSemRecover;

    @Test
    void testRetryCustomException() {
        assertThrows(CustomException.class, () -> retryServiceSemRecover.retry(new CustomException()));
    }

    @Test
    void testRetryNovaCustomException() {
        assertThrows(NovaCustomException.class, () -> retryServiceSemRecover.retry(new NovaCustomException()));
    }

    @Test
    void testRetryOutraCustomException() {
        assertThrows(OutraCustomException.class, () -> retryServiceSemRecover.retry(new OutraCustomException()));
    }

}