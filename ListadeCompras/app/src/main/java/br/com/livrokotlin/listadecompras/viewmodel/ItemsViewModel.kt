package br.com.livrokotlin.listadecompras.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.livrokotlin.listadecompras.data.ItemEntity
import br.com.livrokotlin.listadecompras.data.ItemsDatabase
import br.com.livrokotlin.listadecompras.data.toModel
import br.com.livrokotlin.listadecompras.model.ItemModel
import br.com.livrokotlin.listadecompras.model.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemsViewModel(
    private val database: ItemsDatabase
): ViewModel() {

    private var items = mutableListOf<ItemModel>()
    val itemsLiveData = MutableLiveData<List<ItemModel>>()

    fun addItem(name: String) {
        val item = ItemModel(id = 0, name = name, onRemove = ::removeItem)
        items.add(item)
        itemsLiveData.value = items
    }

    private fun removeItem(item: ItemModel) {
        items.remove(item)
        itemsLiveData.value = items
    }

//    init {
//        viewModelScope.launch(Dispatchers.IO) {
//            fetchAll()
//        }
//    }
//
//    fun addItem(name: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val entity = ItemEntity(id = 0, name = name)
//            database.itemsDao().insert(entity)
//            fetchAll()
//        }
//    }
//
//    private suspend fun fetchAll() {
//        val result = database.itemsDao().getAll().map {
//            it.toModel(onRemove = ::removeItem)
//        }
//
//        itemsLiveData.postValue(result)
//    }
//
//    private fun removeItem(item: ItemModel) {
//        viewModelScope.launch(Dispatchers.IO) {
//            val entity = item.toEntity()
//            database.itemsDao().delete(entity)
//            fetchAll()
//        }
//    }
}

