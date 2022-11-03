package com.fortune.bank.model;

import com.example.accounts.Constant.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  long customerId;
    private Type type;
    @Column(unique = true)
    private String accountNumber;
    private  String branchAddress;
    @CreatedDate
    private Date createDt;
}
