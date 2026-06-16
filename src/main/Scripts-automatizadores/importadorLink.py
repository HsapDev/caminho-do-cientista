import requests
import json

with open('link.txt','r',encoding="UTF-8") as f:
    conteudo_do_arquivo = f.read()

partes = conteudo_do_arquivo.split('|')

print(f"DEBUG: {partes}")
print(f"len: {len(partes)}")
conteudo_id = int(partes[0].split(':')[1].strip())
titulo = partes[1].split(':')[1].strip()
url = partes[2].split(':')[1].strip()

dados = {"conteudo_id":conteudo_id,"titulo":titulo,"url":url}

url ='http://localhost:8080/link'
headers = {'Content-Type':'application/json'}

response = requests.post(url,data=json.dumps(dados), headers=headers)

if (response.status_code ==201):
    print("Sucesso ! conteudo cadastrado")
else:
    print(f"Erro: {response.status_code}: {response.text}")