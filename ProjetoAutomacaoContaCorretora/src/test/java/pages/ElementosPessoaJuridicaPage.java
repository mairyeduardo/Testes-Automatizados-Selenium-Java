package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementosPessoaJuridicaPage {

    static WebDriver driver;



    public ElementosPessoaJuridicaPage(WebDriver driver){
        this.driver = driver;
    }

    public void preencherCampoRazaoSocial(String razaoSocial) {
        WebElement razao = driver.findElement(By.id("companyName"));
        razao.sendKeys(razaoSocial);
    }

    public void preencherCampoDataAberturaEmpresa(String date) {
        WebElement dataAbertura = driver.findElement(By.id("date"));
        dataAbertura.sendKeys(date);
    }

    public void preencherCampoCnpj(String cnpj) {
        WebElement campoCnpj = driver.findElement(By.id("document"));
        campoCnpj.sendKeys(cnpj);
    }

}
