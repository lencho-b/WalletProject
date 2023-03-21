package com.example.WalletProject.controllers;

import com.example.WalletProject.services.TransferService;

public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
}
