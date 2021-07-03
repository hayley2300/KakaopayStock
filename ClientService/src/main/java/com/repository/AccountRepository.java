package com.repository;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.model.Requirement2;
import com.model.entity.Account;

@Cacheable(false)
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query(value = query2, nativeQuery = true)
	List<Requirement2> getRequirement2();

	String query2 ="SELECT '2018' as year, ACCT_NAME as name , ACCT_NO as acctNo\n"
			+ "FROM ACCOUNT WHERE ACCT_NO NOT IN (SELECT DISTINCT(ACCT_NO)\n"
			+ "FROM TRAN WHERE TRAN_DATE  LIKE '2018____' AND CANCEL_FLAG='N')\n"
			+ "UNION ALL\n"
			+ "SELECT '2019', ACCT_NAME as name, ACCT_NO as acctNo\n"
			+ "FROM ACCOUNT WHERE ACCT_NO NOT IN (SELECT DISTINCT(ACCT_NO)\n"
			+ "FROM TRAN WHERE TRAN_DATE  LIKE '2019____' AND CANCEL_FLAG='N')";
}

