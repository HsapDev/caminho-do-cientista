import requests
import json

with open('dados.txt','r', encoding='UTF-8') as f:
    conteudo_do_arquivo =f.read()

partes = conteudo_do_arquivo.split(',')

nome = partes[0].split(':')[1].strip()
descricao = partes[1].split(':')[1].strip()

dados = {"nome":nome,"descricao":descricao}

url = "http://localhost:8080/materias"
headers = {'Content-Type':'application/json'}

response = requests.post(url,data=json.dumps(dados), headers=headers)

if (response.status_code ==200):
    print("Sucesso ! conteudo cadastrado")
else:
    print(f"Errp {response.status_code}: {response.text}")