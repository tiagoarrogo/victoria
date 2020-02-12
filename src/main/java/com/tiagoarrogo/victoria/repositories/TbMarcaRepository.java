package com.tiagoarrogo.victoria.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tiagoarrogo.victoria.config.Config;
import com.tiagoarrogo.victoria.domain.Tb_Marca;


@Repository
public class TbMarcaRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	public List<Tb_Marca> findAll(Integer id) {
		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		SQLQuery query = sessao.createSQLQuery("select distinct m.cod_prod_marca, m.marca_produto from tb_produto tp\r\n" + 
				"inner join tb_prod_marca m on tp.cod_prod_marca = m.cod_prod_marca\r\n" + 
				"where tp.cod_prod_tipo in ("+ id + ") and tp.flg_ativo = 1  \r\n" + 
				"order by m.cod_prod_marca asc");

		@SuppressWarnings("rawtypes")
		List list = query.list();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Marca> listMarca = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Marca tbMarca = new Tb_Marca();

			tbMarca.setCod_Prod_Marca(Integer.parseInt(obj[0].toString()));
			tbMarca.setMarca_Produto(obj[1].toString());

			listMarca.add(tbMarca);

			

		}
		sessao.close();
		
		return listMarca;
	}

}
