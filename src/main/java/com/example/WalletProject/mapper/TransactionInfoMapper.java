package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.dto.TransactionDTO;
import com.example.WalletProject.dto.TransactionInfo;

import com.example.WalletProject.models.TransactionAccount;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TransactionInfoMapper {

    private final ModelMapper modelMapper;

    public TransactionInfoMapper(){
        this.modelMapper = new ModelMapper();

        modelMapper.createTypeMap(TransactionAccount.class, TransactionInfo.class)
                .addMappings(account-> account.skip(TransactionInfo::setTransaction)).setPostConverter(toDtoConverter());

    }

    private Converter<TransactionAccount, TransactionInfo> toDtoConverter(){
        return context -> {
            TransactionAccount source = context.getSource();
            TransactionInfo destination = context.getDestination();
            destination.setTransaction(modelMapper.map(source.getTransaction(), TransactionDTO.class));
            return context.getDestination();
        };
    }



    public TransactionInfo toDto(TransactionAccount entity){
        return  modelMapper.map(entity, TransactionInfo.class);
    }

//    public TransactionAccount toEntity(AccountInfoForAccountsList dto){
//        return modelMapper.map(dto, TransactionAccount.class);
//    }

}
