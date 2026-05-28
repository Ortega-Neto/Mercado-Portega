# Task: Fluxo Separado de Criação de Lista e Execução de Compras

## Objetivo
Refatorar a experiência do usuário para separar o momento de **planejamento** (escolher o que comprar) do momento de **execução** (marcar os itens no mercado). 

## Proposta Técnica

### 1. Mudança na Home
- Adicionar dois botões (Cards): [x]
    - **Fazer Lista**: Direciona para a seleção de itens do catálogo. [x]
    - **Fazer Compras**: Direciona para a lista de itens selecionados para a compra atual. [x]

### 2. Fluxo "Fazer Lista" (Novo)
- Exibe o catálogo completo (visto hoje no `ShoppingListDataSource`). [x]
- Permite selecionar múltiplos itens. [x]
- Ao clicar em "Salvar", a lista selecionada é persistida no DataStore, **sobrescrevendo** qualquer lista anterior. [x]
- O estado inicial de todos os itens nesta lista deve ser `isChecked = false`. [x]

### 3. Fluxo "Fazer Compras" (Refatorado)
- Consome a lista salva no DataStore. [x]
- **Validação de Entrada**: Se não houver itens salvos (primeira execução ou lista vazia), redirecionar automaticamente o usuário para a tela de "Fazer Lista". [x]
- Permite marcar/desmarcar itens (check), atualizando a persistência em tempo real. [x]

### 4. Modelo de Dados e Repositório
- Manter o `ShoppingRepository` com DataStore. [x]
- Garantir que a lógica de "Sobrescrever" limpe os estados de `isChecked` antigos ao criar uma nova lista. [x]

## Tarefas
- [x] Atualizar `fragment_home.xml` com os dois botões.
- [x] Criar `SelectionFragment` e `SelectionViewModel` para a funcionalidade "Fazer Lista".
- [x] Criar layout `fragment_selection.xml` com suporte a seleção múltipla e botão "Finalizar Lista".
- [x] Refatorar `ShoppingFragment` para verificar se a lista está vazia e navegar para a seleção se necessário.
- [x] Atualizar `mobile_navigation.xml` com os novos destinos e ações.
- [x] Refatorar `ShoppingViewModel` para focar exclusivamente na lista persistida (compras ativas).

## Critérios de Aceite
- Ao abrir "Fazer Compras" pela primeira vez, o app deve ir para "Fazer Lista". [x]
- Criar uma lista com 3 itens e salvar. Ao abrir "Fazer Compras", apenas esses 3 devem aparecer. [x]
- Criar uma nova lista com 1 item diferente. Ao salvar, a lista de compras deve conter apenas esse novo item. [x]
- Integridade do Detekt mantida. [x]
