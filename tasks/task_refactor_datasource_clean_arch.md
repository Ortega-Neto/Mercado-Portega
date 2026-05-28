# Task: Otimização do ShoppingListDataSource para Clean Architecture

## Objetivo
Refatorar o `ShoppingListDataSource.kt` para torná-lo mais condizente com os princípios de **Clean Architecture**, removendo a responsabilidade de "armazenamento estático de strings" de dentro de um `object` e preparando o terreno para uma futura persistência (como Room ou DataStore).

## Pontos Cruciais
- **NÃO remover** nenhum item da listagem atual. [x]
- **NÃO alterar a ordem** atual dos itens. [x]
- **Manter a Skill de Inserção** funcionando (ajustando suas regras se necessário). [x]

## Proposta Técnica
1. **Extração de Dados**: Mover a lista de strings/itens para um arquivo de configuração ou manter como uma constante privada, separada da lógica de acesso. [x]
2. **Interface de Repositório**: Criar uma interface `ShoppingRepository` para definir o contrato de obtenção dos dados. [x]
3. **Implementação de Data Source**: Refatorar o `ShoppingListDataSource` para implementar uma interface ou ser consumido por um repositório, removendo o acoplamento direto de UI com o `object` estático onde possível. [x]
4. **Organização por Categorias**: Considerar separar os blocos de itens em listas menores privadas para facilitar a manutenção e leitura (evitando o erro de "LongMethod" do Detekt). [x]

## Tarefas
- [x] Criar interface `ShoppingRepository` no pacote `common.domain.repository`.
- [x] Criar implementação `ShoppingRepositoryImpl` ou atualizar o `DataSource` para atuar como provedor de dados.
- [x] Refatorar `getInitialList()` para compor a lista a partir de sub-listas por categoria (evitando métodos gigantes).
- [x] Garantir que o `ShoppingViewModel` ou `ShoppingFragment` consuma os dados via abstração.

## Critérios de Aceite
- O app deve compilar e exibir a mesma lista, na mesma ordem. [x]
- O aviso de `LongMethod` no `ShoppingListDataSource.kt` deve ser resolvido. [x]
- A estrutura deve permitir fácil substituição por um banco de dados real no futuro sem alterar a lógica da UI. [x]
