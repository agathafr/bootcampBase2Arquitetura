package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MyViewPage extends PageBase {
    By monitoredByMeIssueLink = By.linkText("Monitored by Me");
    By monitoredByResponsibleNameText = By.id("user_monitor_filter_target");
    By viewingIssuesTable = By.xpath("//table[@id='buglist']//span[contains(text(), 'Viewing Issues')]");

    public void clicarNoLinkMonitoradoPorMim() {
        click(monitoredByMeIssueLink);
    }

    public void navegarParaPaginaVerTodosOsBugs() {
        driver.navigate().to(GlobalParameters.URL_DEFAULT + "view_all_bug_page.php?filter=11182");
    }

    public String retornaNomeDoResponsavelPeloMonitoramento() {
        return getText(monitoredByResponsibleNameText);
    }

    public String exibeTabelaVisualizandoProblemas() {
        return getText(viewingIssuesTable);
    }

}
