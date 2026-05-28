# Skills de Desenvolvimento

Este documento descreve ferramentas e automações (Skills) utilizadas pelos desenvolvedores e agentes para manter o projeto.

## 1. Skill de Inserção de Produtos no DataSource

Esta skill automatiza a atualização da lista inicial de produtos do aplicativo.

### Objetivo
Manter o arquivo `ShoppingListDataSource.kt` atualizado, organizado por categorias e em ordem alfabética.

### Funcionamento
- **Arquivo Alvo**: `app/src/main/java/br/com/lconeto/mercadoportega/common/data/ShoppingListDataSource.kt`
- **Entrada**: Lista de N itens com suas respectivas categorias.
- **Processamento**:
    1. Identificar o método correspondente à categoria: `getFoodList()`, `getCleaningList()` ou `getHygieneList()`.
    2. Adicionar o novo item usando a função `createItem`.
    3. Reordenar os itens dentro desse método alfabeticamente.
- **Categorias Suportadas**:
    - `food` (Comida 🍎)
    - `cleaning` (Produtos de Limpeza 🧽)
    - `hygiene` (Produtos de Higiene 🧴)

### Regras de Formatação
Cada item deve seguir o padrão:
```kotlin
createItem("Nome do Produto", categoria),
```
A ordem das categorias no arquivo deve ser mantida: **Food -> Cleaning -> Hygiene**.
