package com.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tran")
public class Tran {
	
    @EmbeddedId
    private TranPK pk ;
    
	@Column(name = "acct_no")
    private String acctNo;
	
	
	@Column(name = "amount")
    private int amount;
	
	@Column(name = "fee")
    private int fee;
	
	@Column(name = "cancel_flag")
    private String cancelFlag;

}
