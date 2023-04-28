# 构建镜像，执行命令如：【docker build -t apiboot:1.0 .】
FROM eclipse-temurin:17-jre
MAINTAINER mqxu

# 设置时区
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo 'Asia/Shanghai' >/etc/timezone

ENTRYPOINT ["java", "-server", "-Xms1024M", "-Xmx1024M", "-Djava.security.egd=file:/dev/./urandom", "-Dfile.encoding=UTF-8", "-XX:+HeapDumpOnOutOfMemoryError", "-jar", "/app/app.jar" ]