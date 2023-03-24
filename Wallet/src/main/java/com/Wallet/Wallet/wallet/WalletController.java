package com.Wallet.Wallet.wallet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.Wallet.Wallet.wallet.WalletDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/wallets")
@CrossOrigin(value = "http://localhost:4200/")

public class WalletController {
    private final WalletService WalletService;

    public WalletController(WalletService WalletService) {
        this.WalletService = WalletService;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/")
    // @GetMapping("/")
    public String greet(){
        return "Welcome to Wallet application !";
    }

    @GetMapping
    public List<WalletDTO> getAllWallets() {
        return WalletService.getAllWallets();
    }

    @GetMapping("/{id}")
    public WalletDTO getWalletById(@PathVariable Long id) {
        return WalletService.getWalletById(id);
    }

    @PostMapping
    public WalletDTO createWallet(@Valid @RequestBody WalletDTO walletDTO) {
        return WalletService.createWallet(walletDTO);
    }

    @PutMapping("/{id}")
    public WalletDTO updateWallet(@PathVariable Long id, @Valid @RequestBody WalletDTO walletDTO) {
        return WalletService.updateWallet(id, walletDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteWallet(@PathVariable Long id) {
        WalletService.deleteWallet(id);
    }



}

