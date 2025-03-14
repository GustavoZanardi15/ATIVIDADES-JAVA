package com.produto.produto.controller;

import com.produto.produto.model.ProdutoModel;
import com.produto.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel>listarProduto(){
        return produtoService.ListarProduto();
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> SalvarProduto(@RequestBody ProdutoModel produto){
        ProdutoModel salvarProduto = produtoService.SalvarProduto(produto);
        return ResponseEntity.ok().body(salvarProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> AtualizarProduto(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        ProdutoModel produtoAtualizado = produtoService.AtualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(produtoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeletarProduto(@PathVariable Long id){
        produtoService.DeletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
