FROM openjdk:8
ADD target/user_profile_aecs.jar user_profile_aecs.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","user_profile_aecs.jar"]