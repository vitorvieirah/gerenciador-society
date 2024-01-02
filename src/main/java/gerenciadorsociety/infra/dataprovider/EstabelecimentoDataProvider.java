package gerenciadorsociety.infra.dataprovider;

import gerenciadorsociety.domains.Dono;
import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;
import gerenciadorsociety.infra.execptions.DataBaseExecption;
import gerenciadorsociety.infra.mappers.EstabelecimentoMapper;
import gerenciadorsociety.infra.repositorys.EstabelecimentoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
@AllArgsConstructor
@Slf4j
public class EstabelecimentoDataProvider {

    private final EstabelecimentoRepository repository;

    public Estabelecimento salvar (Estabelecimento estab){
        EstabelecimentoEntity estabEntity = EstabelecimentoMapper.paraEntityDeDomain(estab);
        try {
            estabEntity = repository.save(estabEntity);
        }catch (Exception ex){
            log.error("Erro ao salvar Estabelecimento", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return EstabelecimentoMapper.paraDomainDeEntity(estabEntity);
    }

    public List<Estabelecimento> consultarTodos (){
        try {
            return EstabelecimentoMapper.paraDomainsDeEntitys(repository.findAll());
        }catch (Exception ex){
            log.error("Erro ao consultar todos os Estabelecimentos", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }

    public Estabelecimento consultarPorCnpj (String cnpj){
        EstabelecimentoEntity estabEntity = null;
        try{
            estabEntity = repository.getReferenceByCnpj(cnpj);
        }catch (Exception ex){
            log.error("Erro ao consultar Estabelecimento", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
        return EstabelecimentoMapper.paraDomainDeEntity(estabEntity);
    }

    public void deletar (String cnpj){
        try{
            repository.deleteById(cnpj);
        }catch (Exception ex){
            log.error("Erro ao deletar Estabelecimento", ex);
            throw new DataBaseExecption(ex.getMessage());
        }
    }
}
