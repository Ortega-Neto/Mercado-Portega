# Skill de Desenvolvimento: Inserção de Produtos no DataSource

Esta skill é uma ferramenta de automação para desenvolvedores (ou agentes) adicionarem novos produtos ao arquivo `ShoppingListDataSource.kt` de forma padronizada.

## Proposta de Mudanças

### Automação de Desenvolvimento

#### [android_specialist_agent.artifact.md](file:///D:/Git/Mercado-Portega/.artifacts/android_specialist_agent.artifact.md)
- Adicionar a definição da "Skill de Inserção" como uma capacidade oficial do Agente Especialista Android.
- Definir o formato de entrada para a skill e a lógica de processamento esperada.

### Código Fonte

#### [ShoppingListDataSource.kt](file:///D:/Git/Mercado-Portega/app/src/main/java/br/com/lconeto/mercadoportega/common/data/ShoppingListDataSource.kt)
- Este arquivo será o alvo das modificações toda vez que a skill for invocada.
- A skill deve garantir:
    1. Inserção no grupo de categoria correto (`food`, `cleaning` ou `hygiene`).
    2. Ordenação alfabética dentro do grupo.
    3. Manutenção da sintaxe `createItem("Nome", categoria),`.

---

## Plano de Verificação

### Testes de Execução da Skill
1. **Entrada**: Adicionar "Zucchini" (food) e "Desengordurante" (cleaning).
2. **Resultado Esperado**:
    - "Zucchini" deve ser o último item da lista `food` (devido ao Z).
    - "Desengordurante" deve ser inserido entre "Detergente" e "Desinfetante" na lista `cleaning`.
3. **Validação de Código**: O arquivo deve continuar compilando sem erros de sintaxe (vírgulas faltando, etc).
