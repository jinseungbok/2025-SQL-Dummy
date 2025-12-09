package kr.domsam.youbankdummy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_bacnt_mst_js_js")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {

    @Id
    @Column(name = "BACNT_NO", length = 20)
    private String accountNo;

    @Column(name = "CUST_ID", length = 10, nullable = false)
    private String customerId;

    @Column(name = "BACNT_PSWD", length = 6)
    private String password;

    @Column(name = "BANK_CD", length = 10, nullable = false)
    private String bankCode;

    @Column(name = "BACNT_NM", length = 100, nullable = false)
    private String accountName;

    @Column(name = "DPSTR_NM", length = 10)
    private String depositorName;

    @Column(name = "BACNT_BLNC", precision = 15, scale = 0, nullable = false)
    private Long balance;

    @Column(name = "BACNT_ESTBL_YMD", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "BACNT_MTRY_YMD", nullable = false)
    private LocalDateTime maturityAt;

    @Column(name = "BACNT_CNCL_YMD")
    private LocalDateTime closedAt;

    @Column(name = "BACNT_TY", length = 2)
    private String accountType; // 03 예금 04 적금

    @Column(name = "LIM_AMT", precision = 15, scale = 0)
    private Long limitAmount;

    @Column(name = "CUST_GUBUN", length = 2)
    private String customerType;

    @Column(name = "MNG_BRNCH_ID", length = 10, nullable = false)
    private String branchId;

    @Column(name = "BACNT_USE_YN", length = 1)
    private String useYn;

    @Column(name = "VR_BACNT_YN", length = 1)
    private String virtualYn;

    @Column(name = "RMRK", length = 300)
    private String remark;

    @Column(name = "RGT_GUBUN", length = 2)
    private String regType;

    @Column(name = "RGT_ID", length = 10)
    private String regId;

    @Column(name = "RGT_DTM")
    private LocalDateTime regDate;

    @Column(name = "MDF_ID", length = 10)
    private String modId;

    @Column(name = "MDF_DTM")
    private LocalDateTime modDate;
}
