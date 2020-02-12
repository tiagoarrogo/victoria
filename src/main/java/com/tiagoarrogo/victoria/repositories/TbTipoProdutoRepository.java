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
import com.tiagoarrogo.victoria.domain.Tb_TipoProduto;

@Repository
public class TbTipoProdutoRepository implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public List<Tb_TipoProduto> findAll() {
		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		SQLQuery query = sessao.createSQLQuery("select tp.cod_prod_tipo, tp.tipo_produto from tb_prod_tipo tp where tp.cod_prod_tipo in (1406,1410,1411,1412,1413,1415,1416,210000007) order by tp.tipo_produto asc");

		@SuppressWarnings("rawtypes")
		List list = query.list();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_TipoProduto> listTpProduto = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_TipoProduto tbTipoProduto = new Tb_TipoProduto();

			tbTipoProduto.setCod_Prod_Tipo(Integer.parseInt(obj[0].toString()));
			tbTipoProduto.setTipo_Produto(obj[1].toString());

			listTpProduto.add(tbTipoProduto);

			

		}
		
		sessao.close();
		
		return listTpProduto;
	}

}
