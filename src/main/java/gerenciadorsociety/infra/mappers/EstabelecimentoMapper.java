package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Estabelecimento;
import gerenciadorsociety.dtos.EstabelecimentoDto;
import gerenciadorsociety.infra.entitys.EstabelecimentoEntity;

import java.lang.management.LockInfo;
import java.util.List;

public abstract class EstabelecimentoMapper {

    public static Estabelecimento paraDomainDeEntity(EstabelecimentoEntity estabEntity){
        return Estabelecimento.builder()
                .cnpj(estabEntity.getCnpj())
                .nome(estabEntity.getNome())
                .dono(DonoMapper.paraDomainDeEntity(estabEntity.getDono()))
                .campos(CampoMapper.paraDomainsDeEntitys(estabEntity.getCampos()))
                .churrasqueiras(ChurrasqueiraMapper.paraDomainsDeEntitys(estabEntity.getChurrasqueiras()))
                .valorHora(estabEntity.getValorHora())
                .build();
    }

    public static EstabelecimentoEntity paraEntityDeDomain(Estabelecimento estabelecimento){
        return EstabelecimentoEntity.builder()
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraEntityDeDomain(estabelecimento.getDono()))
                .campos(CampoMapper.paraEntitysDeDomains(estabelecimento.getCampos()))
                .churrasqueiras(ChurrasqueiraMapper.paraEntitysDeDomains(estabelecimento.getChurrasqueiras()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static Estabelecimento paraDomainDeDto(EstabelecimentoDto estabelecimentoDto){
        return Estabelecimento.builder()
                .cnpj(estabelecimentoDto.cnpj())
                .nome(estabelecimentoDto.nome())
                .dono(DonoMapper.paraDomainDeDto(estabelecimentoDto.dono()))
                .campos(CampoMapper.paraDomainsDeDtos(estabelecimentoDto.campos()))
                .churrasqueiras(ChurrasqueiraMapper.paraDomainsDeDtos(estabelecimentoDto.churrasqueiras()))
                .valorHora(estabelecimentoDto.valorHora())
                .build();
    }

    public static EstabelecimentoDto paraDtoDeDomain(Estabelecimento estabelecimento){
        return EstabelecimentoDto.builder()
                .cnpj(estabelecimento.getCnpj())
                .nome(estabelecimento.getNome())
                .dono(DonoMapper.paraDtoDeDomain(estabelecimento.getDono()))
                .campos(CampoMapper.paraDtosDeDomains(estabelecimento.getCampos()))
                .churrasqueiras(ChurrasqueiraMapper.paraDtosDeDomains(estabelecimento.getChurrasqueiras()))
                .valorHora(estabelecimento.getValorHora())
                .build();
    }

    public static List<Estabelecimento> paraDomainsDeEntitys(List<EstabelecimentoEntity> estabEntityList){
        return estabEntityList.stream().map(EstabelecimentoMapper::paraDomainDeEntity).toList();
    }

    public static List<EstabelecimentoDto> paraDtosDeDomains(List<Estabelecimento> estabelecimentoList){
        return estabelecimentoList.stream().map(EstabelecimentoMapper::paraDtoDeDomain).toList();
    }
}