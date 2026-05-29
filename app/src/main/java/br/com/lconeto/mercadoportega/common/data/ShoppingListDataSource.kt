package br.com.lconeto.mercadoportega.common.data

object ShoppingListDataSource {

    private fun createItem(name: String, category: Category) = ShoppingItem(name, category)

    fun getDefaultList(): List<ShoppingItem> {
        return getFoodList() + getHortifrutiList() + getCleaningList() + getHygieneList()
    }

    fun getFoodList(): List<ShoppingItem> {
        return getFoodListPart1() + getFoodListPart2()
    }

    private fun getFoodListPart1(): List<ShoppingItem> {
        val category = Category.Food
        return listOf(
            createItem("Açúcar", category),
            createItem("Açúcar mascavo", category),
            createItem("Alho em pó", category),
            createItem("Arroz", category),
            createItem("Atum", category),
            createItem("Aveia em flocos", category),
            createItem("Azeite", category),
            createItem("Bacon", category),
            createItem("Barrinha de cereal", category),
            createItem("Batata palha", category),
            createItem("Bife", category),
            createItem("Café", category),
            createItem("Cachaça", category),
            createItem("Canela em pó", category),
            createItem("Carne de Churrasco", category),
            createItem("Carne Moída", category),
            createItem("Cerveja", category),
            createItem("Chocolate", category),
            createItem("Coca zero", category),
            createItem("Creme de leite", category),
            createItem("Doce de leite", category),
            createItem("Farofa", category),
            createItem("Feijão", category),
            createItem("Frango", category),
            createItem("Granola", category),
            createItem("Iogurte", category),
            createItem("Ketchup", category),
            createItem("Legumes congelados", category),
            createItem("Leite", category),
            createItem("Leite condensado", category),
            createItem("Leite em pó", category)
        )
    }

    private fun getFoodListPart2(): List<ShoppingItem> {
        val category = Category.Food
        return listOf(
            createItem("Linguiça", category),
            createItem("Macarrão", category),
            createItem("Manteiga", category),
            createItem("Melita Café", category),
            createItem("Milho", category),
            createItem("Milho de pipoca", category),
            createItem("Molho de tomate", category),
            createItem("Morango Congelado", category),
            createItem("Mostarda", category),
            createItem("Noz Moscada", category),
            createItem("Óleo", category),
            createItem("Ovos", category),
            createItem("Pão", category),
            createItem("Pão de Forma", category),
            createItem("Pão de queijo", category),
            createItem("Páprica Doce", category),
            createItem("Páprica Picante", category),
            createItem("Pasta de amendoim", category),
            createItem("Petisco", category),
            createItem("Polpa de Açai", category),
            createItem("Queijo", category),
            createItem("Queijo Gorgonzola", category),
            createItem("Queijo Parmesão", category),
            createItem("Queijo ralado", category),
            createItem("Requeijão", category),
            createItem("Sal", category),
            createItem("Shoyu", category),
            createItem("Suco Prats", category),
            createItem("Suco de Uva", category),
            createItem("Vinho", category),
            createItem("YoPro", category),
            createItem("Água de Coco", category)
        )
    }

    fun getHortifrutiList(): List<ShoppingItem> {
        val category = Category.Hortifruti
        return listOf(
            createItem("Alface", category),
            createItem("Batata (comum)", category),
            createItem("Batata doce", category),
            createItem("Beterraba", category),
            createItem("Cebola", category),
            createItem("Cenoura", category),
            createItem("Laranja", category),
            createItem("Limão", category),
            createItem("Manga", category),
            createItem("Pepino", category),
            createItem("Tomate", category),
            createItem("Uva", category)
        )
    }

    fun getCleaningList(): List<ShoppingItem> {
        val category = Category.Cleaning
        return listOf(
            createItem("Álcool", category),
            createItem("Amaciante", category),
            createItem("Balde", category),
            createItem("Buchinha azul", category),
            createItem("Buchinha verde", category),
            createItem("Detergente", category),
            createItem("Desinfetante", category),
            createItem("Limpol", category),
            createItem("Pato (limpeza)", category),
            createItem("Pato (vaso)", category),
            createItem("Pinho Sol", category),
            createItem("Qboa", category),
            createItem("Rodo", category),
            createItem("Sabão líquido", category),
            createItem("Saco de lixo", category),
            createItem("Vassoura", category)
        )
    }

    fun getHygieneList(): List<ShoppingItem> {
        val category = Category.Hygiene
        return listOf(
            createItem("Algodão", category),
            createItem("Condicionador", category),
            createItem("Desodorante Dai", category),
            createItem("Desodorante LC", category),
            createItem("Escova de Dente", category),
            createItem("Ob (fluxo alto)", category),
            createItem("Ob (fluxo médio)", category),
            createItem("Papel higiênico", category),
            createItem("Papel toalha", category),
            createItem("Pasta de dente", category),
            createItem("Sabonete", category),
            createItem("Sabonete líquido", category),
            createItem("Shampoo", category)
        )
    }
}
