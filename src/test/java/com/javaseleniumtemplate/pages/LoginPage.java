package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@value=\"Login\"]");
    By loggedUserText = By.xpath("//td[@class=\"login-info-left\"]/span[@class=\"italic\"]");


    //Actions
    public void preenhcerUsuario(String usuario){
        sendKeys(usernameField, usuario);
    }

    public void preencherSenha(String senha){
        sendKeys(passwordField, senha);
    }

    public void clicarEmLogin(){
        click(loginButton);
    }

    public void navegarParaPaginaInicial() { driver.navigate().to("https://mantis-prova.base2.com.br/my_view_page.php"); }

    public String capturarUsuarioLogado() { return getText(loggedUserText); }

}
