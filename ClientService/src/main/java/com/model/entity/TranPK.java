package com.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

  
@Embeddable
public class TranPK implements Serializable{
	

	private static final long serialVersionUID = 1L;

	public TranPK() {}
	
	public TranPK(String trdt, int trno){
		super();
		tranDate = trdt;
		tranNo = trno;
	}
  
	@Column(name = "tran_date")
    private String tranDate;

	@Column(name = "tran_no")
    private int tranNo;
	


}
