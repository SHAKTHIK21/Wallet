package com.Wallet.Wallet.wallet;

public interface CollectWalletRepository {
    WalletDTO addWallet(WalletDTO Wallet);
    WalletDTO getWallet(Integer id);
    WalletDTO updateWallet(WalletDTO WalletDTO);
    WalletDTO deleteWallet(Integer id);
}