
#
# In this dockerfile, let's just manually compile and run testing/FormattedOutput.java
#
FROM openjdk:8
COPY testing /home/testing
WORKDIR /home/testing/
RUN javac FormattedOutput.java
CMD ["java", "FormattedOutput"]
