function carregarVideos() {
    const params = new URLSearchParams(window.location.search);
    const idConteudo = params.get('id');

    if (!idConteudo) {
        console.error("ID do Conteúdo não encontrado na URL!");
        return;
    }

    fetch(`http://localhost:8080/video/por-conteudo/${idConteudo}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro HTTP: " + res.status);
            return res.json();
        })
        .then(listaVideos => {
            const container = document.getElementById('container-video');
            if (!container) return;
            
            container.innerHTML = '';
            
            if (listaVideos.length === 0) {
                container.innerHTML = '<p>Nenhum vídeo disponível para este conteúdo.</p>';
                return;
            }

            // Criamos uma lista de cards simples para os vídeos
            listaVideos.forEach(v => {
                const card = document.createElement('div');
                card.className = 'video-card';
                
                card.innerHTML = `
                    <h3>${v.titulo}</h3>
                    <a href="${v.url}" target="_blank" rel="noopener noreferrer" class="btn-assistir">
                        Assistir Agora
                    </a>
                `;
                
                container.appendChild(card);
            });
        })
        .catch(err => console.error("Erro ao carregar vídeos:", err));
}

carregarVideos();