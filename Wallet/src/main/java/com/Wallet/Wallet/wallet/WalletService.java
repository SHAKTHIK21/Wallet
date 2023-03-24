package com.Wallet.Wallet.wallet;
import java.util.List;

public interface WalletService {
    List<WalletDTO> getAllWallets();
    WalletDTO getWalletById(Long id)throws WalletException;
    WalletDTO createWallet(WalletDTO walletDTO)throws WalletException;
    WalletDTO updateWallet(Long id, WalletDTO walletDTO)throws WalletException;

    void deleteWallet(Long id);
}
