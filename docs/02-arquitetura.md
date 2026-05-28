# Arquitetura do Sistema

O projeto segue os princípios de **Clean Architecture** (em uma escala simplificada) e utiliza o padrão de projeto **MVVM (Model-View-ViewModel)**.

## Estrutura de Pacotes

A estrutura do projeto é organizada por funcionalidades (features):

- `br.com.lconeto.mercadoportega.common`: Código compartilhado entre diferentes módulos (como classes de dados).
- `br.com.lconeto.mercadoportega.home`: Lógica e interface da tela inicial.
- `br.com.lconeto.mercadoportega.shopping`: Gestão da lista de compras.

## Componentes Principais

1. **View**: Fragments (`HomeFragment`, etc.) e `MainActivity`. Responsáveis apenas pela exibição e interação com o usuário.
2. **ViewModel**: (`HomeViewModel`, `ShoppingViewModel`, etc.). Mantêm o estado da UI e lidam com a lógica de negócio.
3. **Model**: Classes de dados como `ShoppingItem` e `Category`.

## Navegação

A navegação é centralizada no `nav_graph.xml`, utilizando o **Navigation Component**. O menu lateral (Drawer) facilita o acesso rápido às principais seções do app.
