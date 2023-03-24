package com.Wallet.Wallet.wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
public class CollectionWalletServiceImpl implements WalletService{

    @Autowired
    private CollectionWalletServiceImpl WalletRepository;

    @Override
    public WalletDTO RegisterWallet(WalletDTO newWallet) {
        return WalletRepository.addWallet(newWallet);
    }

    @Override
    public WalletDTO getWalletById(Long Walletid)throws WalletException {
        WallletDTO foundWallet = WalletRepository.getEmployee(employeeId);
        if(foundWallet == null)
            throw new WalletException("Wallet Id does not exists.");

        return foundWallet;
    }

    @Override
    public WalletDTO updateWallet(WalletDTO Wallet) {
        return WalletRepository.updateWallet(Wallet);
    }

    @Override
    public WalletDTO deleteWalletbyId(Long Walletid)throws WalletException {
        WalletDTO foundEmployee = WalletRepository.getWalletById(Walletid);
        if(foundWallet==null)
            throw new WalletException("Wallet could't be deleted, Id not found:"+Walletid);
        return WalletRepository.deleteWallet(Walletid);
    }

    @Override
    public List<WalletDTO> getAllWallet() {
        return null;
    }
}
