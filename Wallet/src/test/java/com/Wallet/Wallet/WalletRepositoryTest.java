package com.Wallet.Wallet;
import  com.Wallet.Wallet.wallet.WalletDTO;
import  com.Wallet.Wallet.wallet.CollectWalletRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class WalletRepositoryTest {
    @Autowired
    private CollectionWalletRepository WalletRepository;

    //    EmployeeDto addEmployee(EmployeeDto employee);
//    EmployeeDto getEmployee(Integer id);
//    EmployeeDto updateEmployee(EmployeeDto employeeDto);
//    EmployeeDto deleteEmployee(Integer employeeId);
    @BeforeEach
    public void init(){
        WalletRepository.addWallet(new WalletDTO(1,"test",25000.0));
    }
    @Test
    public void deleteWalletTest(){
        WalletDTO deletedEmployee= WalletRepository.deleteWallet(1);
        assertEquals("test",deletedWallet.getName());
    }
}
