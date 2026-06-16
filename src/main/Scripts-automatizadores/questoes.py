import requests
import json

with open('questoes.txt','r',encoding="UTF-8") as f:
    conteudo_do_arquivo = f.read()

partes = conteudo_do_arquivo.split('|')

conteudoId = int(partes[0].split(':')[1].strip())
enunciado = partes[1].split(':')[1].strip()
resolucao = partes[2].split(':')[1].strip()
resposta = partes[3].split(':')[1].strip()

dados = {"conteudoId":conteudoId,"enunciado":enunciado,"resolucao":resolucao,"resposta":resposta}

url ='http://localhost:8080/questoes'
headers = {'Content-Type':'application/json'}

response = requests.post(url,data=json.dumps(dados), headers=headers)

if (response.status_code ==201):
    print("Sucesso ! conteudo cadastrado")
else:
    print(f"Erro: {response.status_code}: {response.text}")