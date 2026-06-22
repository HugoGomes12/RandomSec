package com.example.randomsec

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvTopic: TextView
    private lateinit var tvSubTopic: TextView
    private lateinit var tvCount: TextView

    private val studiedTopics = mutableListOf<String>()
    private var currentTopic = ""
    private var currentSubTopic = ""
    private val random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar views
        tvTopic = findViewById(R.id.tvTopic)
        tvSubTopic = findViewById(R.id.tvSubTopic)
        tvCount = findViewById(R.id.tvCount)

        val btnSortear = findViewById<Button>(R.id.btnSortear)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnHistory = findViewById<Button>(R.id.btnHistory)
        val btnSave = findViewById<Button>(R.id.btnSave)

        // Atualizar contador
        updateCount()

        // Listeners
        btnSortear.setOnClickListener { sortearTopico() }
        btnReset.setOnClickListener { resetarTopicos() }
        btnHistory.setOnClickListener { mostrarHistorico() }
        btnSave.setOnClickListener { salvarTopico() }
    }

    private fun sortearTopico() {
        val topico = StudyTopics.topics.random()
        val subTopicos = StudyTopics.subtopics[topico] ?: emptyList()
        val subTopico = if (subTopicos.isNotEmpty()) subTopicos.random() else ""

        currentTopic = topico
        currentSubTopic = subTopico

        tvTopic.text = topico
        tvSubTopic.text = if (subTopico.isNotEmpty()) "↳ $subTopico" else ""

        // Efeito visual com ScaleAnimation (corrigido)
        val anim = ScaleAnimation(
            0.8f, 1.0f,
            0.8f, 1.0f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        anim.duration = 200
        tvTopic.startAnimation(anim)
    }

    private fun resetarTopicos() {
        AlertDialog.Builder(this)
            .setTitle("🔄 Resetar")
            .setMessage("Deseja limpar todos os tópicos estudados?")
            .setPositiveButton("Sim") { _, _ ->
                studiedTopics.clear()
                updateCount()
                tvTopic.text = "Clique em 🔀 Sortear"
                tvSubTopic.text = ""
                Toast.makeText(this, "Histórico limpo!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Não", null)
            .show()
    }

    private fun salvarTopico() {
        if (currentTopic.isEmpty()) {
            Toast.makeText(this, "Primeiro, sorteie um tópico!", Toast.LENGTH_SHORT).show()
            return
        }

        val topicoSalvar = if (currentSubTopic.isNotEmpty()) {
            "$currentTopic - $currentSubTopic"
        } else {
            currentTopic
        }

        if (studiedTopics.contains(topicoSalvar)) {
            Toast.makeText(this, "⚠️ Tópico já foi estudado!", Toast.LENGTH_SHORT).show()
        } else {
            studiedTopics.add(topicoSalvar)
            updateCount()
            Toast.makeText(this, "✅ $topicoSalvar salvo!", Toast.LENGTH_LONG).show()
        }
    }

    private fun mostrarHistorico() {
        if (studiedTopics.isEmpty()) {
            Toast.makeText(this, "Nenhum tópico estudado ainda!", Toast.LENGTH_SHORT).show()
            return
        }

        val historico = studiedTopics.joinToString("\n\n")

        AlertDialog.Builder(this)
            .setTitle("📋 Histórico de Estudos")
            .setMessage(historico)
            .setPositiveButton("OK", null)
            .show()
    }

    private fun updateCount() {
        tvCount.text = "${studiedTopics.size}/${StudyTopics.topics.size}"
    }
}