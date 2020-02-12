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
import com.tiagoarrogo.victoria.domain.Tb_Produtos;

@Repository
public class TbProdutoRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<Tb_Produtos> findAll(String marcaCodigo, Integer marcaTpProduto) {
		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		String queryStr;

		if (marcaTpProduto == 0) {
			
			queryStr = " select coalesce(tp.cod_produto,'') as cod_produto , coalesce(tp.descricao,'') as descricao , coalesce(u.unidade,'') as unidade, coalesce(tp.preco_ven,0), coalesce(tp.valor_bonus, 0) as valor_bonus from tb_produto tp"
					+ "   inner join tb_prod_un u on tp.cod_un = u.cod_un \r\n" +

					"where tp.cod_prod_tipo in ( 1406,1410,1411,1412,1413,1415,1416,210000007) \r\n" +

					"  and tp.flg_ativo = 1 order by tp.descricao asc";

		} else {

			queryStr = " select coalesce(tp.cod_produto,'') as cod_produto , coalesce(tp.descricao,'') as descricao , coalesce(u.unidade,'') as unidade, coalesce(tp.preco_ven,0), coalesce(tp.valor_bonus, 0) as valor_bonus from tb_produto tp"
					+ "   inner join tb_prod_un u on tp.cod_un = u.cod_un \r\n" +

					"where tp.cod_prod_marca =" + marcaCodigo + "  \r\n" +

					"  and tp.cod_prod_tipo = " + marcaTpProduto + " \r\n" +

					"  and tp.flg_ativo = 1 \r\n" + "  order by tp.descricao asc";

		}

		SQLQuery query = sessao.createSQLQuery(queryStr);

		@SuppressWarnings("rawtypes")
		List list = query.list();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Produtos> listProdutos = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Produtos tbProduto = new Tb_Produtos();

			tbProduto.setCod_produto(obj[0].toString());
			tbProduto.setDescricao(obj[1].toString());
			tbProduto.setUnidade(obj[2].toString());
			tbProduto.setPreco_ven(obj[3].toString());
			tbProduto.setValor_bonus(obj[4].toString());

			listProdutos.add(tbProduto);

		}
		
		sessao.close();
		
		return listProdutos;
	}

}
