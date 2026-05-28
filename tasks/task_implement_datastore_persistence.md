# Task: Implementação de Persistência com Jetpack DataStore

## Objetivo
Substituir o armazenamento volátil (em memória RAM) por persistência local utilizando **Jetpack DataStore (Preferences)**. O objetivo é permitir que a lista de compras (incluindo o estado de `isChecked`) seja salva e recuperada mesmo após fechar o aplicativo.

## Proposta Técnica: Persistência de Lista Complexa
Como o DataStore Preferences trabalha nativamente com tipos primitivos, a melhor forma de salvar uma lista de objetos `ShoppingItem` é:
1.  **Serialização JSON**: Utilizar a biblioteca **Gson** (já presente nas dependências) para converter a `List<ShoppingItem>` em uma `String` JSON.
2.  **Chave de Acesso**: Criar uma chave única `SHOPPING_LIST_KEY` para armazenar essa string.
3.  **Fluxo Reativo**: O DataStore utiliza `Flow`, o que permitirá ao `ShoppingViewModel` reagir a mudanças nos dados em tempo real.

## Tarefas
- [x] Criar classe `ShoppingDataStore` em `common.data` para gerenciar as operações de I/O.
- [x] Implementar método `saveShoppingList(items: List<ShoppingItem>)`.
- [x] Implementar método `getShoppingList(): Flow<List<ShoppingItem>>`.
- [x] Atualizar `ShoppingRepository` para suportar operações de escrita (save).

## Pontos Críticos e Detekt
- **Singleton**: O DataStore deve ser uma instância única (delegado `preferencesDataStore`).
- **Constants**: Evitar "Magic Strings" para as chaves do DataStore; usar `companion object` ou constantes de arquivo.
- **Coroutines**: Garantir que as operações de escrita ocorram em `Dispatchers.IO`.

## Critérios de Aceite
- Ao marcar um item como "comprado" e reiniciar o app, o item deve permanecer marcado. [x]
- A ordenação (prioridade de categoria + alfabética) deve ser reaplicada após a leitura do JSON. [x]
- O código não deve apresentar violações de Detekt (MagicNumber, UnusedImports). [x]
