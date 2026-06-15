function carregarMaterias() {
    const lista = document.getElementById('lista-materias');
    
    // Proteção: se não encontrar o elemento na página, para o script aqui
    if (!lista) return; 

    // Busca as matérias no seu backend Spring Boot
    fetch('http://localhost:8080/materias') 
        .then(response => {
            if (!response.ok) throw new Error('Erro na resposta do servidor');
            return response.json();
        })
        .then(data => {
            lista.innerHTML = ''; // Limpa a lista antes de adicionar
            
            data.forEach(materia => {
                const item = document.createElement('li');
                const link = document.createElement('a');
                
                // Redireciona para a página de listagem de conteúdos daquela matéria
                link.href = `lista-conteudos.html?idmateria=${materia.id}`;
                link.textContent = materia.nome;
                
                item.appendChild(link);
                lista.appendChild(item);
            });
        })
        .catch(error => console.error('Erro ao buscar matérias:', error));
}

// Executa a função ao carregar a página
carregarMaterias();