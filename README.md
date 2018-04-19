## ProximaX Simple Static Website Deployment Tool

Quick and dirty java CLI to host static site. This tool will:

- Upload Static Site to IPFS
- Use the Merkle Node and root it on NEM Blockchain.

# Requirements
- Only run on Linux
- Make sure ProximaX IPFS (or IPFS distro) is running (ipfs daemon)
- Java 1.8
- NEM Account with at least 5xems (each run costs 1.80xems approx).

## Technology/Libraries
- Java 1.8
- ProximaX Storage Java SDK (will be provided when its done).

## Installation
Checkout the repository and build

```
mvn clean install
```

## Run 

```
java -jar proximax-static-webhost-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```

Console Output

```
Welcome to Simple Website Static Hosting Tool by ProximaX

1. Make sure you load your folder in this current box.
2. Make sure ProximaX IPFS is Running!
3. Make sure to enter the Root directory of your site.

Ready? Lets begin! (Hit Enter)
```


Answer each question.
- Root Directory of the static site
- Private/Public Keys (server will never transmit keys over the wire)

A hash will be provided. Wait for the Hash to be confirmed and your good to go!

## Samples

- [ProximaX Backup site](https://gateway.proximax.io/xpx/directory/load/static/d1b863f489ba38803ff05127981820e7d2626771564ed415edceea6014df5c95/index.html#about)
- [Mario Game](https://gateway.proximax.io/xpx/directory/load/static/d4730c3bf0db502b3b36f1127b3f6d1ed8ef8993c41ebaa54ff79852ac99c379/root/p2pnew/mariogame/main.html)



<sub>Proximax Limited Copyright (c) 2018</sub>
