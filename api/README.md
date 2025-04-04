O projeto api-veiculo, tem como objetivo, gerenciar o cadastro de dados referente um veículo, podendo ser carro, moto, caminhão etc..  
Nesse projeto também é possível verificar datas de atualizações e atualizar status de venda de carro.
 
Banco em memória com h2 e essas foram as configurações gerenciada em aplicattion.propeties:
Likda url: http://localhost:8080/h2-console/
  ![image](https://github.com/user-attachments/assets/a8944e2c-6b6b-4638-bbff-8c1ae5560f9e)

Foi optado um banco de dados de memória visando, a facilidade que uma pessoa poderá baixar o projeto em sua maquina e executar sem precisar se preocupar com as integrações ao banco de dados.

Para o acessar o swagger após a aplicação estiver executando em sua mãquina, basta clicar  -> 
http://localhost:8080/swagger-ui/index.html#/

No swagger será apresentados todos os endpoint desenvolvidos.

EndPoints:  

1° endpoint: 
O nosso primeiro endPoint é um get, que irá fazer uma busca no banco de dados através do id de identificação do veículo.
![image](https://github.com/user-attachments/assets/64193a46-3397-4fd2-bccc-106d7bc83826)

2° EndPoint
Nesse segundo endPoint, vamos atualizar os dados do veiculo do cliente, passando o id de identificação e passando as informações novas via body.
![image](https://github.com/user-attachments/assets/703f3b06-9d92-4394-8cf3-59af886504e4)

3° EndPoint
No terceiro endPoint, é um delete, simples, passe o id e será excluido. 
![image](https://github.com/user-attachments/assets/213c132c-9131-427c-8a43-30158a824ac0)

4° EndPoint
Teremos um patch, diferente o nosso segundo serviço, aqui vamos ter um payload mais especifico para enviar para o banco de dados e atualizar.
![image](https://github.com/user-attachments/assets/65b0e719-552d-44f4-ae9b-9b0e7336f6e7)

5° EndPoint 
É um save, quando o veiculo não se encontra na base e será salvo pela primeira vez.
![image](https://github.com/user-attachments/assets/b60573c9-1260-4d7b-a47e-7f58b610b932)

6° EndPoint
 Temos um serviço de busca de veículo, aqui tratrá todos os cadastro que tiverem  as infomrações passadas por parametros: 

     Marca
     Ano 
     Cor
     
     ![image](https://github.com/user-attachments/assets/3c48e431-e39f-4c47-87b0-a580871260ee)

7° EndPoint 

Temos um outro serviço de busca, porém ele trará todos os dados que tiver na base, mas trará paginado, para que em situações em que tiverem muitos dados  a paginação poderá ajudar na performace.

![image](https://github.com/user-attachments/assets/986909f9-1b6f-4d40-9588-7896ac02efa1)




Tecnologias usadas:
Banco de dados em memória h2
java 17 
Spring boot
Junit
Lambda
Jpa
Swagger
Paginação
Log






  

