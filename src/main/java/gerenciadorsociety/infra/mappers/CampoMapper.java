package gerenciadorsociety.infra.mappers;

import gerenciadorsociety.domains.Campo;
import gerenciadorsociety.dtos.CampoDto;
import gerenciadorsociety.infra.entitys.CampoEntity;

import java.util.List;

public abstract class CampoMapper {

    public static Campo paraDomainDeEntity(CampoEntity campoEntity){
        return Campo.builder()
                .id(campoEntity.getId())
                .numero(campoEntity.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeEntity(campoEntity.getEstabelecimento()))
                .build();
    }

    public static CampoEntity paraEntityDeDomain(Campo campo){
        return CampoEntity.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraEntityDeDomain(campo.getEstabelecimento()))
                .build();
    }

    public static CampoDto paraDtoDeDomain(Campo campo){
        return CampoDto.builder()
                .id(campo.getId())
                .numero(campo.getNumero())
                .estabelecimento(EstabelecimentoMapper.paraDtoDeDomain(campo.getEstabelecimento()))
                .build();
    }

    public static Campo paraDomainDeDto(CampoDto campoDto){
        return Campo.builder()
                .id(campoDto.id())
                .numero(campoDto.numero())
                .estabelecimento(EstabelecimentoMapper.paraDomainDeDto(campoDto.estabelecimento()))
                .build();
    }

    public static List<Campo> paraDomainsDeEntitys(List<CampoEntity> campoEntityList){
        return campoEntityList.stream().map(CampoMapper::paraDomainDeEntity).toList();
    }

    public static List<CampoDto> paraDtosDeDomains(List<Campo> campoList){
        return campoList.stream().map(CampoMapper::paraDtoDeDomain).toList();
    }

    public static List<CampoEntity> paraEntitysDeDomains(List<Campo> campoList){
        return campoList.stream().map(CampoMapper::paraEntityDeDomain).toList();
    }

    public static List<Campo> paraDomainsDeDtos(List<CampoDto> campoDtoList){
        return campoDtoList.stream().map(CampoMapper::paraDomainDeDto).toList();
    }
}
