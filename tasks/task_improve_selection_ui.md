# Task: Melhoria da UI de Seleção de Itens (Fazer Lista) [COMPLETED]

## Objetivo
Refatorar a interface de seleção de produtos para que o usuário tenha uma percepção visual clara do que está selecionado para a compra atual, diferenciando do comportamento de "riscado" que é usado durante a execução da compra.

## Proposta de Melhoria Visual
Atualmente, o app usa o mesmo estilo (riscado e alpha) tanto para marcar o item como "comprado" quanto para selecioná-lo para a lista. Proponho as seguintes mudanças para a tela de **Criação de Lista**:

1.  **Check Indicators**: Adicionar um `CheckBox` ou um ícone de "Check" (visto/não visto) à direita de cada item. [x]
2.  **Highlight de Seleção**: Itens selecionados devem ter um fundo (background) levemente colorido ou uma borda, indicando um estado "Ativo". [x]
3.  **Remoção do Riscado (Strikethrough)**: O riscado deve ser exclusivo da tela de "Fazer Compras". Na tela de seleção, o texto deve permanecer limpo para facilitar a leitura. [x]
4.  **Feedback Tátil**: Garantir que o clique no card inteiro alterne o estado, não apenas no CheckBox. [x]

## Tarefas Técnicas
- [x] Criar um novo layout de item ou adaptar o `ListItemShoppingBinding` para suportar estados visuais diferentes:
    - Estado 1 (Shopping): Riscado + Alpha (Comprado).
    - Estado 2 (Selection): CheckBox marcado + Background highlight (Selecionado para compra).
- [x] Atualizar o `ShoppingAdapter` para receber um `mode` (SHOPPING vs SELECTION):
    - No modo SELECTION: Mostrar CheckBox, usar background highlight, sem riscado.
    - No modo SHOPPING: Esconder CheckBox, usar riscado + alpha.
- [x] Implementar a lógica de cores (ex: um tom leve de verde ou a cor primária do app com transparência) para itens selecionados.

## Critérios de Aceite
- Na tela "Fazer Lista", ao clicar em um item, um CheckBox aparece marcado e o card muda de cor. [x]
- O texto do item selecionado na criação da lista **não** deve estar riscado. [x]
- Na tela "Fazer Compras", o comportamento original (riscado) é mantido para itens comprados. [x]
- Conformidade com Detekt e ausência de MagicNumbers nas cores. [x]
