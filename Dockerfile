# 建议生产使用，ref: http://blog.tenxcloud.com/?p=1894
FROM iron/java:1.8

USER root

COPY yc-stock-server-webapp-provider/target/demo.jar /home/