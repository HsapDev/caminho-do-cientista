document.addEventListener("DOMContentLoaded", () => {
    
    // --- LÓGICA DA LISTA ---
    const container = document.querySelector('#lista-conteudos ul');
    if (container) {
        fetch('http://localhost:8080/materias')
            .then(res => res.json())
            .then(dados => {
                container.innerHTML = ""; 
                dados.forEach(item => {
                    const li = document.createElement('li');
                    li.innerHTML = `<a href="conteudo-detalhe.html?id=${item.id}">${item.nome}</a>`;
                    container.appendChild(li);
                });
            })
            .catch(err => console.log("Erro na lista:", err));
    }

    // --- LÓGICA DO DETALHE (AQUI É ONDE ESTAVA O ERRO DE JSON) ---
    const urlParams = new URLSearchParams(window.location.search);
    const id = urlParams.get('id');
    const titulo = document.getElementById('titulo-assunto');

    if (id && titulo) {
        fetch(`http://localhost:8080/conteudo/${id}`)
            .then(res => {
                if (res.status === 200) return res.json();
                else throw new Error("Servidor não retornou dados");
            })
            .then(conteudo => {
                // Preenchimento manual dos dados
                titulo.textContent = conteudo.nome;
                const desc = document.querySelector('#texto-explicativo p');
                if (desc) desc.textContent = conteudo.descricao;
            })
            .catch(err => {
                console.error("Erro no detalhe:", err);
                titulo.textContent = "Erro ao carregar conteúdo!";
            });
    }
});