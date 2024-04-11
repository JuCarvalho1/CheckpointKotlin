package carreiras.com.github.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import carreiras.com.github.orgs.R
import carreiras.com.github.orgs.dao.ProdutosDao
import carreiras.com.github.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Classe principal da atividade principal (MainActivity)
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // Método chamado quando a atividade está sendo retomada
    override fun onResume() {
        super.onResume()

        // Referência ao RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // Instância do DAO de produtos
        val dao = ProdutosDao()

        // Log dos produtos cadastrados
        Log.i("FormularioProduto", "onCreate: ${dao.buscaTodos()}")

        // Configuração do adaptador para o RecyclerView
        recyclerView.adapter = ListaProdutosAdapter(
            context = this,
            produtos = dao.buscaTodos()
        )

        // Referência ao FloatingActionButton
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        // Configuração do listener para o clique no FloatingActionButton
        fab.setOnClickListener {
            // Criação de um intent para abrir a atividade de formulário de produtos
            val intent = Intent(this, FormularioProdutoActivity::class.java)
            startActivity(intent) // Inicia a atividade de formulário de produtos
        }
    }
}
