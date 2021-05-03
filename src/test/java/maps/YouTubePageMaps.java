package maps;


import core.BasePage;
import core.Element;

public class YouTubePageMaps extends BasePage {

    public Element home = new Element(getDriver(), "xpath", "(//a[@id='endpoint'])[1]");
    public Element inputBusca = new Element(getDriver(), "xpath", "//form[@id='search-form']//input");
    public Element buttonBusca = new Element(getDriver(), "xpath", "//button[@id='search-icon-legacy']");
    public Element video = new Element(getDriver(), "xpath", "//*[text()='DBZ - Vegeta! Olha beeem! WHOOOOOOOOOOOOOOOL!!!']");

}
