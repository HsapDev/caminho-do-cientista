function carregarLinks() {
    const params = new URLSearchParams(window.location.search);
    const idConteudo = params.get('id');

    if (!idConteudo) {
        console.error("ID do Conteúdo não encontrado na URL!");
        return;
    }

    console.log("DEBUG: Buscando links para o conteúdo:", idConteudo);

    // O endpoint aqui é o de links, filtrado por conteúdo
    fetch(`http://localhost:8080/link/por-conteudo/${idConteudo}`)
        .then(res => {
            if (!res.ok) throw new Error("Erro HTTP: " + res.status);
            return res.json();
        })
        .then(listaLinks => {
            // ID do container no seu link.html deve ser "container-links"
            const container = document.getElementById('container-links');
            if (!container) {
                console.error("ERRO: Elemento 'container-links' não encontrado no HTML!");
                return;
            }
            
            container.innerHTML = '';
            
            if (listaLinks.length === 0) {
                container.innerHTML = '<p>Nenhum link disponível para este conteúdo.</p>';
                return;
            }

            listaLinks.forEach(l => {
                container.innerHTML += `
                    <li>
                        <a href="${l.url}" target="_blank">${l.titulo}</a>
                    </li>`;
            });
        })
        .catch(err => console.error("Erro ao carregar links:", err));
}

document.addEventListener('DOMContentLoaded', carregarLinks);