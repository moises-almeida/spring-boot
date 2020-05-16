package com.produtos.apirest.resource;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*")
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value = "Retorna uma lista com todos os produtos")
    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }

    @ApiOperation(value = "Retorna um produto específico")
    @GetMapping("/produtos/{id}")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    @ApiOperation(value = "Salva o produto")
    @PostMapping("/produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    @ApiOperation(value = "Exclui um produto")
    @DeleteMapping("/produto")
    public void deletaProduto(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    @ApiOperation(value = "Atualiza um produto")
    @PutMapping("/produto")
    public Produto atualizaProduto(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }
}
