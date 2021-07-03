package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
  
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
	@Column(name = "acct_no")
    private String accountNo;
	@Column(name = "acct_name")
    private String accountName;
	@Column(name = "branch_cd")
    private String branchCode;

}
