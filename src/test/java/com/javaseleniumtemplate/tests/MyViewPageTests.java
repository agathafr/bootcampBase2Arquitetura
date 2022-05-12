package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MyViewPage;
import org.junit.Assert;
import org.junit.Test;

public class MyViewPageTests extends TestBase {
    MyViewPage myViewPage;
    LoginFlows loginFlows;

    @Test
    public void clicaParaVisualizarBugsMonitoradosPeloUsuarioLogado() {
        myViewPage = new MyViewPage();
        loginFlows = new LoginFlows();

        String nomeDoResponsavelEsperado = "agatha.franca";
        String tituloDaTabelaEsperado = "Viewing Issues";

        loginFlows.efetuarLogin(GlobalParameters.USUARIO_GERAL, GlobalParameters.SENHA_GERAL);
        myViewPage.clicarNoLinkMonitoradoPorMim();
        myViewPage.navegarParaPaginaVerTodosOsBugs();
        myViewPage.retornaNomeDoResponsavelPeloMonitoramento();
        myViewPage.exibeTabelaVisualizandoProblemas();

        Assert.assertTrue(myViewPage.retornaNomeDoResponsavelPeloMonitoramento().contains(nomeDoResponsavelEsperado));
        Assert.assertTrue(myViewPage.exibeTabelaVisualizandoProblemas().contains(tituloDaTabelaEsperado));
    }
}
