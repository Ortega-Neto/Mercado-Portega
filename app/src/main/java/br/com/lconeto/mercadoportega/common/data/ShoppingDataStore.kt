package br.com.lconeto.mercadoportega.common.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.lang.reflect.Type

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "shopping_prefs")

class ShoppingDataStore(private val context: Context) {

    private val gson: Gson = GsonBuilder()
        .registerTypeAdapter(Category::class.java, CategoryAdapter())
        .create()

    companion object {
        private val SHOPPING_LIST_KEY = stringPreferencesKey("shopping_list")
    }

    suspend fun saveShoppingList(items: List<ShoppingItem>) {
        val jsonString = gson.toJson(items)
        context.dataStore.edit { preferences ->
            preferences[SHOPPING_LIST_KEY] = jsonString
        }
    }

    fun getShoppingList(): Flow<List<ShoppingItem>> {
        return context.dataStore.data.map { preferences ->
            val jsonString = preferences[SHOPPING_LIST_KEY]
            if (jsonString.isNullOrEmpty()) {
                emptyList()
            } else {
                val type = object : TypeToken<List<ShoppingItem>>() {}.type
                gson.fromJson(jsonString, type)
            }
        }
    }

    private class CategoryAdapter : JsonSerializer<Category>, JsonDeserializer<Category> {
        override fun serialize(
            src: Category,
            typeOfSrc: Type,
            context: JsonSerializationContext,
        ): JsonElement {
            return JsonPrimitive(src::class.java.simpleName)
        }

        override fun deserialize(
            json: JsonElement,
            typeOfT: Type,
            context: JsonDeserializationContext,
        ): Category {
            val typeName = when {
                json.isJsonPrimitive -> json.asString
                json.isJsonObject -> json.asJsonObject.get("name")?.asString ?: ""
                else -> ""
            }

            return when {
                typeName.contains("Food", true) ||
                    typeName.contains("Comida", true) -> Category.Food
                typeName.contains("Cleaning", true) ||
                    typeName.contains("Limpeza", true) -> Category.Cleaning
                typeName.contains("Hygiene", true) ||
                    typeName.contains("Higiene", true) -> Category.Hygiene
                else -> Category.Food
            }
        }
    }
}
