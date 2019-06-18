#!/bin/sh

# apollo config db info
apollo_config_db_url=jdbc:mysql://ApolloConfigDB.master.com:3306/ApolloConfigDB?characterEncoding=utf8
apollo_config_db_username=ApolloDB_W
apollo_config_db_password=2ey3Yeg2XXm8bCnqwm38

# apollo portal db info
apollo_portal_db_url=jdbc:mysql://ApolloPortalDB.master.com:3306/ApolloPortalDB?characterEncoding=utf8
apollo_portal_db_username=ApolloDB_W
apollo_portal_db_password=2ey3Yeg2XXm8bCnqwm38

# meta server url, different environments should have different meta server addresses
#dev_meta=http://10.0.253.208:8080
#test_meta=http://10.0.253.207:8080
#uat_meta=http://fill-in-uat-meta-server:8080
pro_meta=http://192.168.251.32:8080,http://192.168.251.21:8080

spring_kafka_bootstrap=elk2broker1.secoolocal.com:9092,elk2broker2.secoolocal.com:9092,elk2broker3.secoolocal.com:9092

META_SERVERS_OPTS="-Dpro_meta=$pro_meta  "

# =============== Please do not modify the following content =============== #
# go to script directory
cd "${0%/*}"

cd ..

# package config-service and admin-service
echo "==== starting to build config-service and admin-service ===="

mvn clean package -DskipTests -pl apollo-configservice,apollo-adminservice -am -Dapollo_profile=github -Dspring_datasource_url=$apollo_config_db_url -Dspring_datasource_username=$apollo_config_db_username -Dspring_datasource_password=$apollo_config_db_password

echo "==== building config-service and admin-service finished ===="

echo "==== starting to build portal ===="

mvn clean package -DskipTests -pl apollo-portal -am -Dapollo_profile=github,auth -Dspring_datasource_url=$apollo_portal_db_url -Dspring_datasource_username=$apollo_portal_db_username -Dspring_datasource_password=$apollo_portal_db_password -Dspring_kafka_bootstrap=$spring_kafka_bootstrap $META_SERVERS_OPTS

echo "==== building portal finished ===="
