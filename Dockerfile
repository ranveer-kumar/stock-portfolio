FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9001
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.ht.wsj.WsjCouponServiceApplication", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=dev", "-Dspring.cloud.consul.host=10.46.0.5", "-Dspring.cloud.consul.discovery.prefer-ip-address=true", "-Dspring.cloud.consul.discovery.ip-address=true", "--spring.boot.admin.client.instance.service-base-url=http://$HOSTNAME:7571" ]
ENTRYPOINT exec java -cp app:app/lib/* com.fondofit.stock.portfolio.StockPortfolioServiceApplication --spring.profiles.active=k8s 
