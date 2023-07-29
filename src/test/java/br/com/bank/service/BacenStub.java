package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

public class BacenStub extends Bacen {

    private boolean success;

    public BacenStub(boolean success) {
        this.success = success;
    }

    @Override
    public long cadastrarBanco(Banco banco) {
        if (success) {
            return 1234; // Replace with a predefined registered bank ID
        } else {
            throw new RuntimeException("Banco not registered in Bacen");
        }
    }
}
