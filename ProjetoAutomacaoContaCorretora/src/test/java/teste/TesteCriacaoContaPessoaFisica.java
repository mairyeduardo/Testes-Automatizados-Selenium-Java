package teste;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ElementosComunsCadastroPage;
import pages.ElementosPessoaFisicaPage;

import java.time.Duration;

public class TesteCriacaoContaPessoaFisica {

    static WebDriver driver;
    static ElementosComunsCadastroPage elementosComunsPage;
    static ElementosPessoaFisicaPage elementosPessoaFisicaPage;

    @BeforeClass
    public static void setBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mairy\\Documents\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://cliente.advancedcorretora.com.br/signup");
        driver.manage().window().maximize();
        elementosComunsPage = new ElementosComunsCadastroPage(driver);
        elementosComunsPage.aceitarCookies();
        elementosPessoaFisicaPage = new ElementosPessoaFisicaPage(driver);
    }

    @Test
    public void preencherInformacoesCorretasDoFormularioDePessoaFisicaECriarContaComSucesso(){
        elementosComunsPage.preencherCampoNome("NomeTeste");
        elementosComunsPage.preencherCampoSobrenome("SobrenomeTeste");
        elementosPessoaFisicaPage.preencherCampoDataNascimento("23/11/2000");
        elementosPessoaFisicaPage.preencherCampoCpf("04406704701");
        elementosComunsPage.clicarNoBotaoCampoDDIESelecionarOBrasil();
        elementosComunsPage.preencherCampoNumeroDeCelular("51", "985723469");
        elementosComunsPage.preencherCampoEmail("emailteste@mailinator.com");
        elementosComunsPage.preencherCampoConfirmarEmail("emailteste@mailinator.com");
        elementosComunsPage.aceitarTermosLegais();
        elementosComunsPage.clicarBotaoCadastrar();
    }

    @Test
    public void preencherInformacoesDoCampoCPFComDadosInvalidosEVerificarMensagemDeCPFInvalido(){
        elementosComunsPage.preencherCampoNome("NomeTeste");
        elementosComunsPage.preencherCampoSobrenome("SobrenomeTeste");
        elementosPessoaFisicaPage.preencherCampoDataNascimento("23/11/2000");
        elementosPessoaFisicaPage.preencherCampoCpf("52515152525");
        elementosComunsPage.clicarNoBotaoCampoDDIESelecionarOBrasil();
        elementosPessoaFisicaPage.verificarSeMensagemDeErroCPFEstaVisivel();
    }

    @Test
    public void preencherInformacoesDoCampoEmailComDadosInvalidosEVerificarMensagemDeEmailInvalido(){
        elementosComunsPage.preencherCampoNome("NomeTeste");
        elementosComunsPage.preencherCampoSobrenome("SobrenomeTeste");
        elementosPessoaFisicaPage.preencherCampoDataNascimento("23/11/2000");
        elementosPessoaFisicaPage.preencherCampoCpf("04406704701");
        elementosComunsPage.clicarNoBotaoCampoDDIESelecionarOBrasil();
        elementosComunsPage.preencherCampoNumeroDeCelular("51", "985723469");
        elementosComunsPage.preencherCampoEmail("emailtestemailinatorcom");
        elementosComunsPage.preencherCampoConfirmarEmail("emailtestemailinatorcom");
        elementosComunsPage.verificarMensagemDeErroEmail();
    }

}
