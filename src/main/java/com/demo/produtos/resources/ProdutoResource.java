package com.demo.produtos.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.produtos.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.demo.produtos.error.ResourceNotFoundException;
import com.demo.produtos.models.Produto;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	private void verifyIfStudentExists(long id) {
		if (produtoRepository.findById(id) == null)
			throw new ResourceNotFoundException("Produto não encontrado.");
	}
	
	@GetMapping("/produtos")
	@ApiOperation(value="Retorna uma lista de produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="Retorna produto pelo Id.")
	public Produto listaProdutoPorId(@PathVariable(value="id") long id) {
		verifyIfStudentExists(id);
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="adiciona produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}

	@DeleteMapping("/produtos")
	@ApiOperation(value="delete produto")
	public void deletaProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	@DeleteMapping("/produtos/{id}")
	@ApiOperation(value="delete produto pelo Id")
	public void deletaProdutoPorId(@PathVariable(value="id") long id) {
		verifyIfStudentExists(id);
		produtoRepository.deleteById(id);
	}

	@PutMapping("/produtos ")
	@ApiOperation(value="Altera produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		verifyIfStudentExists(produto.getId());
		return produtoRepository.save(produto);
	}
}
