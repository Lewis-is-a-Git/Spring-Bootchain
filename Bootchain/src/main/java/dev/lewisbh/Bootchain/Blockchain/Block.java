package dev.lewisbh.Bootchain.Blockchain;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import org.elasticsearch.common.hash.MurmurHash3.Hash128;
import org.joda.time.DateTime;

public class Block implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer index;
	DateTime timestamp;
	List<Transaction> transactions;
	Integer nonce;
	Hash128 hash;
	Hash128 previousHash;

	public Block(Integer index, DateTime now, List<Transaction> transactions, Integer nonce, Hash128 currentHash,
			Hash128 previousBlockHash) {
		this.index = index;
		this.timestamp = now;
		this.transactions = transactions;
		this.nonce = nonce;
		this.hash = currentHash;
		this.previousHash = previousBlockHash;
	}

	public void setNonce(Integer nonce) {
		this.nonce = nonce;
	}

	public byte[] toByteArray() {
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {
			oos.writeObject(this);
			oos.flush();
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
