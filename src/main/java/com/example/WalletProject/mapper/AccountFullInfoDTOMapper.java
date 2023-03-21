package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.AccountFullInfoDTO;
import com.example.WalletProject.dto.AccountInfoForAccountsList;

import com.example.WalletProject.dto.ClientDTO;
import com.example.WalletProject.dto.TransactionInfo;
import com.example.WalletProject.models.Account;
import com.example.WalletProject.models.Client;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountFullInfoDTOMapper {
    private final ModelMapper modelMapper;
    private final TransactionInfoMapper transactionInfoMapper;

    public AccountFullInfoDTOMapper(TransactionInfoMapper transactionInfoMapper){
        this.transactionInfoMapper = transactionInfoMapper;
        this.modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Account.class, AccountFullInfoDTO.class)
                .addMappings(account -> account.skip(AccountFullInfoDTO::setCurrency))
                .addMappings(account->account.skip(AccountFullInfoDTO::setTransactions))
                .setPostConverter(toDtoConverter());
//        modelMapper.createTypeMap(AccountFullInfoDTO.class, Account.class)
//                .addMappings(account -> account.skip(Account::setCurrency))
//                .addMappings(account->account.skip(Account::setTransactionAccounts))
//                .setPostConverter(toEntityConverter());

    }

    // закомментировано, т.к. еще не знаем как будем сетить валюту.

//    private Converter<AccountFullInfoDTO, Account> toEntityConverter() {
//        return context -> {
//            AccountFullInfoDTO source = context.getSource();
//            Account destination = context.getDestination();
//            destination.setCurrency(//);
//            return context.getDestination();
//        };
//    }

    private Converter<Account, AccountFullInfoDTO> toDtoConverter(){
        return context -> {
            Account source = context.getSource();
            AccountFullInfoDTO destination = context.getDestination();
            destination.setCurrency(source.getCurrency().getName());
            List<TransactionInfo> transactionInfoList = source.getTransactionAccounts().stream()
                    .map(transaction -> transactionInfoMapper.toDto(transaction)).toList();
            destination.setTransactions(transactionInfoList);
            return context.getDestination();
        };
    }

    public AccountFullInfoDTO toDto(Account entity){
        return  modelMapper.map(entity, AccountFullInfoDTO.class);
    }

    public Account toEntity(AccountFullInfoDTO dto){
        return modelMapper.map(dto, Account.class);
    }

}
