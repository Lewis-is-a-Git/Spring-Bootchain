package dev.lewisbh.Bootchain.Blockchain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/blockchain")
public class BlockchainController {

	private final BlockchainService blockchainService;

	@Autowired
	public BlockchainController(BlockchainService blockchainService) {
		this.blockchainService = blockchainService;
	}

	@GetMapping
	public List<Transaction> getPendingTransactions() {
		return blockchainService.getPendingTransactions();
	}

	@PutMapping(path = "{blockchainId}")
	public void addNewTransaction(@PathVariable("blockchainId") Long blockchainId,
			@RequestBody Transaction transaction) {
		blockchainService.addNewTransaction(transaction);
	}

	@PutMapping(path = "{blockchainId}")
	public void addNewBlock(@PathVariable("blockchainId") Long blockchainId, @RequestBody Block block) {
		blockchainService.addNewBlock(block);
	}

	@PostMapping
	public Integer mine(Blockchain blockchain) {
		return blockchain.mine();
	}

}
