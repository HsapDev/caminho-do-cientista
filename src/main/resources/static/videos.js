// 1. Função que faz o trabalho sujo
function carregarVideos() {
    const params = new URLSearchParams(window.location.search);
    const idConteudo = params.get('id');

    if (!idConteudo) {
        console.error("ID do Conteúdo não encontrado na URL!");
        return;
    }

    console.log("DEBUG: Buscando vídeos para o conteúdo:", idConteudo);

    fetch(`http://localhost:8080/video/por-conteudo/${idConteudo}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro HTTP: " + res.status);
            return res.json();
        })
        .then(listaVideos => {
            const container = document.getElementById('container-video');
            if (!container) {
                console.error("ERRO: Elemento 'container-videos' não encontrado no HTML!");
                return;
            }
            
            container.innerHTML = '';
            
            if (listaVideos.length === 0) {
                container.innerHTML = '<p>Nenhum vídeo disponível para este conteúdo.</p>';
                return;
            }

            listaVideos.forEach(v => {
                container.innerHTML += `
                    <div>
                        <h3>${v.titulo}</h3>
                        <iframe src="${v.url}" width="300" height="200"></iframe>
                    </div>`;
            });
        })
        .catch(err => console.error("Erro ao carregar vídeos:", err));
}

// 2. O gatilho: Só roda quando o HTML estiver pronto
document.addEventListener('DOMContentLoaded', carregarVideos);