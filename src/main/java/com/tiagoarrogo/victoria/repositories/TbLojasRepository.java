package com.tiagoarrogo.victoria.repositories;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tiagoarrogo.victoria.config.Config;
import com.tiagoarrogo.victoria.domain.Tb_loja;

@Repository
public class TbLojasRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<Tb_loja> findAll() {
		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createQuery("SELECT t.cod_loja, t.nome_loja FROM tb_loja t order by t.cod_loja asc");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_loja> listLojas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_loja loja = new Tb_loja();

			loja.setLoja(Integer.parseInt(obj[0].toString()));
			loja.setNomeLoja(obj[1].toString());

			listLojas.add(loja);

			

		}
		
		sessao.close();
		
		return listLojas;
		
		
	}
	
	

}
