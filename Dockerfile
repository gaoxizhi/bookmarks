FROM openjdk:8u342-jdk-oracle
LABEL maintainer = "gaoxizhi"
# 设置容器时间
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

WORKDIR /home
EXPOSE 6725

COPY target/bookmarks-0.0.1-SNAPSHOT.jar /home/bookmarks.jar

# ENTRYPOINT 在容器启动后执行 java 命令来运行程序
ENTRYPOINT ["java", "-Dfile.encoding=utf-8", "-Xmx256m", "-jar", "bookmarks.jar"]
