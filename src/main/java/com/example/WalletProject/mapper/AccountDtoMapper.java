package com.example.WalletProject.mapper;

import com.example.WalletProject.dto.AccountFullInfoDTO;
import com.example.WalletProject.dto.AccountInfoForAccountsList;
import com.example.WalletProject.dto.ClientWithAccountsDTO;
import com.example.WalletProject.models.Account;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoMapper {
    private final ModelMapper modelMapper;

    public AccountDtoMapper(){
        this.modelMapper = new ModelMapper();

        modelMapper.createTypeMap(Account.class, AccountFullInfoDTO.class)
                .addMappings(account -> account.skip(AccountFullInfoDTO::setCurrency))
                .setPostConverter(toDtoConverter());
        modelMapper.createTypeMap(AccountFullInfoDTO.class, Account.class)
                .addMappings(account -> account.skip(Account::setCurrency))
                .setPostConverter(toEntityConverter());

    }

    private Converter<Account, AccountInfoForAccountsList> toDtoConverter(){
        return context -> {
            Account source = context.getSource();
            AccountInfoForAccountsList destination = context.getDestination();
            destination.setCurrency(modelMapper.map(source.getCurrency(), CurrencyDTO.class));
            return context.getDestination();
        };
    }

    public AccountInfoForAccountsList toDto(Account entity){
        return  modelMapper.map(entity, AccountInfoForAccountsList.class);
    }

    public Account toEntity(AccountInfoForAccountsList dto){
        return modelMapper.map(dto, Account.class);
    }

}
