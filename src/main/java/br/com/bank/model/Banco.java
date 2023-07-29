package br.com.bank.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Banco {

    private String nome;
    private Map<String, Conta> contasMap;

    public Banco(String nome) {
        this.nome = nome;
        contasMap = new HashMap<>();
    }

    private List<Conta> contas = new ArrayList<>();

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        contasMap.put(conta.getCpf(), conta); // Store the account in the Map using CPF as the key
    }

    public Conta pesquisarContaDoCliente(String cpf) {
        return contasMap.get(cpf); // Directly access the account associated with the given CPF
    }

    public List<Conta> listarContasAltaRenda() {
        return filtrarContas(c -> c.getSaldo() >= 10000);
    }

    private List<Conta> filtrarContas(Predicate<Conta> filtro) {
        return contasMap.values().stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }
}
