package kr.domsam.youbankdummy.application;

import kr.domsam.youbankdummy.entity.BankAccount;
import kr.domsam.youbankdummy.entity.BankTransaction;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class DummyDataGenerator implements CommandLineRunner {

    private final BankAccountRepository accountRepo;
    private final BankTransactionRepository txRepo;

    private final Random random = new Random();

    @Override
    public void run(String... args) {

        int target = 100000;
        List<BankAccount> accounts = new ArrayList<>();

        for (int i = 0; i < target; i++) {
            String accountNo = randomAccountNo();

            LocalDateTime created = randomDate(2018, 2025);
            LocalDateTime maturity = created.plusYears(1 + random.nextInt(5));

            String type = random.nextBoolean() ? "03" : "04";
            long balance = type.equals("03")
                    ? random.nextLong(10_000_000_000L)  // 예금 0~10억
                    : random.nextLong(3_000_000L) + 10_000; // 적금 1~300만

            accounts.add(BankAccount.builder()
                    .accountNo(accountNo)
                    .customerId(randomCustomerId())
                    .password(randomPassword())
                    .bankCode("004")
                    .accountName("계좌-" + accountNo.substring(0, 6))
                    .depositorName("홍길동")
                    .balance(balance)
                    .createdAt(created)
                    .maturityAt(maturity)
                    .accountType(type)
                    .limitAmount(1_000_000L)
                    .customerType("1")
                    .branchId("001")
                    .useYn("Y")
                    .virtualYn("N")
                    .regType("3")
                    .regId("SYS")
                    .regDate(LocalDateTime.now())
                    .build());
        }

        accountRepo.saveAll(accounts);

        // 거래내역 생성
        List<BankTransaction> txList = new ArrayList<>();

        for (BankAccount acc : accounts) {
            long curBalance = acc.getBalance();

            for (int i = 0; i < 3; i++) {
                long amount = 1000L + random.nextInt(500000);

                String type = random.nextBoolean() ? "1" : "2"; // 입금/출금

                if (type.equals("2") && curBalance < amount) {
                    type = "1"; // 잔액 부족 → 입금 전환
                }

                if (type.equals("1")) curBalance += amount;
                else curBalance -= amount;

                txList.add(BankTransaction.builder()
                        .accountNo(acc.getAccountNo())
                        .datetime(randomDateTime())
                        .type(type)
                        .bankCode("004")
                        .targetAccount(randomAccountNo())
                        .amount(amount)
                        .transactionType("DL01")
                        .balance(curBalance)
                        .memo("랜덤 거래")
                        .build());
            }
        }

        txRepo.saveAll(txList);

        System.out.println("=== 더미 생성 완료 ===");
    }

    private String randomAccountNo() {
        return String.format("%020d", Math.abs(random.nextLong() % 1_000_000_000_000_000_000L));
    }

    private String randomCustomerId() {
        return String.format("%010d", random.nextInt(10_000_000));
    }

    private String randomPassword() {
        return String.format("%06d", random.nextInt(1_000_000));
    }

    private LocalDateTime randomDate(int startYear, int endYear) {
        int year = startYear + random.nextInt(endYear - startYear + 1);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        return LocalDateTime.of(year, month, day, random.nextInt(24), random.nextInt(60));
    }

    private LocalDateTime randomDateTime() {
        int year = 2020 + random.nextInt(4);
        int month = 1 + random.nextInt(12);
        int day = 1 + random.nextInt(28);
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);
        return LocalDateTime.of(year, month, day, hour, minute, second);
    }
}
