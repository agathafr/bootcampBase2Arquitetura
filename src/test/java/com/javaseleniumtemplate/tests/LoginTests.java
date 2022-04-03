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
    public void efetuarLoginComSucesso(){

        //Objects instances
        loginPage = new LoginPage();

        //Parameteres
        String usuario = "agatha.franca";
        String senha = "L@3f4519";
        String textoEsperado = "agatha.franca";

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
        loginPage.navegarParaPaginaInicial();

        Assert.assertTrue(loginPage.capturarUsuarioLogado().contains(textoEsperado));
    }
}
