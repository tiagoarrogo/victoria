package com.tiagoarrogo.victoria.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiagoarrogo.victoria.domain.FiltrosVenda;
import com.tiagoarrogo.victoria.domain.Tb_Vendas;
import com.tiagoarrogo.victoria.repositories.TbVendasRepository;

@Service
public class TbVendasService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private TbVendasRepository repo;

	public List<Tb_Vendas> findAll(FiltrosVenda id) {

		return repo.findAll(id);
	}

	public List<Tb_Vendas> findMonth(FiltrosVenda id) {

		return repo.findMonth(id);
	}

	public List<Tb_Vendas> findDay(FiltrosVenda id) {

		return repo.findDay(id);
	}
	public List<Tb_Vendas> VendaGeral(FiltrosVenda id) {

		return repo.VendaGeral(id);
	}
	public List<Tb_Vendas> rankingMarca(FiltrosVenda id) {

		return repo.rankingMarca(id);
	}
	public List<Tb_Vendas> rankingMultifocal(FiltrosVenda id) {

		return repo.rankingMultifocal(id);
	}
	public List<Tb_Vendas> rankingLentes(FiltrosVenda id) {

		return repo.rankingLentes(id);
	}
	public List<Tb_Vendas> rankingVendedores(FiltrosVenda id) {

		return repo.rankingVendedores(id);
	}
	
	public List<Tb_Vendas> rankingSolarRx(FiltrosVenda id) {

		return repo.rankingSolarRx(id);
	}
	public List<Tb_Vendas> rankingFormaRecebimento(FiltrosVenda id) {

		return repo.rankingFormaRecebimento(id);
	}


}
