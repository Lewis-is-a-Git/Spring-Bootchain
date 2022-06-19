package dev.lewisbh.Bootchain.Blockchain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity(name = "BlockChains")
@Table(name = "blockchains")
public class Blockchain {

	@Id
	@SequenceGenerator(name = "blockchain_sequence", sequenceName = "blockchain_sequence", allocationSize = 1)
	@GeneratedValue(strategy = SEQUENCE, generator = "blockchain_sequence")
	@Column(name = "id")
	private long id;

	@Column(name = "blocks", columnDefinition = "TEXT")
	private List<Block> chain;

	@Column(name = "pending_transactions", columnDefinition = "TEXT")
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

	public Integer addNewTransaction(Transaction transaction) {
		pendingTransactions.add(transaction);
		return getLastBlock().index + 1;
	}

	public String hashBlock(Block block, Integer nonce) {
		return Hash.hash(block, nonce);
	}

	public Integer mine() {
		// hash block until first characters are 0 -> "000..."
		Integer nonce = 0;
		while (!hashBlock(getLastBlock(), nonce).startsWith("000")) {
			nonce++;
		}
		return nonce;
	}

}
