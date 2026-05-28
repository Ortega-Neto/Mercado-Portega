# Modelos de Dados (Domain)

As entidades principais do sistema estão localizadas no pacote `common.data`.

## ShoppingItem
Representa um item na lista de compras.

| Atributo | Tipo | Descrição |
| :--- | :--- | :--- |
| `name` | String | Nome do item. |
| `category` | Category | Categoria do item (Food, Cleaning, etc). |
| `isChecked` | Boolean | Estado de seleção do item na lista. |

## Category
Uma `sealed class` que define as categorias pré-definidas no sistema.

Categorias atuais:
- `Food`: Comida 🍎
- `Cleaning`: Produtos de Limpeza 🧽
- `Hygiene`: Produtos de Higiene 🧴
