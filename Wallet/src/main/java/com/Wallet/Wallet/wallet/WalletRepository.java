package com.Wallet.Wallet.wallet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public interface WalletRepository extends JpaRepository<WalletDTO,Long> {
    Map<Integer,WalletDTO> WalletDTOMap = new HashMap<>();

    @Override
    public WalletDTO addWallet(WalletDTO Wallet) {
        WalletDTOMap.put(Math.toIntExact(Wallet.getId()),Wallet);
        return Wallet;
    }

    @Override
    public WalletDTO getWallet(Integer id) {
        return WalletDTOMap.get(id);
    }

    @Override
    public WalletDTO updateWallet(WalletDTO employeeDto) {
        return WalletDTOMap.replace(WalletDTO.getid(),walletDTO);
    }

    @Override
    public WalletDTO deleteWallet(Integer id) {
        return WalletDTOMap.remove(WalletId);
    }
}

