import requests
import json

with open('conteudo.txt','r', encoding='UTF-8') as f:
    conteudo_do_arquivo =f.read()

partes = conteudo_do_arquivo.split('|')

materiaId = int(partes[0].split(':')[1].strip())
titulo = partes[1].split(':')[1].strip()
texto = partes[2].split(':')[1].strip()
formula = partes[3].split(':')[1].strip()

dados = {"materiaId":materiaId,"titulo":titulo,"texto":texto,"formula":formula}

url = "http://localhost:8080/conteudo"
headers = {'Content-Type':'application/json'}

response = requests.post(url,data=json.dumps(dados), headers=headers)

if (response.status_code ==201):
    print("Sucesso ! conteudo cadastrado")
else:
    print(f"Erro: {response.status_code}: {response.text}")