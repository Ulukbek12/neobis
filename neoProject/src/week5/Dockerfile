# Используем официальный образ Java
FROM openjdk:11

# Устанавливаем переменную окружения для Java
ENV APP_HOME=/app

# Создаем директорию для приложения
WORKDIR $APP_HOME

# Копируем pom.xml и src в директорию контейнера
COPY ./pom.xml $APP_HOME/
COPY ./src $APP_HOME/src/

# Запускаем сборку приложения с помощью Maven
RUN mvn -f $APP_HOME/pom.xml clean package

# Запускаем приложение при старте контейнера
CMD ["java", "-jar", "target/week5.jar"]
