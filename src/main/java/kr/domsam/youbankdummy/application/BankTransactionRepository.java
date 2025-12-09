package kr.domsam.youbankdummy.application;

import kr.domsam.youbankdummy.entity.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, TransactionId> {}

