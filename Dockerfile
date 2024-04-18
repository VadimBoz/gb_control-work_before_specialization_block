FROM bellsoft/liberica-openjdk-alpine:22
LABEL authors="vadim"
WORKDIR /APP/gb_control-work_before_specialization_block
COPY . .
WORKDIR /APP
RUN javac -sourcepath ./gb_control-work_before_specialization_block/frends/src  \
    -d ./gb_control-work_before_specialization_block/frends/out \
    ./gb_control-work_before_specialization_block/frends/src/Main.java
#CMD  javadoc -encoding utf8 -d ./gb_control-work_before_specialization_block/frends/docs \
#    -sourcepath ./gb_control-work_before_specialization_block/frends/src -cp out -subpackages ""
#CMD ["java", "-classpath", "./gb_control-work_before_specialization_block/frends/out", "Main"]
CMD ./gb_control-work_before_specialization_block/start.sh