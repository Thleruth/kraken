# Kraken (exchange) API implementation

### This repo is built as part of a final project of a coding bootcamp (CodingNomads)

[Kraken](https://www.kraken.com/) is a cryptocurrency exchange operating site functioning in Canada, EU, Japan, and the US;
usually rated as the best and most secure cryptocurrency exchange by independent outlets.
This Kraken interactive program is a Java library connecting a mapped API which consists of straightforward
instructions on how to analyze, record and interact with several cryptocurrency exchanges.

**Warning:** This project is a work in progress and should NOT be used as is. Any liabilities or damages
induced by the use of this tool is the sole responsibility of the user of this tool and not the developers.
Other features will be eventually implemented to improve the functionality and services of this project.

## Description
Kraken is a library providing a simple and consistent API for interacting with a diverse set of crypto currency exchanges.
To interact with the library, the first step is to either perform a trade or exchange, get the appropriate service and request
data, depending on whether the call is either [public](https://www.kraken.com/en-us/help/api#public-market-data) or
[private](https://www.kraken.com/en-us/help/api#private-user-data).

## Getting Started

Kraken requires a [Java 8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)  to be
installed on the machine you are going to use to run the program.


Required:
* [JDK 8](ttp://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](http://maven.apache.org/download.cgi)

Clone the project on your desired location

```
$ git clone https://github.com/Thleruth/kraken
$ cd kraken
$ mvn clean install
```

### Maven
Add the following dependencies in your [`pom.xml`](https://github.com/Thleruth/kraken/blob/master/pom.xml)
file to include encoders and decoders, to extend and augment the Java Collections
Framework(collection), and data-binding functionality for Jackson.

#### Dependencies
```xml
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.9</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>4.3.12.RELEASE</version>
</dependency>
<dependency>
    <groupId>commons-collection</groupId>
    <artifactId>commons-collection</artifactId>
    <version>3.2.1</version>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.1</version>
</dependency>
```

#### Plugin
``` xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.3</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
    </configuration>
</plugin>
```

## Configuration
This Kraken project contains several main packages including: `exception`, `model`, `service` and `util`.
Aside from these classes we have also created two independent classes: `Controller` and `KrakenExchange`,
which regulate the interaction of the program.

Within the `Exception` package we have added the three different exception classes:
* [`KrakenException`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/exception/KrakenException.java):
  extends directly to Exception and is the one the other two extend to.

* [`RateLimitException`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/exception/RateLimitException.java):
 takes care of any Rate Limit errors that might occur.

* [`UnknownEcxeption`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/exception/UnknownException.java):
 sends an error Message covering up any unknown errors.

 The `model` package contains several other packages mapping the content of the program and the API calls. These subsections include the `account`,
 `market`, and `trade` packages. Each one containing the appropriate pojos for their respective API calls, as well as the response it will generate
 for those who are only GET. The API calls which generate a POST, DELETE, PATCH, etc., also contain a request section for the created body.
 Aside from the already mentioned packages, there are a few independent classes as well, those are:

* [`ApiAuthentication`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/model/ApiAuthentication.java):
  includes the basic parameters needed to authenticate a call to the API.

* [`KrakenRequestEnum`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/model/KrakenRequestEnum.java):
  is an enum class which was designed to get specific information from the calls such as the endpoint, the type of HTTP call
  it is, the number of calls allowed, and the response output.

* [`OutputWrapper`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/model/OutputWrapper.java):
  A generic class with a generic value for the different type of results.

* [`RequestBodyGeneric`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/model/RequestBodyGeneric.java):
  abstract class which sets the correct parameters for classes with Request Bodies.


The `service` package contains classes which regulate the program. The classes located within this package include:
* [`CallCounter`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/service/CallCounter.java):
  which determined the maximum amount of calls to the API the user is allowed to make.
* [`GenericRequestHandler`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/service/GenericRequestHandler.java):
  a generic Request Hanlder that is able to call all end points.
* [`KrakenSignature`](https://github.com/Thleruth/kraken/blob/master/src/main/java/co/codingnomads/kraken/service/KrakenSignature.java):
 which creates the API-Sign based on the particular Kraken requirement.

We also have the `util` package which contains classes that form the base for the API-calls from the Kraken site; encoding and decoding the data from
the cryptographic hash as well as providing the necessary security.

Lastly, we have the independent classes `Controller` and `KrakenExchange`. The KrakenExchange class contains methods for all Kraken Exchange API
calls and also sets the necessary call query parameters, which is why a method for each API call is needed. Once that method is ready, it can be called
on the Controller.

## Contributors

* [Thomas Leruth](https://github.com/Thleruth)
* [Jialor Chong](https://github.com/PopoPenguin)
* [Meghan Boyce](https://github.com/meejahnsnutshell)
* [Kevin Neag](<https://github.com/neagkv)
* [Ricardo Roque](https://github.com/rickypatillas)

## Acknowledgements
* [KrakenXchange](https://github.com/timmolter/XChange) by Tim Molter.






| Calls  | Status |
|:------:|--------|
|`GetServerTime` | Implemented and tested |
|`GetAssetInfo` | Implemented and tested |
|`GetTradableAssetPairs` | Implemented and tested |
|`GetTickerInformation` | Implemented and Tested |
|`GetOHLCdata` | Implemented and tested |
|`GetOrderBook` | Implemented and Tested |
|`GetRecentTrades` | Implemented and tested |
|`GetRecentSpreadData` | Implemented and tested |
|`GetAccountBalance` | Implemented and tested | 
|`GetTradeBalance` | Implemented and tested |
|`GetOpenOrders` | Implemented and tested |
|`GetClosedOrders` | Implemented and tested |
|`QueryOrdersInfo` | Implemented and Tested |
|`GetTradesHistory` | Implemented and tested |
|`QueryTradesInfo` | Implemented and tested |
|`GetOpenPositions` | Requires Testing (could not be tested without a valid open order)|
|`GetLedgersInfo` | Implemented and tested |
|`QueryLedgers` | Implemented and tested |
|`GetTradeVolume` | Implemented and tested |
|`AddStandardOrder` | Implemented and tested     |
|`CancelOpenOrder` | Implemented and tested |


Resource used for this project include but not limited to-----------------------------
krakenXChange by Tim Molter: <url>https://github.com/timmolter/XChange/tree/5174f9e931955dc201fa57e228564d8b884c9f84/xchange-kraken</url>

