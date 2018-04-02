# JHipster Registry

[![Build Status][travis-image]][travis-url]  [![Docker Pulls](https://img.shields.io/docker/pulls/jhipster/jhipster-registry.svg)](https://hub.docker.com/r/jhipster/jhipster-registry/)

This is the [JHipster](http://jhipster.github.io/) registry service, based on [Spring Cloud Netflix](http://cloud.spring.io/spring-cloud-netflix/), [Eureka](https://github.com/Netflix/eureka) and [Spring Cloud Config](http://cloud.spring.io/spring-cloud-config/).

Full documentation is available on the [JHipster documentation for microservices](http://jhipster.github.io/microservices-architecture).

## Deploy to Heroku

Click this button to deploy your own instance of the registry:

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

There are a few limitations when deploying to Heroku.

* The registry will only work with [native configuration](http://jhipster.github.io/microservices-architecture/#application-configuration-with-the-jhipster-registry) (and not Git config).
* The registry service cannot be scaled up to multiple dynos to provide redundancy. You must deploy multiple applications (i.e. click the button more than once). This is because Eureka requires distinct URLs to synchronize in-memory state between instances.

## Running locally

To run the cloned repository;
* For development run `./mvnw -Pdev,webpack` to just start in development or run `./mvnw` and run `yarn && yarn start` for hot reload of client side code.
* For production profile run `./mvnw -Pprod`

## 项目介绍
以上为jhipster官方readme文档
## 使用步骤
1. [官网][jhipster官网]下载jhipster-registry项目 git@github.com:jhipster/jhipster-registry.git
2. 运行前端
    - yarn 
    - yarn add node-sass
    - yarn start
3. 启动项目
4. 项目查看
http://localhost:8761/



[travis-image]: https://travis-ci.org/jhipster/jhipster-registry.svg?branch=master
[travis-url]: https://travis-ci.org/jhipster/jhipster-registry
[jhipster官网]: https://github.com/jhipster/jhipster-registry
