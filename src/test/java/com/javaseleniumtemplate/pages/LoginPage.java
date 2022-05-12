package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@value=\"Login\"]");
    By loggedUserText = By.xpath("//td[@class=\"login-info-left\"]/span[@class=\"italic\"]");
    By errorMessageLabel = By.xpath("//font[contains(.,'Your account may be disabled or blocked or the username/password you entered is incorrect.')]");

    //Actions
    public void preenhcerUsuario(String usuario) {
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha) {
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin() {
        click(loginButton);
    }

    public void navegarParaPaginaInicial() {
        driver.navigate().to(GlobalParameters.URL_DEFAULT + "my_view_page.php");
    }

    public String retornaUsuarioLogado() {
        return getText(loggedUserText);
    }

    public String retornaMensagemDeErroLogin() {
        return getText(errorMessageLabel);
    }

}
