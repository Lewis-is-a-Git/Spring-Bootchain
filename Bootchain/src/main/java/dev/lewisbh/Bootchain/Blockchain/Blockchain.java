package dev.lewisbh.Bootchain.Blockchain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import dev.lewisbh.Bootchain.User.User;

public class Blockchain {

	private List<Block> chain;
	private List<Transaction> pendingTransactions;

	public Blockchain() {
		chain = new ArrayList<>();
		pendingTransactions = new ArrayList<>();
	}

	public List<Transaction> getPendingTransactions() {
		return pendingTransactions;
	}

	public Block createNewBlock(String previousHash) {
		Integer index = this.chain.size() + 1;
		DateTime now = DateTime.now();
		Block block = new Block(index, now, this.pendingTransactions, previousHash);

		pendingTransactions = new ArrayList<Transaction>();
		this.chain.add(block);
		return block;
	}

	public Block getLastBlock() {
		return this.chain.get(chain.size() - 1);
	}

	public Integer createNewTransaction(BigDecimal amount, User sender, User recipient) {
		pendingTransactions.add(new Transaction(amount, sender, recipient));

		return getLastBlock().index + 1;
	}

	public String hashBlock(Block block, Integer nonce) {
		return Hash.hash(block, nonce);
	}

	public Integer proofOfWork() {
		// hash block until first characters are 0 -> "000..."
		Integer nonce = 0;
		while (!hashBlock(getLastBlock(), nonce).startsWith("000")) {
			nonce++;
		}
		return nonce;
	}

}
