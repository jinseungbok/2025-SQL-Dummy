package kr.domsam.youbankdummy.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionId implements Serializable {
    private String accountNo;
    private LocalDateTime datetime;
}

