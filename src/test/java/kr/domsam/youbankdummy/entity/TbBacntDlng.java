package kr.domsam.youbankdummy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_bacnt_dlng")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TbBacntDlng {

    @Id
    @Column(name = "DLNG_NO", nullable = false)
    private Long dlngNo;   // 거래번호 (PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BACNT_NO", nullable = false)
    private TbBacntMst bacnt;   // 계좌번호 (FK → tb_bacnt_mst)

    @Column(name = "DLNG_YMD", nullable = false)
    private LocalDateTime dlngYmd;  // 거래일시

    @Column(name = "DWCST_SE_CD", nullable = false, length = 1)
    private String dwcstSeCd;  // 입출금구분코드

    @Column(name = "DPST_BANK_CD", length = 10)
    private String dpstBankCd;  // 입금은행코드

    @Column(name = "DPST_BACNT", length = 20)
    private String dpstBacnt;  // 입금계좌번호

    @Column(name = "TKMNY_BANK_CD", length = 10)
    private String tkmnyBankCd;  // 출금은행코드

    @Column(name = "TKMNY_BACNT", length = 20)
    private String tkmnyBacnt;  // 출금계좌번호

    @Column(name = "DLNG_AMT", nullable = false, precision = 10, scale = 0)
    private BigDecimal dlngAmt;  // 거래금액

    @Column(name = "DLNG_TP_CD", nullable = false, length = 10)
    private String dlngTpCd;  // 거래유형코드: DL01

    @Column(name = "DLNG_BLNC", nullable = false, precision = 10, scale = 0)
    private BigDecimal dlngBlnc;  // 거래후잔액

    @Column(name = "MEMO", length = 300)
    private String memo;  // 메모

    @Column(name = "RGT_GUBUN", nullable = false, length = 2)
    private String rgtGubun;  // 등록구분 1:직원/2:고객/3:SYS

    @Column(name = "RGT_ID", nullable = false, length = 10)
    private String rgtId;  // 등록자ID

    @Column(name = "RGT_DTM", nullable = false)
    private LocalDateTime rgtDtm;  // 등록일자

    @Column(name = "MDF_ID", length = 10)
    private String mdfId;  // 수정자ID

    @Column(name = "MDF_DTM")
    private LocalDateTime mdfDtm; // 수정일자
}