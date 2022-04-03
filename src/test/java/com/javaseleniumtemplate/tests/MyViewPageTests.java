package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.pages.MyViewPage;
import org.junit.Assert;
import org.junit.Test;

public class MyViewPageTests extends TestBase {
    MyViewPage myViewPage;

    @Test
    public void clicaParaVisualizarBugsMonitoradosPeloUsuarioLogado() {
        myViewPage = new MyViewPage();

        String nomeDoResponsavelEsperado = "agatha.franca";
        String tituloDaTabelaEsperado = "Viewing Issues";

        myViewPage.clicarNoLinkMonitoradoPorMim();
        myViewPage.navegarParaPaginaVerTodosOsBugs();
        myViewPage.retornaNomeDoResponsavelPeloMonitoramento();
        myViewPage.exibeTabelaVisualizandoProblemas();

        Assert.assertTrue(myViewPage.retornaNomeDoResponsavelPeloMonitoramento().contains(nomeDoResponsavelEsperado));
        Assert.assertTrue(myViewPage.exibeTabelaVisualizandoProblemas().contains(tituloDaTabelaEsperado));
    }
}
