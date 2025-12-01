package br.com.lconeto.mercadoportega.common.data

object ShoppingListDataSource {

    private fun createItem(name: String, category: Category) = ShoppingItem(name, category)

    fun getInitialList(): List<ShoppingItem> {
        val food = Category.Food
        val cleaning = Category.Cleaning
        val hygiene = Category.Hygiene

        return listOf(
            createItem("Açúcar", food),
            createItem("Açúcar mascavo", food),
            createItem("Alho em pó", food),
            createItem("Arroz", food),
            createItem("Atum", food),
            createItem("Aveia em flocos", food),
            createItem("Azeite", food),
            createItem("Barrinha de cereal", food),
            createItem("Batata palha", food),
            createItem("Batata doce", food),
            createItem("Batata (comum)", food),
            createItem("Melita Café", food),
            createItem("Café", food),
            createItem("Cachaça", food),
            createItem("Canela em pó", food),
            createItem("Cebola", food),
            createItem("Cerveja", food),
            createItem("Chocolate", food),
            createItem("Coca zero", food),
            createItem("Creme de leite", food),
            createItem("Doce de leite", food),
            createItem("Farofa", food),
            createItem("Feijão", food),
            createItem("Frango", food),
            createItem("Granola", food),
            createItem("Iogurte", food),
            createItem("Ketchup", food),
            createItem("Legumes congelados", food),
            createItem("Leite", food),
            createItem("Leite condensado", food),
            createItem("Leite em pó", food),
            createItem("Macarrão", food),
            createItem("Manteiga", food),
            createItem("Milho", food),
            createItem("Milho de pipoca", food),
            createItem("Molho de tomate", food),
            createItem("Mostarda", food),
            createItem("Noz Moscada", food),
            createItem("Óleo", food),
            createItem("Ovos", food),
            createItem("Pão", food),
            createItem("Pão de queijo", food),
            createItem("Pasta de amendoim", food),
            createItem("Petisco", food),
            createItem("Queijo", food),
            createItem("Queijo ralado", food),
            createItem("Requeijão", food),
            createItem("Sal", food),
            createItem("Shoyu", food),
            createItem("Vinho", food),
            createItem("YoPro", food),

            createItem("Álcool", cleaning),
            createItem("Amaciante", cleaning),
            createItem("Buchinha azul", cleaning),
            createItem("Buchinha verde", cleaning),
            createItem("Detergente", cleaning),
            createItem("Desinfetante", cleaning),
            createItem("Limpol", cleaning),
            createItem("Pato (limpeza)", cleaning),
            createItem("Pato (vaso)", cleaning),
            createItem("Pinho Sol", cleaning),
            createItem("Qboa", cleaning),
            createItem("Sabão líquido", cleaning),
            createItem("Saco de lixo", cleaning),

            createItem("Condicionador", hygiene),
            createItem("Desodorante Dai", hygiene),
            createItem("Desodorante LC", hygiene),
            createItem("Escova de Dente", hygiene),
            createItem("Ob (fluxo alto)", hygiene),
            createItem("Ob (fluxo médio)", hygiene),
            createItem("Papel higiênico", hygiene),
            createItem("Papel toalha", hygiene),
            createItem("Pasta de dente", hygiene),
            createItem("Sabonete", hygiene),
            createItem("Sabonete líquido", hygiene),
            createItem("Shampoo", hygiene)
        )
    }
}
