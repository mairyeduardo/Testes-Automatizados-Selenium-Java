package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ElementosComunsCadastroPage {

    static WebDriver driver;

    public ElementosComunsCadastroPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aceitarCookies(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        WebElement button = driver.findElement(By.id("onetrust-accept-btn-handler"));
        button.click();
    }

    public void clicarBotaoPessoaJuridica(){
        WebElement button = driver.findElement(By.id("PjButton"));
        button.click();
    }

    public void preencherCampoNome(String firstName) {
        WebElement nome = driver.findElement(By.id("name"));
        nome.sendKeys(firstName);
    }

    public void preencherCampoSobrenome(String lastName) {
        WebElement sobrenome = driver.findElement(By.id("lastname"));
        sobrenome.sendKeys(lastName);
    }

    public void clicarNoBotaoCampoDDIESelecionarOBrasil() {
        WebElement button = driver.findElement(By.xpath("//div[@role=\"menu\"]/a[@id=\"ddi\"] "));
        button.click();
        WebElement pais = driver.findElement(By.xpath("//a[contains(text(), \"Brasil - +55\")]"));
        pais.click();
    }

    public void preencherCampoNumeroDeCelular(String ddd, String telefone) {
        WebElement campo1 = driver.findElement(By.id("ddd"));
        WebElement campo2 = driver.findElement(By.id("phone"));
        campo1.sendKeys(ddd);
        campo2.sendKeys(telefone);
    }

    public void preencherCampoEmail(String email){
        WebElement campoEmail = driver.findElement(By.id("email"));
        campoEmail.sendKeys(email);
    }

    public void preencherCampoConfirmarEmail(String email){
        WebElement campoConfirmaEmail = driver.findElement(By.id("confEmail"));
        campoConfirmaEmail.sendKeys(email);
    }

    public void aceitarTermosLegais(){
        WebElement checkbox = driver.findElement(By.xpath("//div[@Class=\"rs-checkbox-checker\"]/*[contains(text(), \"Autorizações Legais e LGPD\")]"));
        checkbox.click();
    }

    public void verificarMensagemDeErroEmail(){
        WebElement mensagemErro = driver.findElement(By.xpath("//span[contains(text(), \"Digite um email válido\")]"));
        mensagemErro.getText();
        mensagemErro.isDisplayed();
    }

    public void clicarBotaoCadastrar(){
        WebElement button = driver.findElement(By.xpath("//*[contains(text(), \"Cadastrar\")]"));
        button.click();
    }
}
