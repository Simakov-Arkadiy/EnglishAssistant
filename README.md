# EnglishAssistant

**EnglishAssistant** — Android-приложение для изучения английского языка, ориентированное на запоминание пар «русский–английский» переводов.

## Возможности

- 📝 **Запись слов** — добавление новых пар слов (русский + английский перевод)
- 🔍 **Поиск** — мгновенный поиск по существующим парам с выпадающим списком подсказок
- 📋 **Тестирование** — квизы с 4 вариантами ответа, генерируемые на основе веса слов
- 🎨 **Material Design 3** — современный UI с поддержкой динамических цветов (Android 12+)

## Архитектура

Проект построен по принципам **Clean Architecture** и состоит из трёх слоёв:

### Data Layer
- **Room Database** — таблица `wordPairs` с полями: `id`, `wordRu`, `wordEn`, `weight`
- **DAO** — операции вставки, поиска по префиксу, выборки для теста (по весу), обновления веса
- **Repository** — `RepositoryImpl` реализует интерфейс `WordPairRepository`

### Domain Layer
- **Use Cases**:
  - `RecordWordPairUseCase` — вставка новой пары слов
  - `SearchWordPairUseCase` — поиск по подстроке (русский или английский)
  - `GetTestUseCase` — выбор 4 слов по весу, генерация вопроса и вариантов ответа

### Presentation Layer
- **Jetpack Compose** — весь UI построен на Declarative UI
- **Navigation Compose** — навигация между экранами
- **ViewModel** — один ViewModel на каждый экран
- **Dagger 2** — dependency injection (AppComponent, BindsModule, ProvidedModule)

## Экраны

| Экран | Описание |
|-------|----------|
| **HomeScreen** | Главный экран с тремя кнопками: запись, поиск, тест |
| **RecordScreen** | Форма для добавления новой пары слов |
| **SearchScreen** | Поиск с выпадающим списком и диалогом просмотра |
| **TestScreen** | Квиз: показывается английское слово, нужно выбрать русский перевод из 4 вариантов |

## Стек технологий

| Компонент | Технология |
|-----------|------------|
| Язык | Kotlin |
| UI | Jetpack Compose + Material3 |
| Навигация | Navigation Compose |
| База данных | Room (предзаполненная из `assets/prepopulated_data.db`) |
| DI | Dagger 2 + KSP |
| Архитектура | Clean Architecture (MVVM) |
| Минимальная версия Android | 24 (Android 7.0) |
| Target / Compile SDK | 37 |

## Структура проекта

```
app/src/main/java/com/example/englishassistant/
├── data/                  # Data layer
│   ├── BaseDao.kt
│   ├── EnglishAssistantDataBase.kt
│   ├── EntityWordPair.kt
│   └── RepositoryImpl.kt
├── domain/                # Domain layer
│   ├── GetTestUseCase.kt
│   ├── RecordWordPairUseCase.kt
│   ├── SearchWordPairUseCase.kt
│   ├── Test.kt
│   ├── WordPair.kt
│   ├── WordPairImpl.kt
│   └── WordPairRepository.kt
├── presentation/          # Presentation layer
│   ├── di/                # Dagger modules
│   ├── recordScreen/      # Экран записи
│   ├── searchScreen/      # Экран поиска
│   ├── testScreen/        # Экран теста
│   ├── HomeScreen.kt
│   └── MainActivity.kt
└── ui/theme/              # Тема Material3
```


## Зависимости

| Библиотека | Версия |
|------------|--------|
| AGP | 9.1.1 |
| Kotlin | 2.2.10 |
| Compose BOM | 2026.02.01 |
| Room | 2.8.4 |
| Dagger | 2.60.1 |
| KSP | 2.2.10-2.0.2 |
| Navigation Compose | 2.9.8 |
| Lifecycle | 2.11.0 |

## Лицензия

Учебный проект.
