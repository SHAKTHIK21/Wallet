package com.Wallet.Wallet.wallet;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public List<WalletDTO> getAllWallets() {
        List<Wallet> wallets = walletRepository.findAll();
        return wallets.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public WalletDTO getWalletById(Long id) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletException("Wallet not found"));
        return toDTO(wallet);
    }

    @Override
    public WalletDTO createWallet(WalletDTO walletDTO) {
        Wallet wallet = toEntity(walletDTO);
        Wallet savedWallet = walletRepository.save(wallet);
        return toDTO(savedWallet);
    }

    @Override
    public WalletDTO updateWallet(Long id, WalletDTO walletDTO) {
        Wallet wallet = walletRepository.findById(id)
                .orElseThrow(() -> new WalletException("Wallet not found"));
        wallet.setName(walletDTO.getName());
        wallet.setBalance(walletDTO.getBalance());
        wallet.setPassword(walletDTO.getPassword());
        Wallet savedWallet = walletRepository.save(wallet);
        return toDTO(savedWallet);
    }

    @Override
    public void deleteWallet(Long id) {
        walletRepository.deleteById(id);
    }

    private WalletDTO toDTO(Wallet wallet) {
        WalletDTO walletDTO = new WalletDTO(123L,"shakthi",10000,"Sha123");
        walletDTO.setId(wallet.getId());
        walletDTO.setName(wallet.getName());
        walletDTO.setBalance(wallet.getBalance());
        walletDTO.setPassword(wallet.getPassword());
        return walletDTO;
    }

    private Wallet toEntity(WalletDTO walletDTO) {
        Wallet wallet = new Wallet();
        wallet.setName(walletDTO.getName());
        wallet.setBalance(walletDTO.getBalance());
        wallet.setPassword(walletDTO.getPassword());
        return wallet;
    }
}
