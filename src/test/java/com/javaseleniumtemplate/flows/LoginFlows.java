package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows() {
        //Page and Steps Objects
        loginPage = new LoginPage();
    }

    //Flows
    public void efetuarLogin(String usuario, String senha) {
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();
        loginPage.navegarParaPaginaInicial();
        loginPage.retornaUsuarioLogado();
    }
}
