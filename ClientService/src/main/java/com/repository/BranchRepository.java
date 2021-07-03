package com.repository;

import java.util.List;

import javax.persistence.Cacheable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Requirement4;
import com.model.entity.Branch;

@Cacheable(false)
public interface BranchRepository extends JpaRepository<Branch, String> {

	@Query(value = query4, nativeQuery = true)
	List<Requirement4> getRequirement4(@Param("branchName") String branchName);
	
	String query4 ="SELECT BRANCH_NM as brName, BRANCH_CD as brCode, (SELECT SUM(AMOUNT) FROM TRAN "
			+ "WHERE BRANCH_NM=:branchName\n"
			+ "AND CANCEL_FLAG='N') as sumAmt \n"
			+ "FROM BRANCH WHERE BRANCH_NM =:branchName";

}
