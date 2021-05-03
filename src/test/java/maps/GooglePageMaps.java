package maps;

import core.BasePage;
import core.Element;

public class GooglePageMaps extends BasePage {

    public Element buscaGoogle = new Element(getDriver(), "xpath", "//input[@name='q']");
    public Element pesquisaGoogle = new Element(getDriver(), "xpath", "(//input[@name='btnK'])[1]");
    public Element primeiroLink = new Element(getDriver(), "xpath", "(//h3)[1]");
}
