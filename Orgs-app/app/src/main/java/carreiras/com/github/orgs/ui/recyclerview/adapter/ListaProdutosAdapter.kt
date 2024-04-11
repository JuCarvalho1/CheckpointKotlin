package carreiras.com.github.orgs.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.model.Produto

// Adaptador para exibir a lista de produtos em um RecyclerView
class ListaProdutosAdapter(
    private val context: Context,  // Contexto da aplicação
    private val produtos: List<Produto>  // Lista de produtos a ser exibida
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    // ViewHolder que contém as referências aos elementos da interface do item de produto
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // Método para vincular os dados do produto aos elementos da interface
        fun vincula(produto: Produto) {
            // Referência ao TextView para exibir o nome do produto
            val nome = itemView.findViewById<TextView>(R.id.nome)
            // Define o texto do nome do produto
            nome.text = produto.nome

            // Referência ao TextView para exibir a descrição do produto
            val descricao = itemView.findViewById<TextView>(R.id.descricao)
            // Define o texto da descrição do produto
            descricao.text = produto.descricao

            // Referência ao TextView para exibir o valor do produto
            val valor = itemView.findViewById<TextView>(R.id.valor)
            // Define o texto do valor do produto
            valor.text = produto.valor.toPlainString()
        }
    }

    // Método chamado quando o ViewHolder é criado
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaProdutosAdapter.ViewHolder {
        // Infla o layout do item de produto
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ListaProdutosAdapter.ViewHolder(view)
    }

    // Retorna o número total de itens na lista de produtos
    override fun getItemCount(): Int = produtos.size

    // Método chamado para exibir os dados do produto em uma posição específica
    override fun onBindViewHolder(holder: ListaProdutosAdapter.ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }
}
