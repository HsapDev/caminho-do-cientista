function carregarListaConteudo() {
    const params = new URLSearchParams(window.location.search);
    const idMateria = params.get('idmateria');
    const lista = document.querySelector('#lista-conteudos ul');

    if (!lista) return;

    if (!idMateria) {
        console.warn("⚠️ Nenhum idmateria encontrado na URL. A URL está correta?");
        return;
    }

    // URL com logs para você ver o que está acontecendo
    const urlBusca = `http://localhost:8080/conteudo/por-materia/${idMateria}`;
    console.log("🔍 Buscando em:", urlBusca);

    fetch(urlBusca)
        .then(res => {
            // Se o servidor devolver 404 ou 500, o fetch não entra no .then(data)
            if (!res.ok) throw new Error("Erro HTTP: " + res.status);
            return res.json();
        })
        .then(data => {
            console.log("✅ Dados recebidos com sucesso:", data);
            lista.innerHTML = '';
            
            if (data.length === 0) {
                lista.innerHTML = '<li>Nenhum conteúdo encontrado.</li>';
                return;
            }

            data.forEach(item => {
                console.log("DEBUG - Item atual:", item);
                const li = document.createElement('li');
                const a = document.createElement('a');
                // O item.id aqui é OBRIGATÓRIO ser o id do Conteúdo vindo do Java
                a.textContent = item.titulo;                a.href = `conteudo-detalhe.html?id=${item.id}`; 

                li.appendChild(a);
                lista.appendChild(li);
            });
        })
        .catch(err => {
            console.error("❌ Erro no fetch (verifique o Controller Java):", err);
            lista.innerHTML = '<li>Erro ao carregar lista. Verifique o console.</li>';
        });
}

carregarListaConteudo();