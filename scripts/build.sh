#!/bin/sh

# apollo config db info
apollo_config_db_url=jdbc:mysql://10.0.253.122:3306/ApolloConfigDB?characterEncoding=utf8
apollo_config_db_username=Apollo_test
apollo_config_db_password=7SadtKH4AoVIq5UC7qUk

# apollo portal db info
apollo_portal_db_url=jdbc:mysql://10.0.253.122:3306/ApolloPortalDB?characterEncoding=utf8
apollo_portal_db_username=Apollo_test
apollo_portal_db_password=7SadtKH4AoVIq5UC7qUk

# meta server url, different environments should have different meta server addresses
dev_meta=http://10.0.253.208:8080
test_meta=http://10.0.253.207:8080
#uat_meta=http://fill-in-uat-meta-server:8080
#pro_meta=http://localhost:8080

META_SERVERS_OPTS="-Ddev_meta=$dev_meta -Dtest_meta=$test_meta "

# =============== Please do not modify the following content =============== #
# go to script directory
cd "${0%/*}"

cd ..

# package config-service and admin-service
echo "==== starting to build config-service and admin-service ===="

mvn clean package -DskipTests -pl apollo-configservice,apollo-adminservice -am -Dapollo_profile=github -Dspring_datasource_url=$apollo_config_db_url -Dspring_datasource_username=$apollo_config_db_username -Dspring_datasource_password=$apollo_config_db_password

echo "==== building config-service and admin-service finished ===="

echo "==== starting to build portal ===="

mvn clean package -DskipTests -pl apollo-portal -am -Dapollo_profile=github,auth -Dspring_datasource_url=$apollo_portal_db_url -Dspring_datasource_username=$apollo_portal_db_username -Dspring_datasource_password=$apollo_portal_db_password $META_SERVERS_OPTS

echo "==== building portal finished ===="
