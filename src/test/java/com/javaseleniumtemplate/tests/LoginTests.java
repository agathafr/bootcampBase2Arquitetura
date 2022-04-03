package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;

    //Tests
    @Test
    public void efetuarLoginComSucesso() {
        loginPage = new LoginPage();

        String usuario = "agatha.franca";
        String senha = "L@3f4519";
        String textoEsperado = "agatha.franca";

        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
        loginPage.navegarParaPaginaInicial();

        Assert.assertTrue(loginPage.retornaUsuarioLogado().contains(textoEsperado));
    }

    @Test
    public void efetuarLoginInvalido() {
        loginPage = new LoginPage();

        String usuario = "emailinexistente@email.com";
        String senha = "123456";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";

        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertTrue(loginPage.retornaMensagemDeErroLogin().contains(mensagemErroEsperada));

    }
}
