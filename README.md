# GithubClient
Приложение является интерфейсом взаимодействия с социальной сетью для разработчиков - Github.com
Приложение обладает следующим функционалом:

- поиск репозиториев конкретного пользователя
- обработка ошибок (когда пользователя не существует, когда форма ввода не проходит валидацию, обработка сетевых ошибок)
- отображение списка репозиториев пользователя с рейтинговой системой выбора отображения UI элементов (репозитории более чем с 500 звездами имеют другой интерфейс отображения в отличие от обычных репозиториев. Популярные репозитории окрашены в розовый цвет и отображают список звезд и форков)
- просмотр подробной информации по репозиторию: название, количество звезд, дата создания и дата последнего обновления при наличии, основной язык разработки, количество наблюдателей, а также кнопку "показать код", которая отображает JSON код ответа на запрос для данного репозитория.