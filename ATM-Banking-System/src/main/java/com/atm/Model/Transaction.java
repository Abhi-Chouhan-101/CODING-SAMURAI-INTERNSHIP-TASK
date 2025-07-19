package com.atm.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("transactions")
    private User user;

    @Column(nullable = false)
    private String type;  // "DEPOSIT" or "WITHDRAW"

    @Column(nullable = false)
    private Double amount;

    private Double postBalance;

    private LocalDateTime transactionTime;

    @PrePersist
    public void onCreate() {
        this.transactionTime = LocalDateTime.now();
    }
}
