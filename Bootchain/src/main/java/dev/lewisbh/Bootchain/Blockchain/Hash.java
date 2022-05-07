package dev.lewisbh.Bootchain.Blockchain;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class Hash {

	public static String hash(Block block, Integer nonce) throws IOException {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");

			block.setNonce(nonce);

			byte[] messageDigest = md.digest(block.toByteArray());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}

			return hashtext;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
