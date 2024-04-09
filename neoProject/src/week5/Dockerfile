# Используем официальный образ JDK 17
dockerFROM openjdk:17-jdk-alpine

# Создаем директорию для приложения
WORKDIR /app

# Копируем собранный JAR-файл из директории target в контейнер
COPY target/week5.jar /app/app.jar

# Запускаем приложение при старте контейнера
CMD ["java", "-jar", "/app/app.jar"]
