FROM bellsoft/liberica-openjdk-alpine-musl:17
ENV PROJECT_DIR=/app
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR

ADD ./ $PROJECT_DIR/
RUN ./mvnw package -DskipTests

FROM bellsoft/liberica-openjdk-alpine-musl:17
ENV PROJECT_DIR=/app
RUN mkdir -p $PROJECT_DIR
WORKDIR $PROJECT_DIR
COPY --from=0 $PROJECT_DIR/target/twogis-routes-adapter-1.0.jar $PROJECT_DIR/
EXPOSE 8001
CMD ["java", "-jar", "/app/twogis-routes-adapter-1.0.jar"]