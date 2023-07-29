package br.com.bank.service;

import br.com.bank.CaminhoArquivo;
import br.com.bank.gateway.Bacen;
import br.com.bank.model.Banco;
import br.com.bank.model.Conta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.quality.Strictness;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Paths;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SistemaBancarioTest {

    // @InjectMocks
    // private SistemaBancario sistemaBancario;
    // @Mock
    // private Bacen bacen;

    private Banco banco;
    private Conta conta1;
    private Conta conta2;

    @BeforeEach
    public void setUp() {
        banco = new Banco("Meu Banco");
        conta1 = new Conta("11111111111", "João", 5000.0);
        conta2 = new Conta("22222222222", "Maria", 12000.0);
    }

    @Test
    public void testAdicionarConta() {
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        assertEquals(conta1, banco.pesquisarContaDoCliente("11111111111"));
        assertEquals(conta2, banco.pesquisarContaDoCliente("22222222222"));
    }

    @Test
    public void testPesquisarContaDoCliente() {
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        assertEquals(conta1, banco.pesquisarContaDoCliente("11111111111"));
        assertEquals(conta2, banco.pesquisarContaDoCliente("22222222222"));
        assertNull(banco.pesquisarContaDoCliente("33333333333")); // Non-existing CPF
    }

    @Test
    public void testListarContasAltaRenda() {
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        assertEquals(1, banco.listarContasAltaRenda().size());
        assertTrue(banco.listarContasAltaRenda().contains(conta2));
    }

}