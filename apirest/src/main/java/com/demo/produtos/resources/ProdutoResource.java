package com.demo.produtos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.produtos.repository.ProdutoRepository;
import com.demo.produtos.models.Produto;

@RestController
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	public Produto listaProdutoPorId(@PathVariable(value="id") long id) {
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produtos")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	public void deletaProdutoPorId(@PathVariable(value="id") long id) {
		produtoRepository.deleteById(id);
	}
	
	
}
