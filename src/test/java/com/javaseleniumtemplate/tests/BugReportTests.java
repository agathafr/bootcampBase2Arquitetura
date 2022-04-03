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

        String resumo = "" ;
        String descricao = "" ;
        String mensagemEsperada = "Operação realizada com sucesso." ;

        bugReportPage.selecionarCategoria();
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmEnviarRelatorio();

        Assert.assertTrue(bugReportPage.retornaMensagemSucessoReport().contains(mensagemEsperada));
    }

}
