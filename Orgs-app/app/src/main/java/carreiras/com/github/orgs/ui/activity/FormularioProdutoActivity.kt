package carreiras.com.github.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.model.Produto
import java.math.BigDecimal

// Classe responsável pela atividade de formulário de produtos
class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Referência ao botão de salvar
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)

        // Configuração do listener para o clique no botão salvar
        botaoSalvar.setOnClickListener {
            // Referências aos campos de entrada de dados
            val campoNome = findViewById<EditText>(R.id.nome)
            val campoDescricao = findViewById<EditText>(R.id.descricao)
            val campoValor = findViewById<EditText>(R.id.valor)

            // Captura dos valores inseridos nos campos
            val nome = campoNome.text.toString()
            val descricao = campoDescricao.text.toString()
            val valorEmTexto = campoValor.text.toString()

            // Conversão do valor para BigDecimal
            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            // Criação de um novo produto com os dados inseridos
            val produtoNovo = Produto(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            // Log das informações do novo produto
            Log.i("FormularioProduto", "onCreate: $produtoNovo")

            // Instância do DAO de produtos
            val dao = ProdutosDao()
            // Adiciona o novo produto ao banco de dados
            dao.adiciona(produtoNovo)
            // Log dos produtos cadastrados após a adição do novo produto
            Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

            // Finaliza a atividade
            finish()
        }
    }
}
