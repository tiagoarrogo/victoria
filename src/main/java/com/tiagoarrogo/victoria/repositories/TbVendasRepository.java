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
import com.tiagoarrogo.victoria.domain.FiltrosVenda;
import com.tiagoarrogo.victoria.domain.Tb_Vendas;

@Repository
public class TbVendasRepository implements Serializable {
	private static final long serialVersionUID = 1L;

	public List<Tb_Vendas> findAll(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createQuery("select A.LOJA, D.NOME_LOJA, extract(Year from A.dt_venda) as Ano,"
				+ "  					     sum((coalesce(B.QTDE, 0) * coalesce(B.UNITARIO, 0) - coalesce(B.DESC2, 0)) * iif(B.COD_ITEM_VEN_DEVOLUCAO = 0, 1, -1)) as TOTAL"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0"
				+ "							 and extract(Year from A.dt_venda) in(" + id.getAnos() + ")"
				+ "						     and a.loja in (" + id.getLojas() + ")"
				+ " 						 group by A.LOJA, D.NOME_LOJA, Ano order by Loja, Ano Asc");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setLoja(Integer.parseInt(obj[0].toString()));
			venda.setNomeLoja(obj[1].toString());
			venda.setAnoVenda(obj[2].toString());
			venda.setTotal(Double.parseDouble(obj[3].toString()));

			listVendas.add(venda);

		}

			
		return listVendas;

	}

	public List<Tb_Vendas> findMonth(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createQuery(
				"select A.LOJA, D.NOME_LOJA, (extract(month from A.dt_venda) ||'.' || extract(year from A.dt_venda))as mes,"
						+ "       sum((coalesce(B.QTDE, 0) * coalesce(B.UNITARIO, 0) - coalesce(B.DESC2, 0)) * iif(B.COD_ITEM_VEN_DEVOLUCAO = 0, 1, -1)) as TOTAL"
						+ "  from TB_VENDAS A" + "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
						+ "       A.LOJA = B.LOJA)" + "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO)"
						+ "  left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0"
						+ " and extract (month from A.dt_venda) in(" + id.getMeses()
						+ ") and extract(Year from A.dt_venda) in(" + id.getAnos() + ") and a.loja in (" + id.getLojas()
						+ ")" + " group by A.LOJA, D.NOME_LOJA, mes  order by A.LOJA, mes");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setLoja(Integer.parseInt(obj[0].toString()));
			venda.setNomeLoja(obj[1].toString());
			venda.setAnoVenda(obj[2].toString());
			venda.setTotal(Double.parseDouble(obj[3].toString()));

			listVendas.add(venda);

		}
	

		return listVendas;

	}

	public List<Tb_Vendas> findDay(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();
		

		Query query = sessao.createSQLQuery(
				" SELECT A.LOJA, D.NOME_LOJA, (extract(day from A.dt_venda) ||'.' || extract(month from A.dt_venda) ||'.' || extract(year from A.dt_venda)) as dia, A.dt_venda,"
						+ "       sum((coalesce(B.QTDE, 0) * coalesce(B.UNITARIO, 0) - coalesce(B.DESC2, 0)) * iif(B.COD_ITEM_VEN_DEVOLUCAO = 0, 1, -1)) as TOTAL"
						+ "  from TB_VENDAS A" + "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
						+ "       A.LOJA = B.LOJA)" + "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO)"
						+ "  left join TB_LOJA D on (D.COD_LOJA = A.LOJA)"
						+ " where A.FLG_CANCELA = 0 and extract (day from A.dt_venda) in(" + id.getDias()
						+ ") and extract (month from A.dt_venda) in(" + id.getMeses()
						+ ") and extract(Year from A.dt_venda) in(" + id.getAnos() + ") and a.loja in (" + id.getLojas()
						+ ")"
						+ " group by A.loja, Dia, D.nome_loja, A.dt_venda order by extract(day from A.dt_venda) asc");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setLoja(Integer.parseInt(obj[0].toString()));
			venda.setNomeLoja(obj[1].toString());
			venda.setAnoVenda(obj[2].toString());
			venda.setTotal(Double.parseDouble(obj[4].toString()));

			listVendas.add(venda);

		}
		
		

		return listVendas;

	}
	
	public List<Tb_Vendas> VendaGeral(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT extract (month from A.dt_venda) || '/' || extract (year from A.dt_venda) as mes, CAST(sum((coalesce(B.QTDE, 0) * coalesce(B.UNITARIO, 0) - coalesce(B.DESC2, 0)) * iif(B.COD_ITEM_VEN_DEVOLUCAO = 0, 1, -1)) AS numeric(8,2)) as TOTAL"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0"
				+ "							 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "						     and D.nome_loja in (" + id.getLojas() + ") group by 1");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setAnoVenda(obj[0].toString());
			venda.setTotal(Double.parseDouble(obj[1].toString()));

			listVendas.add(venda);

		}
		
		

		return listVendas;

	}
	
	public List<Tb_Vendas> rankingMarca(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT  m.marca_produto, cast(sum(b.qtde) as integer) qtde"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO) left join tb_prod_marca m on (C.cod_prod_marca = m.cod_prod_marca)" 
				+ "left join tb_prod_tipo t on (C.cod_prod_tipo = t.cod_prod_tipo)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0 and t.tipo_produto containing('ARMAÇÃO')"
				+ "							 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "						     and D.nome_loja in (" + id.getLojas() + ") group by m.marca_produto order by qtde desc , m.marca_produto");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setProd_Marca(obj[0].toString());
			venda.setTotal(Double.parseDouble(obj[1].toString()));

			listVendas.add(venda);

		}
		
		
		return listVendas;

	}
	
	public List<Tb_Vendas> rankingMultifocal(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT  m.marca_produto, cast(sum(b.qtde) as integer) qtde"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO) left join tb_prod_marca m on (C.cod_prod_marca = m.cod_prod_marca)" 
				+ "left join tb_prod_tipo t on (C.cod_prod_tipo = t.cod_prod_tipo)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0 and t.tipo_produto containing('SURFAÇADAS')"
				+ "							 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "						     and D.nome_loja in (" + id.getLojas() + ") group by m.marca_produto order by qtde desc , m.marca_produto");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setProd_Marca(obj[0].toString());
			venda.setTotal(Double.parseDouble(obj[1].toString()));

			listVendas.add(venda);

		}
		
		

		return listVendas;

	}
	
	public List<Tb_Vendas> rankingLentes(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT  m.marca_produto, cast(sum(b.qtde) as integer) qtde"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO) left join tb_prod_marca m on (C.cod_prod_marca = m.cod_prod_marca)" 
				+ "left join tb_prod_tipo t on (C.cod_prod_tipo = t.cod_prod_tipo)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0 and t.tipo_produto in ('LENTE PROFISSIONAL','LENTE PRONTA', 'LENTE SOLAR', 'LENTES BIFOCAIS')"
				+ "							 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "						     and D.nome_loja in (" + id.getLojas() + ") group by m.marca_produto order by qtde desc , m.marca_produto");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setProd_Marca(obj[0].toString());
			venda.setTotal(Double.parseDouble(obj[1].toString()));

			listVendas.add(venda);

		}
		
		
		return listVendas;

	}
	
	
	public List<Tb_Vendas> rankingVendedores(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT substring(f.funcionario from 1 for 30) as nomeCompleto, sum(A.total) as total, count(A.cod_venda) as qtdeVenda, (sum(A.total) / count(A.cod_venda)) as ticketMedio"
				+ "  						 from TB_VENDAS A"
				+ "  left join tb_funcionario f on (A.cod_vendedor = f.cod_funcionario)"
				+ "  left join TB_LOJA D on (D.COD_LOJA = A.LOJA)"				
				+ "  where A.FLG_CANCELA = 0 "
				+ "	 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "	 and D.nome_loja in (" + id.getLojas() + ") group by nomeCompleto order by total desc, nomeCompleto");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();
			
			venda.setVendedor(obj[0].toString());			
			venda.setTotal(Double.parseDouble(obj[1].toString()));
			venda.setQtdeVenda(Integer.parseInt(obj[2].toString()));
			venda.setTicketMedio(Double.parseDouble(obj[3].toString()));

			listVendas.add(venda);

		}
		
		

		return listVendas;

	}

	
	public List<Tb_Vendas> rankingSolarRx(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT  t.tipo_produto, cast(sum(b.qtde) as integer) qtde"
				+ "  						 from TB_VENDAS A"
				+ "  left join TB_ITENS_VEN B on (A.COD_VENDA = B.COD_VENDA and"
				+ "  				         A.LOJA = B.LOJA)"
				+ "  left join TB_PRODUTO C on (B.COD_ITEM = C.COD_PRODUTO) left join tb_prod_marca m on (C.cod_prod_marca = m.cod_prod_marca)" 
				+ "left join tb_prod_tipo t on (C.cod_prod_tipo = t.cod_prod_tipo)"
				+ "                          left join TB_LOJA D on (D.COD_LOJA = A.LOJA)" + " where A.FLG_CANCELA = 0 and t.tipo_produto in('ARMAÇÃO ROX', 'ARMAÇÃO RX', 'ARMAÇÃO SOLAR', 'ARMAÇÃO SOLAR LINEA', 'ARMAÇÃO SOLAR MY', 'ARMAÇÃO SOLAR RP', 'SOLAR ROX')"
				+ "							 and extract (month from A.dt_venda)  = extract (month from current_date) and extract(Year from A.dt_venda) = extract (year from current_date)"
				+ "						     and D.nome_loja in (" + id.getLojas() + ") group by t.tipo_produto order by qtde desc , t.tipo_produto");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setProd_Marca(obj[0].toString());
			venda.setQtdeVenda(Integer.parseInt(obj[1].toString()));

			listVendas.add(venda);

		}

		
		
		
		return listVendas;

	}
	
	public List<Tb_Vendas> rankingFormaRecebimento(FiltrosVenda id) {

		SessionFactory sessionFacoty = Config.getSessionFactory();
		Session sessao = sessionFacoty.openSession();

		Query query = sessao.createSQLQuery("SELECT coalesce(D.pgto_fantasia ||' '|| D.parcelas ||'X',B.forma) as Forma, COUNT(B.COD_RECTO) / coalesce(D.PARCELAS,1) AS qtdeVenda, SUM( COALESCE(B.ORIGINAL, 0) ) AS TotOrig, SUM( COALESCE(B.TOTAL, 0) ) AS Total, SUM(((COALESCE(B.ORIGINAL, 0) - COALESCE(B.TOTAL, 0)))) AS TAXA"
				+ "  						 FROM TB_RECEBER A"
				+ "  INNER JOIN TB_ITENS_RC B ON ( A.COD_RECTO = B.COD_RECTO )"
				+ "  				         LEFT JOIN TB_FORMA_RECTO D ON ( D.PAGAMENTO = B.FORMA )"
				+ "  LEFT JOIN TB_VENDAS V ON (V.COD_VENDA = A.COD_VENDA) left join TB_LOJA l on (L.COD_LOJA = A.LOJA)" 
				
				
				+ "							 where extract (month from B.DT_ENTRADA)  = extract (month from current_date) and extract(Year from B.DT_ENTRADA) = extract (year from current_date)"
				+ "						     and L.nome_loja in (" + id.getLojas() + ") GROUP BY Forma, D.parcelas order by qtdeVenda desc");

		@SuppressWarnings("rawtypes")
		List list = query.getResultList();

		@SuppressWarnings("rawtypes")
		Iterator itr = list.iterator();

		List<Tb_Vendas> listVendas = new ArrayList<>();

		while (itr.hasNext()) {

			Object[] obj = (Object[]) itr.next();
			Tb_Vendas venda = new Tb_Vendas();

			venda.setProd_Marca(obj[0].toString());
			venda.setQtdeVenda(Integer.parseInt(obj[1].toString()));
			venda.setTotalOriginal(Double.parseDouble(obj[3].toString()));
			venda.setTotal(Double.parseDouble(obj[4].toString()));
			venda.setTicketMedio(Double.parseDouble(obj[3].toString()));
			listVendas.add(venda);

		}
		
		

		return listVendas;

	}

}
