package carreiras.com.github.orgs.dao

import carreiras.com.github.orgs.model.Produto

// Classe responsável por manipular os dados de produtos
class ProdutosDao {

    // Método para adicionar um produto à lista de produtos
    fun adiciona(produto: Produto) {
        // Adiciona o produto à lista de produtos
        Companion.produtos.add(produto)
    }

    // Método para buscar todos os produtos
    fun buscaTodos(): List<Produto> {
        // Retorna uma cópia da lista de produtos
        return Companion.produtos.toList()
    }

    // Companion object para manter a lista de produtos de forma estática
    companion object {
        // Lista de produtos, acessível por todos os objetos da classe
        private val produtos = mutableListOf<Produto>()
    }
}
