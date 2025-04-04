package fixture;

import com.tinnova.api.entity.VeiculoEntity;
import com.tinnova.model.Veiculo;
import com.tinnova.model.VeiculoPatch;
import com.tinnova.model.VeiculoSalvo;

import java.time.OffsetDateTime;

public class VeiculoFixture {
    private static final OffsetDateTime dataDeAtualizacao = OffsetDateTime.parse("2018-03-20T09:12:28Z");
    private static final  OffsetDateTime dataDeCadastro = OffsetDateTime.parse("2018-03-20T09:12:28Z");

    public  static VeiculoEntity criarVeiculoEntity(){
        VeiculoEntity veiculoEntity = new VeiculoEntity();
        veiculoEntity.setId(1l);
        veiculoEntity.setVeiculo("Toyota");
        veiculoEntity.setMarca("Corolla");
        veiculoEntity.setDescricao("desc");
        veiculoEntity.setCor("black");
        veiculoEntity.setAno(1999);
        veiculoEntity.setVendido(true);
        veiculoEntity.setCreated(dataDeAtualizacao);
        veiculoEntity.setUpdate(dataDeCadastro);
        return veiculoEntity;


    }


    public  static VeiculoSalvo criarVeiculoSalvo(){
        VeiculoSalvo veiculoSalvo = new VeiculoSalvo();
        veiculoSalvo.setId(1l);
        veiculoSalvo.setVeiculo("Toyota");
        veiculoSalvo.setMarca("Corolla");
        veiculoSalvo.setDescricao("desc");
        veiculoSalvo.setCor("black");
        veiculoSalvo.setAno(1999);
        veiculoSalvo.setVendido(true);
        veiculoSalvo.setCreated(dataDeAtualizacao);
        veiculoSalvo.setUpdate(dataDeCadastro);
        return veiculoSalvo;

    }


    public  static Veiculo criarVeiculo(){
        Veiculo veiculo = new Veiculo();
        veiculo.setVeiculo("Toyota");
        veiculo.setMarca("Corolla");
        veiculo.setDescricao("desc");
        veiculo.setCor("black");
        veiculo.setAno(1999);
        veiculo.setVendido(true);
        veiculo.setCreated(dataDeAtualizacao);
        veiculo.setUpdate(dataDeCadastro);
        return veiculo;

    }

    public  static VeiculoPatch criarVeiculoPatch(){
        VeiculoPatch veiculo = new VeiculoPatch();
        veiculo.setVeiculo("Toyota");
        veiculo.setMarca("Corolla");
        veiculo.setVendido(true);
        veiculo.setUpdate(dataDeCadastro);
        return veiculo;

    }
}
