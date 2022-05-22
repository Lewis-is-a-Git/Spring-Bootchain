package dev.lewisbh.Bootchain.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import dev.lewisbh.Bootchain.Blockchain.Blockchain;
import dev.lewisbh.Bootchain.User.User;

public class BlockchainTest {

	String previousBlockHash = "af5e1eb4df10b3846e783ed45a274572792f63b26eb7480896acac96137b0bb6";

	@Test
	public void testCreateBlock() {
		Blockchain bitcoin = new Blockchain();
		bitcoin.createNewBlock(new String());

		assertEquals(Integer.valueOf(1), bitcoin.getLastBlock().getIndex());
	}

	@Test
	public void testCreateTransaction() {
		Blockchain bitcoin = new Blockchain();
		BigDecimal amount = new BigDecimal(30.0000001);
		bitcoin.createNewBlock(previousBlockHash);
		User sender = new User(1, "Lewis", "password");
		User recipient = new User(2, "Rocky", "password");
		bitcoin.createNewTransaction(amount, sender, recipient);

		assertEquals(1, bitcoin.getPendingTransactions().size());
	}

	@Test
	public void testProofOfWork() {
		Blockchain bitcoin = new Blockchain();
		bitcoin.createNewBlock(previousBlockHash);
		Integer nonce = bitcoin.proofOfWork();

		System.out.println(nonce);

		assertTrue(nonce > 0);
	}

}
