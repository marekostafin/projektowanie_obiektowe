FROM ubuntu:22.04

RUN apt-get update
RUN apt-get install -y fpc
RUN rm -rf /var/lib/apt/lists/*

WORKDIR /zadanie1

COPY zadanie1.pas /zadanie1/

RUN fpc -ozadanie1 zadanie1.pas
CMD ["./zadanie1"]

