package br.com.bank.service;

import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;

public class BacenFake extends Bacen {
    private long registeredBancoId;

    public BacenFake(long registeredBancoId) {
        this.registeredBancoId = registeredBancoId;
    }

    @Override
    public long cadastrarBanco(Banco banco) {
        return registeredBancoId;
    }
}
