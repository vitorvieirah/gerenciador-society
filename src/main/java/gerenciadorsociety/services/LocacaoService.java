package gerenciadorsociety.services;

import gerenciadorsociety.domains.Locacao;
import gerenciadorsociety.domains.LocacaoCampo;
import gerenciadorsociety.dtos.LocacaoDto;
import gerenciadorsociety.infra.dataprovider.LocacaoCampoDataProvider;
import gerenciadorsociety.infra.dataprovider.LocacaoChurrasqueiraDataProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LocacaoService {

    private final LocacaoCampoDataProvider locacaoCampoDataProvider;
    private final LocacaoChurrasqueiraDataProvider locacaoChurrasqueiraDataProvider;


    public void cancelar(Long id) {
         Optional<Locacao> locacaoCampo = locacaoCampoDataProvider.buscarPorId(id);
         if (locacaoCampo.isPresent()){
             locacaoCampoDataProvider.deletar(id);
         }else {
             locacaoChurrasqueiraDataProvider.deletar(id);
         }
    }
}
