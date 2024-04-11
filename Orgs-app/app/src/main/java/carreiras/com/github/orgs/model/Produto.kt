package carreiras.com.github.orgs.model

import java.math.BigDecimal

// Data class que representa um produto
data class Produto(
    val nome: String,       // Nome do produto
    val descricao: String,  // Descrição do produto
    val valor: BigDecimal   // Valor do produto
)
