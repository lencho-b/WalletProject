package com.example.WalletProject.controllers;

import com.example.WalletProject.DTO.ClientDTO;
import com.example.WalletProject.DTO.ClientInformationForManageDTO;
import com.example.WalletProject.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ClientService clientService;

    public AdminController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/allClients")
    public List<ClientDTO> showAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/client/{id}")
    public ClientDTO showClientById(@PathVariable("id") Long id) {
        return clientService.getClientByIdForAdmin(id);
    }

    @PatchMapping("/client/{id}/update")
    public void setStatusByClientId(@PathVariable("id") Long id, @RequestBody ClientInformationForManageDTO clientInformationForManageDTO) {
        clientService.updateInformationForManageByClientId(id, clientInformationForManageDTO);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
    }
}
