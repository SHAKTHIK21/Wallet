package com.Wallet.Wallet;
import com.Wallet.Wallet.wallet.WalletDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WalletControllerTest {@Value(value="${local.server.port}")
private int port;

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void init(){
        this.restTemplate.postForObject("http://localhost:" + port + "/v1/Wallet",new WalletDTO(1,"test",25000.0),WalletDTO.class);
    }
    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/v1/",
                String.class)).contains("Welcome to my Wallet application !");
    }

    @Test
    public void getWalletByIdTest() throws Exception {
        WalletDTO foundWallet =this.restTemplate.getForObject("http://localhost:" + port + "/v1/Wallet/1", WalletDTO.class);
        assertEquals("test",foundWallet.getName());
    }

    @Test
    public void getWalletByIdExceptionTest() throws Exception {
        String WalletExceptionMessage =this.restTemplate.getForObject("http://localhost:" + port + "/v1/wallet/2", String.class);
        assertEquals("Wallet Id does not exists.",WalletExceptionMessage);
    }
}
