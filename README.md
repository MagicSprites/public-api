## `Querix Public API`
Привет! Это наша апишка, которую ты должен заиспользовать в своем плагине под наш проект, она будет работать только при запуске на нашей инфраструктуре, иначе мы просто не найдем классы-реализации всего этого добра и ты утонешь в ошибках.

У нас есть менеджер депенд которые могут тебе понадобиться, так что мы легко обращаемся к нему и спрашиваем что нужно:
```kotlin
Querix.lookupService<Класс_Того_Что_Тебе_Нужно>()
```

Конечно можно это было бы сделать через DI, но тут есть несколько возможных проблем с которыми никто не хочет иметь дело)

