# Avaliação semestral – Padrões de Projetos

Jovandro Wawrzonkiewicz Junior

## Como rodar

    cd questao1/src
    javac *.java
    java Main

Na questão 2 é igual, só trocar para `cd questao2/src`.

## Questão 1: provisionamento multinuvem

- **Abstract Factory** (`ProvedorNuvem`): garante que máquina, armazenamento e fila sejam do mesmo provedor.
- **Singleton** em `Configuracao` (lê o `config.properties` uma vez) e em `AuditLog` (histórico único, com métodos `synchronized`).

## Questão 2: casa de leilões

- **Observer** (`Interessado`): avisa participantes, painel e auditor a cada lance.
- **Strategy** (`RegraComissao`): uma regra de comissão por categoria, que pode ser trocada em tempo de execução.
- **Decorator** (`ServicoAdicional`): serviços da fatura combináveis sem classes prontas.
