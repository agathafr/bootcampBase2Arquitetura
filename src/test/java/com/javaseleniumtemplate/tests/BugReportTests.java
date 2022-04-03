package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.BugReportPage;
import org.junit.Assert;
import org.junit.Test;

public class BugReportTests extends TestBase {
    BugReportPage bugReportPage;

    @Test
    public void cadastrarNovaOcorrenciaComSucesso() {
        bugReportPage = new BugReportPage();

        String resumo = "Incorrect error message";
        String descricao = "The message displayed when logging in is not in accordance with the implementation requirement.";
        String mensagemEsperada = "Operation successful.";

        bugReportPage.clicarNoLinkReportarCaso();
        bugReportPage.navegarParaPaginaSelecaoDeProjeto();
        bugReportPage.selecionarProjeto();
        bugReportPage.clicarEmSelecionarProjeto();
        bugReportPage.navegarParaPaginaReportarBug();
        bugReportPage.selecionarCategoria();
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemSucessoParaReportCriado().contains(mensagemEsperada));
    }

}
