# Assignment for RBC coding challenge
[![ci-test](https://github.com/gibson-luo/dowjones/actions/workflows/ci.yml/badge.svg)](https://github.com/gibson-luo/dowjones/actions/workflows/ci.yml)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://github.com/gibson-luo/dowjones/blob/main/LICENSE)

Author: Zherui (Gibson) Luo

## Getting Started

Download the latest version package from the releases.  

[Check Out Versions](https://github.com/gibson-luo/dowjones/releases)

Unzip the file and run following commands. 
```bash
# build with Maven
mvn install -DskipTests -f pom.xml

# build docker image
docker build -t api-docker.jar .

# run with docker-compose
docker-compose up -d
```
After the server is running, open the link with Browser. 
```
http://127.0.0.1:8080/swagger-ui/index.html
```

## REST API
There are three API endpoints.
### POST v1/reference/save
``` 
http://127.0.0.1:8080/v1/reference/save
```
Put the following example data to request body.
``` 
{"quarter":1,"stock":"TEST1","date":"1/21/2011","open":"$16.19","high":"$16.38","low":"$15.60","close":"$15.79","volume":"138428495","percent_change_price":"-2.47066","percent_change_volume_over_last_wk":"-43.02495926","previous_weeks_volume":"242963398","next_weeks_open":"$15.87","next_weeks_close":"$16.13","percent_change_next_weeks_price":"1.63831","days_to_next_dividend":12,"percent_return_next_dividend":"0.189994"}
```

### POST v1/reference/importData
```
http://127.0.0.1:8080/v1/reference/importData
```
Add a file to form-data with the 'file' param name, and a type of File.

Example file: http://archive.ics.uci.edu/ml/machine-learning-databases/00312/

### GET v1/reference/fetchByTicker
``` 
http://127.0.0.1:8080/v1/reference/fetchByTicker?ticker=AA
```

## Testing
The project includes some unit tests, it runs on Github Actions when submitting the code.
Please check the CI page.

https://github.com/gibson-luo/dowjones/actions/workflows/ci.yml