# Объяснение решения

Задачу можно разделить на 2е подзадачи:

1. Улавливание "cold start"
2. Счётчик "cold start"

Начну со второго. Счётчик "cold start"
Здесь нам требуется персистентная память, есть два варианта  
1. Shared preferences
2. Local DB

C Shared preferences всё просто, на каждом "cold start" увеличиваем счётчик, а вот с DB пришлось чуть 
больше повозиться (создать таблицу, методы взаимодействия). Поэтому я выбрать Shared preferences.

Теперь Улавливание "cold start"

Здесь у меня были такие решения:
1. В Main активити метода onCreate. 
Минусы, во время работы приложения активити может пересоздаться и вызовет ложное улавливание "cold start", 
поэтому в идеале этот метод не подходить, но если просто открыть приложение с пустым активити и ничего не делать, то теоретически ОК.

2. Splash screen
Создать Splash screen активити (в intent-filter сделать category LAUNCHER).
Явных минусов я здесь не нашёл, единственно что я слышал, не рекомендуют использовать активити как Splash screen.
А так это вполне неплохое решение.

3. Переопределить класс Application
Здесь всё просто. В методе onCreate нашего кастомного Application класса улавливаем вход в приложение.
Это давольно лёгкое решение. Из минусов, бывает такое, что андроид решит убить процесс приложения, если оно долго висит в background и не открывалось.
В таком случай заново создастся класс Application и будет ложное улавливание "cold start". 
Теоретически это тоже рабочее решение, если не подразумевается что приложения будет часами висеть в background.

Для здесь я реализовал связку Shared preferences + Custom Application
В выборе Shared preferences и Local DB особой разницы нету
А вот с методом улавливания, теоретически для "быстрого" решения подойду все решения. 
Но как я считаю самым точным является 2 решение(Splash screen), но я выбрал решение с 
кастомный Application потом просто это быстро, хотя соглашусь, что не "тотально" точно.


