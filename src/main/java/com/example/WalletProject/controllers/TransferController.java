package com.example.WalletProject.controllers;

import com.example.WalletProject.services.TransferService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
}
