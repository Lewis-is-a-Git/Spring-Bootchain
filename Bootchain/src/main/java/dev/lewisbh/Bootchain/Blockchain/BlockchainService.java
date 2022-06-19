package dev.lewisbh.Bootchain.Blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class BlockchainService {

	private final BlockchainRepository blockchainRepository;

	public BlockchainService(BlockchainRepository blockchainRepository) {
		super();
		this.blockchainRepository = blockchainRepository;
	}

	public List<Blockchain> getBlockchain() {
		return blockchainRepository.findAll();
	}

	public void addNewBlock(Block block) {
		Optional<List<Block>> Optblocks = blockchainRepository.findChain(1L);
		List<Block> blocks = new ArrayList<>();
		if (Optblocks.isPresent()) {
			blocks = Optblocks.get();
		}

		blocks.add(block);

		blockchainRepository.updateChain(1L);
	}

	public void addNewTransaction(Transaction transaction) {
		Optional<Blockchain> Optblockchain = blockchainRepository.findBlockchain(1L);
		Blockchain blockchain = new Blockchain();
		if (Optblockchain.isPresent()) {
			blockchain = Optblockchain.get();
		}

		blockchain.addNewTransaction(transaction);

		blockchainRepository.updateTransactions(1L);
	}

	public List<Transaction> getPendingTransactions() {
		Optional<List<Transaction>> findTransactions = blockchainRepository.findTransactions(1L);
		if (findTransactions.isPresent()) {
			return findTransactions.get();
		} else {
			return new ArrayList<>();
		}
	}
}
