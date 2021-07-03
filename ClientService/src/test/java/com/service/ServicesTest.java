package com.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.model.Requirement1;
import com.model.Requirement2;
import com.model.Requirement3;
import com.model.Requirement4;
import com.repository.AccountRepository;
import com.repository.BranchRepository;
import com.repository.TranRepository;
import org.junit.jupiter.api.DisplayName;
import static org.mockito.BDDMockito.given;



@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ServicesTest {

	@InjectMocks
	private Services services;
	

	
    @Mock
    private AccountRepository accountRepository;
    @Mock
    private TranRepository tranRepository;
    @Mock
    private BranchRepository branchRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        services = new Services();
    }
    
    @Test
    @DisplayName("Requirement1Test")
    public void getRequirement1Test(){
    	Requirement1 rq1 = new Requirement1() {
			
			@Override
			public String getYear() {
				// TODO Auto-generated method stub
				return "2018";
			}
			
			@Override
			public int getSumAmt() {
				// TODO Auto-generated method stub
				return 1000;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "test";
			}
			
			@Override
			public String getAcctNo() {
				// TODO Auto-generated method stub
				return "12345678";
			}
		};
    	List<Requirement1> tran =  new ArrayList<>();
    	tran.add(rq1);
        given(tranRepository.getRequirement1()).willReturn(tran);
        
        List<Requirement1> rq1_result =  tranRepository.getRequirement1();
        System.out.println("rq1_result : ["+rq1_result.get(0).getAcctNo()+"]");
        
        Assertions.assertEquals(1, rq1_result.size());
        Assertions.assertEquals(rq1.getAcctNo(),rq1_result.get(0).getAcctNo());
    }
    
    @Test
    @DisplayName("Requirement2Test")
    public void getRequirement2(){
    	
    	Requirement2 rq2 = new Requirement2() {

			@Override
			public String getYear() {
				// TODO Auto-generated method stub
				return "2018";
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "test";
			}

			@Override
			public String getAcctNo() {
				// TODO Auto-generated method stub
				return "12345678";
			}
    		
    	};
    	List<Requirement2> tran =  new ArrayList<>();
    	tran.add(rq2);
        given(accountRepository.getRequirement2()).willReturn(tran);
        
        List<Requirement2> rq2_result =  accountRepository.getRequirement2();
        System.out.println("rq2_result : ["+rq2_result.get(0).getAcctNo()+"]");
        
        Assertions.assertEquals(1, rq2_result.size());
        Assertions.assertEquals(rq2.getAcctNo(),rq2_result.get(0).getAcctNo());
    }
    
    @Test
    @DisplayName("Requirement3Test")
    public void getRequirement3(){
    	Requirement3 rq3 = new Requirement3() {

			@Override
			public String getYear() {
				// TODO Auto-generated method stub
				return "2018";
			}

			@Override
			public String getBrName() {
				// TODO Auto-generated method stub
				return "테스트점";
			}

			@Override
			public String getBrCode() {
				// TODO Auto-generated method stub
				return "T";
			}

			@Override
			public int getSumAmt() {
				// TODO Auto-generated method stub
				return 12345678;
			}

		};
    	List<Requirement3> tran =  new ArrayList<>();
    	tran.add(rq3);
        given(tranRepository.getRequirement3()).willReturn(tran);
        
        List<Requirement3> rq3_result =  tranRepository.getRequirement3();
        System.out.println("rq3_result : ["+rq3_result.get(0).getSumAmt()+"]");
        
        Assertions.assertEquals(1, rq3_result.size());
        Assertions.assertEquals(rq3.getSumAmt(),rq3_result.get(0).getSumAmt());
    }

    @Test
    @DisplayName("Requirement4Test")
    public void getRequirement4(){
    	Requirement4 rq4 = new Requirement4() {

			@Override
			public String getBrName() {
				// TODO Auto-generated method stub
				return "테스트점";
			}

			@Override
			public String getBrCode() {
				// TODO Auto-generated method stub
				return "T";
			}

			@Override
			public int getSumAmt() {
				// TODO Auto-generated method stub
				return 12345678;
			}


		};
    	List<Requirement4> tran =  new ArrayList<>();
    	tran.add(rq4);
        given(branchRepository.getRequirement4("테스트점")).willReturn(tran);
        
        List<Requirement4> rq4_result =  branchRepository.getRequirement4("테스트점");
        System.out.println("rq4_result : ["+rq4_result.get(0).getSumAmt()+"]");
        
        Assertions.assertEquals(1, rq4_result.size());
        Assertions.assertEquals(rq4.getSumAmt(),rq4_result.get(0).getSumAmt());
    }
}
