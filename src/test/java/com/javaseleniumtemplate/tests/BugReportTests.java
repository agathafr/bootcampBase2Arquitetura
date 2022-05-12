package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.BugReportPage;
import org.junit.Assert;
import org.junit.Test;

public class BugReportTests extends TestBase {
    BugReportPage bugReportPage;
    LoginFlows loginFlows;

    @Test
    public void cadastrarNovaOcorrenciaComSucesso() {
        bugReportPage = new BugReportPage();
        loginFlows = new LoginFlows();

        String resumo = "Incorrect error message";
        String descricao = "The message displayed when logging in with incorrect data does not comply with the implementation requirement.";
        String mensagemEsperada = "Operation successful.";

        loginFlows.efetuarLogin(GlobalParameters.USUARIO_GERAL, GlobalParameters.SENHA_GERAL);
        bugReportPage.clicarNoLinkReportarCaso();
        bugReportPage.navegarParaPaginaSelecaoDeProjeto();
        bugReportPage.selecionarProjeto("TesteTati");
        bugReportPage.clicarEmSelecionarProjeto();
        bugReportPage.navegarParaPaginaReportarBug();
        bugReportPage.selecionarCategoria("[All Projects] General");
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemSucessoReportCriado().contains(mensagemEsperada));
    }

    @Test
    public void cadastrarNovaOcorrenciaSemPreencherCamposObrigatorios() {
        bugReportPage = new BugReportPage();
        loginFlows = new LoginFlows();

        String mensagemEsperadaFaltaCampoObrigatorio = "A necessary field \"Summary\" was empty. Please recheck your inputs.";

        loginFlows.efetuarLogin(GlobalParameters.USUARIO_GERAL, GlobalParameters.SENHA_GERAL);
        bugReportPage.clicarNoLinkReportarCaso();
        bugReportPage.navegarParaPaginaSelecaoDeProjeto();
        bugReportPage.selecionarProjeto("TesteTati");
        bugReportPage.clicarEmSelecionarProjeto();
        bugReportPage.navegarParaPaginaReportarBug();
        bugReportPage.clicarEmEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMenssagemErroFaltaCampoObrigatorio().contains(mensagemEsperadaFaltaCampoObrigatorio));
    }
}
