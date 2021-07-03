package com.infra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.model.entity.Account;
import com.model.entity.Branch;
import com.model.entity.Tran;
import com.model.entity.TranPK;
import com.repository.AccountRepository;
import com.repository.BranchRepository;
import com.repository.TranRepository;

@Component
public class InitData {

    InitData(){
    	System.out.println("Initialization");
    }
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TranRepository tranRepository;
    
    @Autowired
    BranchRepository branchRepository;
    
    @PostConstruct
    private void initAccount() throws IOException, Exception {
    	 System.out.println("START!!");
        if (accountRepository.count() == 0) {
            Resource resource = new ClassPathResource("계좌정보.csv");
            System.out.println("START!!");
            List<Account> accountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Account.builder().accountNo(split[0]).accountName(split[1]).branchCode(split[2])
                                .build();
                    }).collect(Collectors.toList());
          accountRepository.saveAll(accountList);
        }
    }
    
    @PostConstruct
    private void branchAccount() throws IOException, Exception {
    	 System.out.println("START!!");
        if (branchRepository.count() == 0) {
            Resource resource = new ClassPathResource("관리점정보.csv");
            System.out.println("START!!");
            List<Branch> branchList = new ArrayList<>();
                    List<String> lines= Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8);
                    for(int i=0; i < lines.size(); i++) {
                    	 if(i==0)
                    		continue;
                    	String[] split = lines.get(i).split(",");
                    	branchList.add(Branch.builder().branchCode(split[0]).branchName(split[1])
                        .build());
                    }
                      
           branchRepository.saveAll(branchList);
        }
    }
    
    
    
    @PostConstruct
    private void initTran() throws IOException, Exception {
        if (tranRepository.count() == 0) {
            Resource resource = new ClassPathResource("거래내역.csv");
            List<Tran> tranList = new ArrayList<>();
            List<String> lines= Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8);
            for(int i=0; i < lines.size(); i++) {
            	 if(i==0)
            		continue;
            	String[] split = lines.get(i).split(",");
            	tranList.add(Tran.builder().pk(new TranPK(split[0], Integer.parseInt(split[2]))).acctNo(split[1])
            			.amount(Integer.parseInt(split[3])).fee(Integer.parseInt(split[4])).cancelFlag(split[5])
                        .build());
            	
            }
           tranRepository.saveAll(tranList);
        }
    }
}
