# opennotify4j [![Build Status](https://travis-ci.org/bo0tzz/opennotify4j.svg?branch=master)](https://travis-ci.org/bo0tzz/opennotify4j)
Opennotify4j is a java wrapper for the open-notify.org API, and allows you to easily retrieve data about the ISS.

## Getting Started
### Maven

You can add this API as a dependency using Maven.
```xml
<dependencies>
  <dependency>
    <groupId>me.bo0tzz</groupId>
    <artifactId>opennotify4j</artifactId>
    <version>1.0.0</version>
  </dependency>
</dependencies>
```

### Usage

Using this API, you can do any one of three things:
- Request the current location of the ISS
- Request the amount of people currently in space
- Request the times at which the ISS will fly over a given location

Let's go over all three in order.

#### Location

First, to request the current location of the ISS, we create an ISSLocationRequest. When creating a request, we need to pass it a callback method that will be executed once the request completes. We can create our request as follows:

```java
ISSLocationRequest request = ISSLocationRequest.builder()
                .callback((issLocation) -> {
                    System.out.println(issLocation.getLocation());
                }).build();
```                

This piece of code has created an ISSLocationRequest and given it a callback method that will print out the information received from the API. However, we haven't actually told our code to send the request yet. Doing that is simply as follows:

```java
request.perform();
```

This will perform the request and, after it receives a response, execute the callback that we specified earlier.

#### People

Second is requesting the amount of people that are currently in space. This is similarly easy:

```java
ISSPeopleRequest request = ISSPeopleRequest.builder()
      .callback((issPeople -> {
          System.out.println("There are currently " + issPeople.getNumber() + " people in space!");
      })).build();

request.perform();
```

#### Pass times

Requesting the times at which the ISS will pass over a given location is a bit more complicated, since we need to pass the API a location for which to return the results for. A Location object is created as follows:

```java
Location location = Location.builder()
                .latitude(29.7604f)
                .longitude(-95.3698f)
                .build();
```

We then use this Location object in the builder for our request, along with the callback:

```java
ISSPassRequest request = ISSPassRequest.builder()
        .location(location)
        .callback((issPass -> {
            System.out.println("The next ISS pass is at unix time " + issPass.nextPass().getRisetime());
        }))
        .build();

request.perform();
```

Instead of creating a location object beforehand, you can also use the latitude and longitude methods on the ISSPassRequest builder. The builder also supplies two other methods, `altitude` and `count`. These provide the altitude of the location you're passing in and the amount of upcoming passes to request, respectively.

If you have any questions, please do not hesitate to join the support group at https://t.me/opennotify4j
