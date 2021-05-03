package core;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.EvidenceManager;
import util.Globalinformation;

public class BasePage {
	protected String SMALL = "10", MIDDLE = "30", BIG = "60";
	private String ERR = "ERROR";
	private WebDriver driver;
	protected Globalinformation info;

	public BasePage() {
		this.driver = BaseTest.driver;
		info = new Globalinformation();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = BaseTest.driver;
		return driver;
	}

	public Boolean waitElement(Element e, String tempo) {
		try {
			new WebDriverWait(driver, Integer.parseInt(tempo))
					.until(ExpectedConditions.presenceOfElementLocated(e.getBy()));

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public Boolean checkElement(Element e) throws Exception {
		try {
			new WebDriverWait(driver, 0).until(ExpectedConditions.elementToBeClickable(e.getBy()));

		} catch (Exception ex) {
			EvidenceManager.EvidenceGenerate(ERR + " Item nao encontrado");
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public Boolean navigate(String url) throws Exception {
		try {
			driver.navigate().to(url);
		} catch (Exception ex) {
			EvidenceManager.EvidenceGenerate(ERR + " Impossivel acessar url");
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public Boolean click(Element e) throws Exception {
		try {
			scrollToElement(e);
			e.click();
		} catch (Exception ex) {
			EvidenceManager.EvidenceGenerate(ERR + " nao foi possivel clicar");
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public Boolean sendKeys(Element e, String texto) throws Exception {
		try {
			scrollToElement(e);
			e.escrever(texto);
		} catch (Exception ex) {
			EvidenceManager.EvidenceGenerate(ERR + " nao foi possivel preencher o campo");
			System.err.println(ex.getMessage());
			return false;
		}
		return true;
	}

	public Boolean changeTab() {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			if (tabs.size() > 1) {
				String handleName = "";
				for (String tab : tabs)
					handleName = tab;
				driver.switchTo().window(handleName);
				driver.manage().window().maximize();
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void scrollToElement(Element e) {
		e.scrollToElement();
	}

	public String pegarInformacaoAtributo(Element e, String atributo) {
		return e.pegarAtributo(atributo);
	}

	public void fecharAbas() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if (tabs.size() > 1) {
			driver.close();
			changeTab();
			fecharAbas();
		} else {
			String handleName = "";
			for (String tab : tabs)
				handleName = tab;
			driver.switchTo().window(handleName);
		}
	}
}
