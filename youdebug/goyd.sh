#!/bin/bash
#
export YDJAR=~/cm2015/youdebug/jar/youdebug-1.5-jar-with-dependencies.jar
# export CLASSPATH=$CLASSPATH:/opt/jmiguel/apache-tomcat-7.0.52/webapps/codemotion/WEB-INF/classes
# echo $CLASSPATH
clear
echo "-------"
java -jar $YDJAR -socket 5005 $1
