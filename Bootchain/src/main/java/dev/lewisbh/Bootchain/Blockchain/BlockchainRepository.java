package dev.lewisbh.Bootchain.Blockchain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockchainRepository extends JpaRepository<Blockchain, Long> {

	@Query("SELECT * Blockchain b WHERE b.id = ?1")
	Optional<Blockchain> findBlockchain(Long blockchainId);

	@Query("SELECT chain FROM Blockchains b WHERE b.id = ?1")
	Optional<List<Block>> findChain(Long blockchainId);

	@Query("INSERT t INTO Blockchain b WHERE b.id = ?1")
	Optional<List<Transaction>> updateTransactions(Long blockchainId);

	@Query("INSERT b INTO Blockchain b WHERE b.id = ?1")
	Optional<List<Block>> updateChain(Long blockchainId);

	@Query("SELECT pending_transactions FROM Blockchain b WHERE b.id = ?1")
	Optional<List<Transaction>> findTransactions(Long blockchainId);

}
