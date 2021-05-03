package page;


import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import maps.YouTubePageMaps;
import util.EvidenceManager;

import static org.junit.Assert.assertTrue;

public class YouTubePage extends BasePage {

    public YouTubePageMaps youTubePageMaps;
    public YouTubePage(){
        youTubePageMaps = new YouTubePageMaps();
    }

    @Then("go to YouTube")
    public void validarAcessoComSucesso() throws Exception {
        waitElement(youTubePageMaps.home, MIDDLE);
        assertTrue(checkElement(youTubePageMaps.home));
        EvidenceManager.EvidenceGenerate("Tela inicial youtube");
    }

    @When("search for the {string} video")
    public void buscarVideo(String valorBusca) throws Exception {
        sendKeys(youTubePageMaps.inputBusca, valorBusca);
        click(youTubePageMaps.buttonBusca);
    }

    @And("click on first video")
    public void clicarVideoBusca() throws Exception {
        waitElement(youTubePageMaps.video, SMALL);
        EvidenceManager.EvidenceGenerate("busca do video");
        click(youTubePageMaps.video);
    }

    @Then("watch the video")
    public void verVideo() throws Exception {
        //assertion
        Thread.sleep(10000);
        EvidenceManager.EvidenceGenerate("video executado");
    }

}
