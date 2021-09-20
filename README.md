
# Twitter Challenge

Integrated with the Twitter API, this application allows you to search for Tweets with geolocation through Hashtags. These Tweets are stored in a database instance in the cloud.

The backend was built using [Spring](https://spring.io/), a Java framework and deployed on the IBM Cloud with the entire integration and deploy process (CI / CD).

## Backend

All dependencies are found in the `pom.xml` file. The ports are set as the default `8080` for HTTP and `8443` for HTTPS.

A aplicação expõe os seguintes endpoints:
The application exposes the following endpoints:
* Health endpoint: `<host>:<port>/health` ex: http://localhost:8080/health
* Web content: `<host>:<port>`

### Building Locally

To get started building this application locally, you can either run the application natively or use the [IBM Cloud Developer Tools](https://cloud.ibm.com/docs/cli?topic=cloud-cli-getting-started) for containerization and easy deployment to IBM Cloud.

#### Native Application Development

* [Maven](https://maven.apache.org/install.html)
* Java 8: Any compliant JVM should work.
  * [Java 8 JDK from Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
  * [Java 8 JDK from IBM (AIX, Linux, z/OS, IBM i)](http://www.ibm.com/developerworks/java/jdk/),
    or [Download a Liberty server package](https://developer.ibm.com/assets/wasdev/#filter/assetTypeFilters=PRODUCT)
    that contains the IBM JDK (Windows, Linux)

To build and run an application:

1. `mvn install`
2. `java -jar ./target/javaspringapp-1.0-SNAPSHOT.jar`

To run an application in Docker use the Docker file called `Dockerfile`. If you do not want to install Maven locally you can use `Dockerfile-tools` to build a container with Maven installed.

You can verify the state of your locally running application using the Selenium UI test script included in the `scripts` directory.

### Cloud deploy

To deploy on Cloud, if you have access to this repository you just have to push on your Git, that CI/CD will handle all the deploying process.

```bash
git add .
git commit -m "commit message"
git push
```

## Routes

### Hashtag

[GET] /hashtag - Get all hashtags

Response
```json
[
  {
    "name": "#orlando"
  },
  {
    "name": "#photograph"
  }
]
```

[POST] /hashtag - Add new hashtag and get all tweets related to that specific hashtag

Request body
```json
{
	"name": "#newyork"
}
```

Response
```json
[
  {
    "hashtag": "#newyork",
    "tweetId": "1328947762023250834432",
    "username": "13stLookLasVegas",
    "text": "#vegas #chicago #newyork #la #miami #sf #houston #denver #philadelphia #dc #seattle #minneapolis #stl #phoenix #sd #cleveland #detroit #toronto #indiana #slc #orlando #atl #neworleans #boston\n\nWhat a deal!!!!\nhttps://t.co/oau4t2hyzu0 https://t.co/t1b62R2Ejz0",
    "sentiment": "positive",
    "latitude": 36.129459,
    "longitude": -115.384091,
    "createdAt": "2020-11-18T06:26:51.000+00:00",
    "profileImageURL": "http://pbs.twimg.com/profile_images/919673042145492992/R0mFeg27r_normal.jpg"
  },
]
```

[DELETE] /hashtag/:hashtag - Delete hashtag (:hashtag without `#`)

## Tweet

[GET] /tweet?hashtag - Get tweets by hashtag provided on Query Param

Response
```json
[
  {
    "hashtag": "#newyork",
    "tweetId": "1328947762023250834432",
    "username": "13stLookLasVegas",
    "text": "#vegas #chicago #newyork #la #miami #sf #houston #denver #philadelphia #dc #seattle #minneapolis #stl #phoenix #sd #cleveland #detroit #toronto #indiana #slc #orlando #atl #neworleans #boston\n\nWhat a deal!!!!\nhttps://t.co/oau4t2hyzu0 https://t.co/t1b62R2Ejz0",
    "sentiment": "positive",
    "latitude": 36.129459,
    "longitude": -115.384091,
    "createdAt": "2020-11-18T06:26:51.000+00:00",
    "profileImageURL": "http://pbs.twimg.com/profile_images/919673042145492992/R0mFeg27r_normal.jpg"
  },
]
```

## Frontend

The Frontend files are located on `/client/` directory.

```bash
cd client
```

### `yarn start OR npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `yarn build OR npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

To deploy this application I have used [Netlify](https://www.netlify.com/), that is a service that automates builds, deployments and manages your websites. It’s one of the fastest and easiest deployment solutions these days.

