package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugReportPage extends PageBase {

    By reportIssueLink = By.linkText("Report Issue");
    By selectProjectButton = By.xpath("//input[@value='Select Project']");
    By summaryField = By.name("summary");
    By descriptionTextArea = By.name("description");
    By sendReportButton = By.xpath("//input[@value='Submit Report']");
    By successMessageLabel = By.xpath("//body//div[2]");
    By errorMessageLabel = By.xpath("//tbody//tr[2]//p");

    public void clicarNoLinkReportarCaso() {
        click(reportIssueLink);
    }

    public void navegarParaPaginaSelecaoDeProjeto() {
        driver.navigate().to(GlobalParameters.URL_DEFAULT + "login_select_proj_page.php?ref=bug_report_page.php");
    }

    public void selecionarProjeto(String projeto) {
        comboBoxSelectByVisibleText(By.xpath("//tr[contains(.,'Choose Project')]//select"), projeto);
    }

    public void clicarEmSelecionarProjeto() {
        click(selectProjectButton);
    }

    public void navegarParaPaginaReportarBug() {
        driver.navigate().to(GlobalParameters.URL_DEFAULT + "bug_report_page.php");
    }

    public void selecionarCategoria(String categoria) {
        comboBoxSelectByVisibleText(By.name("category_id"), categoria);
    }

    public void preencherResumo(String resumo) {
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao) {
        sendKeys(descriptionTextArea, descricao);
    }

    public void clicarEmEnviarRelatorio() {
        click(sendReportButton);
    }

    public String retornaMensagemSucessoReportCriado() {
        return getText(successMessageLabel);
    }

    public String retornaMenssagemErroFaltaCampoObrigatorio() {
        return getText(errorMessageLabel);
    }
}
