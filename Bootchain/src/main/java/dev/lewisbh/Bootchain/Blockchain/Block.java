package dev.lewisbh.Bootchain.Blockchain;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Instant;

public class Block implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer index; // index of block in blockchain
	DateTime timestamp; // time created
	List<Transaction> transactions; // list of transactions
	String previousHash; // hash of last block

	Integer nonce; // used for hashing
	String hash; // set after this block is hashed

	/**
	 * Full argument constructor
	 * 
	 * @param index             index of block in blockchain
	 * @param time              block creation time
	 * @param transactions      list of transactions
	 * @param previousBlockHash hash of previous block
	 */
	public Block(Integer index, DateTime time, List<Transaction> transactions, String previousBlockHash) {
		this.index = index;
		this.timestamp = time;
		this.transactions = transactions;
		this.previousHash = previousBlockHash;
		this.nonce = 0;
	}

	public void setNonce(Integer nonce) {
		this.nonce = nonce;
	}

	public void resetTimeStamp() {
		this.timestamp = new DateTime(new Instant(0));
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Integer getIndex() {
		return index;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public Integer getNonce() {
		return nonce;
	}

	public String getHash() {
		return hash;
	}

	public byte[] toByteArray() {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(this.toString());
			oos.flush();
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Convert block data to string
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(index.toString());
		sb.append(timestamp.toString());
		sb.append(transactions.toString());
		sb.append(previousHash.toString());
		sb.append(nonce.toString());
		return sb.toString();
	}
}
