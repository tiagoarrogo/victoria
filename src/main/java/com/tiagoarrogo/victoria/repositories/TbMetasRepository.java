package com.tiagoarrogo.victoria.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiagoarrogo.victoria.domain.Tb_Metas;

@Repository
public interface TbMetasRepository extends JpaRepository<Tb_Metas, Integer>  {
	
	@Query(value=" SELECT coalesce(sum(valor_Meta),0) as valor_Meta FROM Tb_Metas WHERE extract(month from mes_meta) = extract(month from current_date()) and nome_Loja IN :nomeLoja ", nativeQuery = true)
	public double findMetaGeral(@Param("nomeLoja") List<String> lojas);
	
	
}
