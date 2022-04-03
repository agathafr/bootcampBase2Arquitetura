package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugReportPage extends PageBase {

    By resumeField = By.name("summary");
    By descriptionTextArea = By.name("description");
    By sendReportButton = By.xpath("//input[@value='Enviar Relatório']");
    By successMessageLabel = By.xpath("//div[contains(.,'Operação realizada com sucesso.')]");

    public void selecionarCategoria() { comboBoxSelectByVisibleText(By.name("category_id"), "[Todos os Projetos] General"); }

    public void preencherResumo(String resumo) { sendKeys(resumeField, resumo); }

    public void preencherDescricao(String descricao) { sendKeys(descriptionTextArea, descricao); }

    public void clicarEmEnviarRelatorio() { click(sendReportButton); }

    public String retornaMensagemSucessoReport() { return getText(successMessageLabel); }
}
