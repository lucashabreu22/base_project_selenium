package page;

import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import maps.GooglePageMaps;
import util.EvidenceManager;

import static util.EvidenceManager.EvidenceGenerate;

public class GooglePage extends BasePage {

    public GooglePageMaps googlePageMaps;
    public GooglePage(){
        googlePageMaps = new GooglePageMaps();
    }

    @Given("go to Google")
    public void acessarGoogle() throws Exception {
        navigate("https://www.google.com/");
        EvidenceGenerate("Tela inicial google");

    }

    @When("search {string}")
    public void buscarNoGoogle(String valorBusca) throws Exception {
        sendKeys(googlePageMaps.buscaGoogle, valorBusca);
        Thread.sleep(500);
        click(googlePageMaps.pesquisaGoogle);
        EvidenceManager.EvidenceGenerate("Busca realizada");
    }

    @And("click on first link")
    public void acessarItemBusca() throws Exception {
        waitElement(googlePageMaps.primeiroLink, SMALL);
        click(googlePageMaps.primeiroLink);
    }
}
