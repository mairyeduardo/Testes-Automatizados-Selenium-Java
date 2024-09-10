package teste;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElementosComunsCadastroPage;
import pages.ElementosPessoaJuridicaPage;

public class TesteCriacaoContaPessoaJuridica {


    static WebDriver driver;

    static ElementosComunsCadastroPage elementosComunsPage;

    static ElementosPessoaJuridicaPage elementosPessoaJuridicaPage;
    @BeforeClass
    public static void setBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mairy\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cliente.advancedcorretora.com.br/signup");
        driver.manage().window().maximize();
        elementosComunsPage = new ElementosComunsCadastroPage(driver);
        elementosComunsPage.aceitarCookies();
        elementosPessoaJuridicaPage = new ElementosPessoaJuridicaPage(driver);
    }

    @Test
    public void preencherInformacoesCorretasDoFormularioDePessoaJuridicaECriarContaComSucesso(){
        elementosComunsPage.clicarBotaoPessoaJuridica();
        elementosComunsPage.preencherCampoNome("Empresa");
        elementosComunsPage.preencherCampoSobrenome("Teste");
        elementosPessoaJuridicaPage.preencherCampoRazaoSocial("Fantasia");
        elementosPessoaJuridicaPage.preencherCampoDataAberturaEmpresa("20/09/2015");
        elementosPessoaJuridicaPage.preencherCampoCnpj("23.121.214/2412-41");
        elementosComunsPage.clicarNoBotaoCampoDDIESelecionarOBrasil();
        elementosComunsPage.preencherCampoNumeroDeCelular("51", "985723469");
        elementosComunsPage.preencherCampoEmail("emailteste@mailinator.com");
        elementosComunsPage.preencherCampoConfirmarEmail("emailteste@mailinator.com");
        elementosComunsPage.aceitarTermosLegais();
        elementosComunsPage.clicarBotaoCadastrar();
    }

    @Test
    public void preencherInformacoesDoCampoCNPJComMenosDigitosQueOSolicitadoEVerificarMensagemDeTamanhoInvalido(){
        elementosComunsPage.preencherCampoNumeroDeCelular("51", "985723469");
        elementosComunsPage.preencherCampoEmail("emailtestemailinatorcom");
        elementosComunsPage.preencherCampoConfirmarEmail("emailtestemailinatorcom");
        elementosComunsPage.verificarMensagemDeErroEmail();
    }

}
