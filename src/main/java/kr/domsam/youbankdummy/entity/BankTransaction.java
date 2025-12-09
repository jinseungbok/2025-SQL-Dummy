package kr.domsam.youbankdummy.entity;

import jakarta.persistence.*;
import kr.domsam.youbankdummy.application.TransactionId;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_bacnt_dlng_js_js")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(TransactionId.class)
public class BankTransaction {

    @Id
    @Column(name = "BACNT_NO", length = 20)
    private String accountNo;

    @Id
    @Column(name = "DLNG_YMD")
    private LocalDateTime datetime;

    @Column(name = "DWCST_SE_CD", length = 1, nullable = false)
    private String type; // 1 입금, 2 출금

    @Column(name = "DLNG_BANK_CD", length = 10)
    private String bankCode;

    @Column(name = "DLNG_BACNT", length = 20)
    private String targetAccount;

    @Column(name = "DLNG_AMT", precision = 15, scale = 0, nullable = false)
    private Long amount;

    @Column(name = "DLNG_TP_CD", length = 10, nullable = false)
    private String transactionType;

    @Column(name = "DLNG_BLNC", precision = 15, scale = 0, nullable = false)
    private Long balance;

    @Column(name = "MEMO", length = 300)
    private String memo;
}