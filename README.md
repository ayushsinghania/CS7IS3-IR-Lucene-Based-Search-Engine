# INFORMATION RETRIEVAL AND WEB SEARCH
## Assignment 1: Lucene and Cranfield

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://github.com/ayushsinghania/CS7IS3-IR-Lucene-Based-Search-Engine)

Following folder/file have been uploaded in the AWS Instance 

  - Github cloned respoitory titles **"CS7IS3-IR-Lucene-Based-Search-Engine"** (Complete Project Folder)
  - Source code present at **CS7IS3-IR-Lucene-Based-Search-Engine/luceneProject/src/main/java/luceneProject/**
  - trec_eval present at **CS7IS3-IR-Lucene-Based-Search-Engine/luceneProject/src/trec_eval-9.0.7**
  
## Login Credentials

- Username: ayush
- Password: ayush

## AWS Instance's IP address
 - IPv4 Public IP: **52.90.142.34**
 
## Getting Started

- Open Terminal/Command Prompt on you PC/MAC/Linux System
- Copy the commands present below one at a time
- **Note:** This project uses the new version of the QRel file named as **cranqrelnew**

## How to access our AWS instance: 
  ```sh
$ ssh ayush@ec2-52-90-142-34.compute-1.amazonaws.com

ayush@ec2-52-90-142-34.compute-1.amazonaws.com's password: ayush
```
Enter **ayush** as password

Now you are inside the AWS instance. Again copy the commands and run at a time

## How to build the source code

 ```sh
$ cd CS7IS3-IR-Lucene-Based-Search-Engine/luceneProject/

$ sudo mvn package

$[sudo] password for ayush: ayush (enter password if promted)
```
## How to run the source code
 ```sh
$ sudo java -jar target/luceneProject-0.0.1-SNAPSHOT.jar
```
## How to get the program's output
```sh
$ cd src/trec_eval-9.0.7/

$ make

$ ./trec_eval ../cran/cranqrelnew ../query-rankings.txt
```
