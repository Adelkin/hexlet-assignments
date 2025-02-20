# Используем базовый образ с JDK 20
FROM eclipse-temurin:20-jdk  

# Указываем аргумент для версии Gradle
ARG GRADLE_VERSION=8.2  

# Устанавливаем необходимые утилиты и Gradle
RUN apt-get update && apt-get install -yq make unzip wget  
RUN wget -q https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip \
    && unzip gradle-${GRADLE_VERSION}-bin.zip \
    && rm gradle-${GRADLE_VERSION}-bin.zip  

# Устанавливаем переменные окружения для Gradle
ENV GRADLE_HOME=/opt/gradle  
RUN mv gradle-${GRADLE_VERSION} ${GRADLE_HOME}  
ENV PATH=$PATH:$GRADLE_HOME/bin  

# Устанавливаем рабочую директорию
WORKDIR /app  

# Копируем код приложения внутрь контейнера
COPY . .  

# Собираем приложение с помощью Gradle
RUN gradle build  

# Открываем порт 8080 внутри контейнера
EXPOSE 8080  

# Запускаем приложение
CMD ["java", "-jar", "build/libs/app.jar"]