package core;

import org.openqa.selenium.WebDriver;

public class BaseMap {
	protected WebDriver driver;

	public BaseMap(WebDriver driver) {
		this.driver = driver;
	}

	public Element criarElementoPorTexto(String texto) {
		return new Element(driver, "text", texto);
	}
}
