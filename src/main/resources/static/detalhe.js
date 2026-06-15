function configurarBotao(btnId, url) {
    const btn = document.getElementById(btnId);
    if (btn) {
        btn.href = url;
        btn.style.display = 'inline-block';
    }
}

function carregarDetalhes(idConteudo) {
    console.log("DEBUG: Chamando URL:", `http://localhost:8080/conteudo/${idConteudo}`);
    
    fetch(`http://localhost:8080/conteudo/${idConteudo}`)
        .then(response => {
            console.log("DEBUG: Status da resposta:", response.status);
            if (!response.ok) throw new Error("Erro HTTP: " + response.status);
            return response.text(); 
        })
        .then(texto => {
            console.log("DEBUG: Conteúdo bruto recebido:", texto);
            if (!texto) throw new Error("O servidor retornou uma resposta vazia!");
            return JSON.parse(texto);
        })
        .then(data => {
            // Preenche os dados na tela
            const titulo = document.getElementById('conteudo-titulo');
            const texto = document.getElementById('conteudo-texto');
            const formula = document.getElementById('conteudo-formula');

            if (titulo) titulo.textContent = data.titulo || "Título";
            if (texto) texto.textContent = data.texto || "Conteúdo";
            if (formula) formula.textContent = data.formula || "";

            // Configura os botões de navegação
            configurarBotao('link-videos', `video.html?id=${idConteudo}`);
            configurarBotao('link-links', `link.html?id=${idConteudo}`);
            configurarBotao('link-questoes', `questoes.html?id=${idConteudo}`);
        })
        .catch(err => console.error("ERRO DETECTADO:", err));
}

// O GATILHO: Este bloco garante que a função carregarDetalhes seja chamada
document.addEventListener('DOMContentLoaded', () => {
    const params = new URLSearchParams(window.location.search);
    const id = params.get('id');

    if (id) {
        console.log("DEBUG: ID capturado, iniciando carregamento:", id);
        carregarDetalhes(id);
    } else {
        console.error("ERRO: Nenhum ID de conteúdo encontrado na URL!");
    }
});