package com.example.WalletProject.services;

import com.example.WalletProject.models.DTO.*;
import com.example.WalletProject.models.Entity.Account;
import com.example.WalletProject.models.Entity.AuthInfo;
import com.example.WalletProject.models.Entity.Client;
import com.example.WalletProject.models.Entity.Document;
import com.example.WalletProject.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AuthInfoRepository authInfoRepository;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private AccountService accountService;
    public ClientInformationForMainPageDTO  getClientById(Long id)
    {
        Client client = clientRepository.findById(id).get();
        ClientInformationForMainPageDTO  clientInformationForMainPageDTO = new ClientInformationForMainPageDTO
                (client.getFirstname()
                ,client.getLastname()
                ,client.getPatronymic()
                ,client.getDateOfBirth()
                ,client.getEmail()
                ,client.getPhoneNumber());
        return clientInformationForMainPageDTO ;
    }
    public List<TransactionDto> getAllTransactionByClientId(Long id)
    {

        accountRepository.findAll();
        List<TransactionDto>transactionsByClientid = new ArrayList<>();
        List<Account>accounts = accountRepository.findAll();
        for (Account account:accounts)
        {
            if(account.getClient().getId()==id.longValue())
            {
                transactionsByClientid.addAll(accountService.getTransactionsById(account.getId()));
            }
        }
        return transactionsByClientid;
    }
    public List<AccountDto> getAllAccountsByClientId(Long id)
    {
        List<AccountDto>accountsByClientid = new ArrayList<>();
        List<Account>accounts = accountRepository.findAll();

        for (Account account:accounts)
        {
            if(account.getClient().getId() == (long)id) {
                accountsByClientid.add
                        (new AccountDto
                        (account.getId()
                        ,account.getName()
                        ,account.getFrozen()
                        ,account.getComment()
                        ,account.getValue()
                        ,account.getCreatedAt()
                        ,account.getUpdatedAt()
                        ,account.getClient().getId()
                        ,account.getCurrency().getId()));
            }
        }
        return accountsByClientid;
    }
    public AuthInfoDto getAuthInfoByClientId(Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);
        AuthInfoDto authInfoDto =
                new AuthInfoDto
                        (authInfo.getLogin(),
                         authInfo.getPassword());
        return authInfoDto;
    }
    public void updateAuthClientById(AuthInfoDto authInfoDto,Long id)
    {
        AuthInfo authInfo = authInfoRepository.getById(id);

        authInfo.setLogin(authInfoDto.getLogin());
        authInfo.setPassword(authInfoDto.getPassword());

        authInfoRepository.save(authInfo);
    }


    public DocumentDto getDocumentByClientId(Long id)
    {
        Document document = clientRepository.getById(id).getDocument();
        DocumentDto documentDto =
                new DocumentDto
                (document.getDocumentNumber(),
                 document.getIssueDate(),
                 document.getCreatedAt(),
                 document.getUpdatedAt(),
                 document.getCountry().getName());
        return documentDto;
    }

    public ClientInformationForManageDTO getClientInformationForManageByClientId(Long id)
    {
        Client client = clientRepository.getById(id);
        ClientInformationForManageDTO clientInformationForManageDTO =
                new ClientInformationForManageDTO
                (
                        client.getCreatedAt(),
                        client.getUpdatedAt(),
                        client.getFrozen(),
                        client.getIsDelete(),
                        client.getIsVerify(),
                        client.getDocument().getId()
                );
        return clientInformationForManageDTO;

    }

//    public void updateDocumentByClientId(Long id,DocumentDto documentDto)
//    {
//        List<Document>documents = documentRepository.findAll();
//        Document document = clientRepository.getById(id).getDocument();
//        document.setDocumentNumber(documentDto.getDocumentNumber());
//        document.setIssueDate(documentDto.getIssueDate());
//        document.setCreatedAt(documentDto.getUpdatedAt());
//        for (Document doc:documents)
//        {
//            if (doc.getCountry().getName().equals(documentDto.getCountry()))
//        }
//        document.setCountry();
//    }
}