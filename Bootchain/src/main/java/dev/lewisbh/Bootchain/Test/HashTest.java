package dev.lewisbh.Bootchain.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;

import dev.lewisbh.Bootchain.Blockchain.Block;
import dev.lewisbh.Bootchain.Blockchain.Hash;
import dev.lewisbh.Bootchain.Blockchain.Transaction;

public class HashTest {

	@Test
	public void hashTest() {
		List<Transaction> transactions = new ArrayList<>();
		Block block = new Block(1, DateTime.now(), transactions, new String());
		block.resetTimeStamp();
		String hash = Hash.hash(block, 1);
		assertEquals("2277ce8ab7cc282d7daf1c096bb7c7d398a012b036662625ead63ef5f9591b34", hash);
	}

}
