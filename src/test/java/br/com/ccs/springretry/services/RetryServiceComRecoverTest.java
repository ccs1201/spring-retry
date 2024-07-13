package br.com.ccs.springretry.services;

import br.com.ccs.springretry.exceptions.CustomException;
import br.com.ccs.springretry.exceptions.NovaCustomException;
import br.com.ccs.springretry.exceptions.OutraCustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RetryServiceTest {

    @Autowired
    private RetryService retryService;

    @Test
    void testRetryCustomException() {
        Assertions.assertThrows(CustomException.class, () -> retryService.retry(new CustomException()));
    }

    @Test
    void testRetryNovaCustomException(){
        Assertions.assertThrows(CustomException.class, () -> retryService.retry(new NovaCustomException()));
    }

    @Test
    void testRetryOutraCustomException(){
        Assertions.assertThrows(CustomException.class, () -> retryService.retry(new OutraCustomException()));
    }
}