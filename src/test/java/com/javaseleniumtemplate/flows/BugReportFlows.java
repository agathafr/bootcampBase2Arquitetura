package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.BugReportPage;

public class BugReportFlows {
    BugReportPage bugReportPage;

    public BugReportFlows() {
        bugReportPage = new BugReportPage();
    }

    public void cadastrarNovaOcorrencia(String resumo, String descricao) {
        bugReportPage.clicarNoLinkReportarCaso();
        bugReportPage.navegarParaPaginaSelecaoDeProjeto();
        bugReportPage.selecionarProjeto("TesteTati");
        bugReportPage.clicarEmSelecionarProjeto();
        bugReportPage.navegarParaPaginaReportarBug();
        bugReportPage.selecionarCategoria("[All Projects] General");
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmEnviarRelatorio();
    }
}
