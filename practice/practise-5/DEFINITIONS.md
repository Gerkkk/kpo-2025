# Список терминов семинара
###### Нужно написать определения с примером из жизни или кода
- Порождающие паттерны - группа паттернов GoF, которые связаны с созданием объектов.
- Singleton (Одиночка) - он один на всё приложение. Реализуется как класс, в котором конструктор сделан пустым, определен getInstance, и есть статическое поле instance.
- Factory (Фабрика) - выносим логику создания объектов в отдельный класс, чтобы не дублировать код (реализуется switch-case-ами)
- Fabric method (Фабричный метод) - передает создание объектов в отдельный метод, который может переопределяться наследниками(делегируем создание объекта наследникам). Реализуется через переопределение такого метода, интерфейсы/абстрактные классы для продуктов.
- Abstract Factory (Абстрактная фабрика) - позволяет создавать коллекции объектов одинаковых типов, но разных реализаций. реализуется как абстрактный класс фабрики, от которого наследуются конкретные фабрики, которые умеют создавать объекты определенной коллекции.
- Builder (Строитель) - паттерн, который позволяет собрать объект из нескольких частей. В джаве реализовывается как класс, содержащий итоговый объект, методы добавляют к нему детали, а метод build возвращает итоговый объект.
- Prototype (Прототип) - объект, позволяющий себя скопировать. Реализуется через интерфейс cloneable, переопределением clone()
- +1 уникальный факт связанный с темами выше или семинаром