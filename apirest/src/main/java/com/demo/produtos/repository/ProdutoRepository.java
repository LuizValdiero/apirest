package com.demo.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.produtos.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto ,Long>{

}
