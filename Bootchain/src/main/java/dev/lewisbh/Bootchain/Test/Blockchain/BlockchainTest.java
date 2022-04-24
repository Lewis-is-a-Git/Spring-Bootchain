package dev.lewisbh.Bootchain.Test.Blockchain;

import java.math.BigDecimal;

import org.elasticsearch.common.hash.MurmurHash3.Hash128;

import dev.lewisbh.Bootchain.Blockchain.Blockchain;
import dev.lewisbh.Bootchain.User.User;

public class BlockchainTest {

	public void testCreateBlock() {
		Blockchain bitcoin = new Blockchain();
		bitcoin.createNewBlock(100, new Hash128(), new Hash128());
	}

	public void testCreateTransaction() {
		Blockchain bitcoin = new Blockchain();
		BigDecimal amount = new BigDecimal(30.0000001);
		bitcoin.createNewBlock(100, new Hash128(), new Hash128());
		User sender = new User(1, "Lewis", "password");
		User recipient = new User(2, "Rocky", "password");
		bitcoin.createNewTransaction(amount, sender, recipient);
	}

}
