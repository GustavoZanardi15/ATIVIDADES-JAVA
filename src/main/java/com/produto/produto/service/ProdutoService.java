package com.produto.produto.service;

import com.produto.produto.model.ProdutoModel;
import com.produto.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoModel>ListarProduto(){
        return produtoRepository.findAll();
    }

    public ProdutoModel SalvarProduto(ProdutoModel produto){
        return produtoRepository.save(produto);
    }

    public ProdutoModel AtualizarProduto(Long Id, ProdutoModel produto) {
        Optional<ProdutoModel> optionalProdutoModel = produtoRepository.findById(Id);
        if (optionalProdutoModel.isPresent()) {
            ProdutoModel produtoModel = optionalProdutoModel.get();
            produtoModel.setNome(produto.getNome());
            produtoModel.setPreco(produto.getPreco());
            produtoModel.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
            return produtoRepository.save(produtoModel);
        } else {
            return null;
        }
    }


    public void DeletarProduto(Long id){
        produtoRepository.deleteById(id);
    }
}
