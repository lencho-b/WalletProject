package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.models.Account;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountInfoForAccountsListMapper {
    private final ModelMapper modelMapper;

    public AccountInfoForAccountsListMapper(){
        this.modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Account.class, AccountInfoForAccountsList.class)
                .addMappings(account-> account.skip(AccountInfoForAccountsList::setCurrency)).setPostConverter(toDtoConverter());

    }

    private Converter<Account, AccountInfoForAccountsList> toDtoConverter(){
        return context -> {
            Account source = context.getSource();
            AccountInfoForAccountsList destination = context.getDestination();
            destination.setCurrency(source.getCurrency().getName());
            return context.getDestination();
        };
    }



    public AccountInfoForAccountsList toDto(Account entity){
        return  modelMapper.map(entity, AccountInfoForAccountsList.class);
    }

//    public Account toEntity(AccountInfoForAccountsList dto){
//        return modelMapper.map(dto, Account.class);
//    }

}
