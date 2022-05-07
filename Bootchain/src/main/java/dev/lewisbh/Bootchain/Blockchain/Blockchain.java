package dev.lewisbh.Bootchain.Blockchain;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.common.hash.MurmurHash3.Hash128;
import org.joda.time.DateTime;

import dev.lewisbh.Bootchain.User.User;

public class Blockchain {

	private List<Block> chain;
	private List<Transaction> pendingTransactions;

	public Blockchain() {
		chain = new ArrayList<>();
	}

	public Block createNewBlock(Integer nonce, Hash128 previousHash, Hash128 currentHash) {
		Integer index = this.chain.size() + 1;
		DateTime now = DateTime.now();
		Block block = new Block(index, now, this.pendingTransactions, nonce, currentHash, previousHash);

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
		try {
			return Hash.hash(block, nonce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Integer proofOfWork(Hash128 previousHash) {
		// hash block until first four characters are 0 -> "0000..."
		Integer nonce = 0;
		while (!hashBlock(getLastBlock(), nonce).substring(0, 4).equals("0000")) {
			nonce++;
		}
		return nonce;
	}

}
