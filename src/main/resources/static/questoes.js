function carregarQuestoes() {
    const params = new URLSearchParams(window.location.search);
    const idConteudo = params.get('id');

    if (!idConteudo) return;

    fetch(`http://localhost:8080/questoes/por-conteudo/${idConteudo}`)
        .then(res => res.ok ? res.json() : [])
        .then(listaQuestoes => {
            const container = document.getElementById('container-questoes');
            if (!container) return;
            container.innerHTML = '';
            
            if (listaQuestoes.length === 0) {
                container.innerHTML = '<p>Nenhuma questão disponível.</p>';
                return;
            }

            listaQuestoes.forEach((q, index) => {
                const questaoDiv = document.createElement('div');
                questaoDiv.style = "margin: 20px; padding: 20px; border: 2px solid #4caf50; border-radius: 8px; background: #f1f8e9;";
                
                // Mapeamento corrigido: agora usando 'resposta' e 'resolucao'
                const resposta = q.resposta || "Sem resposta registrada";
                const resolucao = q.resolucao || "Sem resolução detalhada";
                
                questaoDiv.innerHTML = `
                    <h3 style="color: #2e7d32;">Questão ${index + 1}</h3>
                    <p style="font-size: 1.1em;"><strong>Enunciado:</strong> ${q.enunciado}</p>
                    
                    <div style="margin-top: 15px; padding-top: 10px; border-top: 1px dashed #4caf50;">
                        <p><strong>✅ Resposta Correta:</strong> ${resposta}</p>
                        <p><strong>💡 Resolução:</strong> ${resolucao}</p>
                    </div>
                `;
                
                container.appendChild(questaoDiv);
            });
        })
        .catch(err => console.error("Erro:", err));
}

document.addEventListener('DOMContentLoaded', carregarQuestoes);