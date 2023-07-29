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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SistemaBancarioTest {

    private Bacen bacenMock;
    private SistemaBancario sistemaBancario;

    @BeforeEach
    public void setUp() {
        bacenMock = mock(Bacen.class);
        sistemaBancario = new SistemaBancario(bacenMock);
    }

    @Test
    public void testRegistrarBancoWithSuccess() {
        Banco banco = new Banco("Meu Banco");
        long registeredBancoId = 1234;

        when(bacenMock.cadastrarBanco(banco)).thenReturn(registeredBancoId);

        long result = sistemaBancario.registrarBanco(banco);

        assertEquals(registeredBancoId, result);
        verify(bacenMock, times(1)).cadastrarBanco(banco);
    }

    @Test
    public void testRegistrarBancoWithFailure() {
        Banco banco = new Banco("Meu Banco");

        when(bacenMock.cadastrarBanco(banco)).thenThrow(new RuntimeException("Banco not registered in Bacen"));

        assertThrows(RuntimeException.class, () -> sistemaBancario.registrarBanco(banco));

        verify(bacenMock, times(1)).cadastrarBanco(banco);
    }
}