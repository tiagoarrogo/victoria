package com.tiagoarrogo.victoria.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoarrogo.victoria.domain.FiltrosVenda;
import com.tiagoarrogo.victoria.domain.Tb_Vendas;
import com.tiagoarrogo.victoria.services.TbVendasService;

@RestController
@RequestMapping(value = "vendas")
public class TbVendasResource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private TbVendasService service;
	
	@RequestMapping(value = "/anos", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> findAll(@RequestParam(value="Anos", defaultValue="")String anos,													
													@RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		
		FiltrosVenda obj = new FiltrosVenda(null, lojas, anos,null);
		
		List<Tb_Vendas> list = service.findAll(obj);
		return ResponseEntity.ok().body(list);		
		
		
	}
	
	@RequestMapping(value ="/dias", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> findDay(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.findDay(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	
	@RequestMapping(value ="/mes", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> findMes(@RequestParam(value = "mesinicial", defaultValue = "")String mesInicial,
													 @RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(null, lojas, anos, mesInicial);
		
		List<Tb_Vendas> list = service.findMonth(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	
	@RequestMapping(value ="/vendageral", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> vendaGeral(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.VendaGeral(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	@RequestMapping(value ="/rankingmarca", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingMarca(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingMarca(obj);
		return ResponseEntity.ok().body(list);	
		
	}

	@RequestMapping(value ="/rankingmultifocal", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingMultifocal(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingMultifocal(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	@RequestMapping(value ="/rankinglentes", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingLentes(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingLentes(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	@RequestMapping(value ="/rankingvendedor", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingVendedores(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingVendedores(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	
	@RequestMapping(value ="/rankingsolarrx", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingSolarRx(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingSolarRx(obj);
		return ResponseEntity.ok().body(list);	
		
	}
	@RequestMapping(value ="/rankingformarecebimento", method = RequestMethod.GET)
	public ResponseEntity<List<Tb_Vendas>> rankingFormaRecebimento(@RequestParam(value = "anos", defaultValue = "")String anos,
													 @RequestParam(value = "meses", defaultValue = "")String meses,
													 @RequestParam(value = "dias", defaultValue = "")String dias,
													 @RequestParam(value = "lojas", defaultValue = "")String lojas){
		
		FiltrosVenda obj = new FiltrosVenda(dias, lojas, anos, meses);
		
		List<Tb_Vendas> list = service.rankingFormaRecebimento(obj);
		return ResponseEntity.ok().body(list);	
		
	}

}
