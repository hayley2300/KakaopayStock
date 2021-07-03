package com.repository;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Requirement1;
import com.model.Requirement3;
import com.model.entity.Tran;

@Cacheable(false)
public interface TranRepository extends JpaRepository<Tran, String> {

	@Query(value = query, nativeQuery = true)
	List<Requirement1> getRequirement1();

	
	@Query(value = query3, nativeQuery = true)
	List<Requirement3> getRequirement3();
	
	String query ="\n"
			+ "(SELECT '2018' as year, B.ACCT_NAME as name, A.ACCT_NO as acctNo, SUM(A.AMOUNT)+SUM(A.FEE) as sumAmt\n"
			+ " FROM TRAN AS A  LEFT OUTER JOIN ACCOUNT AS B ON A.ACCT_NO = B.ACCT_NO\n"
			+ "  WHERE  A.TRAN_DATE  LIKE '2018____' \n AND CANCEL_FLAG='N'" 
			+ "GROUP BY SUBSTRING(A.TRAN_DATE FROM 1 FOR 4 ), A.ACCT_NO, B.ACCT_NAME  ORDER BY 4 DESC\n"
			+ "FETCH FIRST 1 ROWS ONLY)\n"
			+ "UNION ALL\n"
			+ "(SELECT '2019' as year, B.ACCT_NAME as name,A.ACCT_NO as acctNo,  SUM(A.AMOUNT)+SUM(A.FEE) as sumAmt\n"
			+ " FROM TRAN AS A  LEFT OUTER JOIN ACCOUNT AS B ON A.ACCT_NO = B.ACCT_NO\n"
			+ "  WHERE  A.TRAN_DATE  LIKE '2019____' \n AND CANCEL_FLAG='N'"
			+ "GROUP BY SUBSTRING(A.TRAN_DATE FROM 1 FOR 4 ), A.ACCT_NO, B.ACCT_NAME  ORDER BY 4 DESC\n"
			+ "FETCH FIRST 1 ROWS ONLY)";

	String query3 = "SELECT SUBSTRING(A.TRAN_DATE FROM 1 FOR 4 ) as year, B.BRANCH_CD as brCode, B.BRANCH_NM as brName"
			+ ", SUM(A.AMOUNT) as sumAmt \n"
			+ "FROM TRAN AS A  LEFT OUTER JOIN \n"
			+ "(SELECT C.ACCT_NO, D.BRANCH_CD, D.BRANCH_NM \n"
			+ "FROM ACCOUNT AS C LEFT OUTER JOIN BRANCH AS D ON C.BRANCH_CD = D.BRANCH_CD) AS B\n"
			+ "ON A.ACCT_NO = B.ACCT_NO WHERE A.CANCEL_FLAG='N'\n"
			+ "GROUP BY SUBSTRING(A.TRAN_DATE FROM 1 FOR 4 ), B.BRANCH_NM, B.BRANCH_CD ORDER BY 1, 4 DESC";

}
