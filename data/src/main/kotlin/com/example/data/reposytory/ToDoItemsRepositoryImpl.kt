package com.example.data.reposytory

import com.example.domain.model.ToDoItemModel
import com.example.domain.repository.ToDoItemsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToDoItemsRepositoryImpl @Inject constructor(): ToDoItemsRepository {
  override suspend fun loadToDoItems(): List<ToDoItemModel> {
    return listOf(
      ToDoItemModel("Уборка", "Прибраться на кухне, в своей комнате а так же в комнате для гостей"),
      ToDoItemModel("Покупки", "Купить продукты на неделю: молоко, хлеб, яйца, овощи, фрукты"),
      ToDoItemModel("Стирка", "Постирать вещи, разобрать белье и погладить рубашки"),
      ToDoItemModel("Работа", "Завершить отчет по проекту, ответить на письма, подготовить презентацию"),
      ToDoItemModel("Спорт", "Тренировка в зале: кардио 30 минут, силовые упражнения"),
      ToDoItemModel("Чтение", "Прочитать 50 страниц из книги 'Clean Code', сделать заметки"),
      ToDoItemModel("Встреча", "Встретиться с друзьями в кафе в 19:00, забронировать столик"),
      ToDoItemModel("Оплата счетов", "Оплатить коммунальные услуги, интернет и мобильную связь"),
      ToDoItemModel("Изучение", "Пройти 2 урока по Compose, сделать практическое задание"),
      ToDoItemModel("Врач", "Записаться на прием к стоматологу, пройти плановый осмотр"),
      ToDoItemModel("Автомобиль", "Заправить машину, проверить давление в шинах, помыть"),
      ToDoItemModel("Сон", "Лечь спать до 23:00, обеспечить 8-часовой сон"),
      ToDoItemModel("Подарок", "Купить подарок на день рождения мамы, выбрать цветы"),
      ToDoItemModel("Ремонт", "Починить dripping кран на кухне, заменить лампочку в коридоре"),
      ToDoItemModel("Отдых", "Посмотреть новый фильм, погулять в парке, отдохнуть без гаджетов")
    )
  }
}