# Configuration Server 
## Base path `http://localhost:8086/config` 

**In which the {label} placeholder refers to a Git branch, {application} to the client’s application name and the {profile} to the client’s current active application profile.** 

_Sample_
* http://localhost:8086/cloudprops/default  
* http://localhost:8086/config/master/cloudprops-default.properties  
* http://localhost:8086/config/cloudprops-default.properties  

_Formats_
1. /{application}/{profile}[/{label}]  
    1. /cloudprops/default/master  
1. /{application}-{profile}.yml  
1. /{label}/{application}-{profile}.yml  
1. /{application}-{profile}.properties  
    1. /cloudprops-default.properties  
1. /{label}/{application}-{profile}.properties  



# Rest Service provider 
**Rest Server `http://localhost:8087`**  
* Actuator `http://localhost:8087/actuator` provides health,info,env,refresh  
* `http://localhost:8087/actuator/info` show server details and exposed service url   


**Refresh data using**  
`curl -X POST \
  http://localhost:8087/actuator/refresh`
  
  
# Eureka Srever (Discovery service)
Web console `http://localhost:8089`  

  
# Load balancer / Gateway service (JUUL server) 
JUUL server `http://localhost:8090/actuator` provides `http://localhost:8090/actuator/routes` which show all servericed location by the load balancer.  

# Config bootstrap

*  spring.cloud.config.server.git.uri
*  spring.cloud.config.server.git.clone-on-start=true
*  spring.cloud.config.server.bootstrap=true
*  SPRING_PROFILES_ACTIVE=native results intp spring.profiles.active= in runtime
*  spring.cloud.config.server.git.username=
*  spring.cloud.config.server.git.password=

# Load Balancer ZULL

* server.port=8090
* spring.application.name=zuul-loadbalancer
* management.endpoints.web.exposure.include=info,health,env,routes

##Inside PCF
__exposed in /actuator/info__
info.app.name=zuul-loadbalancer-gateway-machine
info.app.description=This server provides the load balancing as well as gateway services.
info.app.version=1.0.0

__Custom Tags__
* service.discovery.host=<Name of the eureka server used later>
* eureka.instance.hostname=<Name of current server used later>

__Eureka config__
* eureka.client.service-url.defaultZone=https://${service.discovery.host}/eureka/
* eureka.instance.status-page-url=https://${eureka.instance.hostname}/actuator/info
* eureka.instance.health-check-url=https://${eureka.instance.hostname}/actuator/health
* eureka.instance.secureVirtualHostName=${spring.application.name}
* eureka.client.registerWithEureka=true
* eureka.client.fetchRegistry=true
* ribbon.IsSecure=true
* ribbon.ReadTimeout = 6000

######<clientName>.ribbon.ReadTimeout = 60000
###### Disable Hystrix timeout globally (for all services)
######--hystrix.command.default.execution.timeout.enabled: false
###### Disable Hystrix timeout for a single service
######--hystrix.command.<serviceName>.execution.timeout.enabled: false
###### Increase the Hystrix timeout to 60s (globally)
######--hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds: 60000
###### Increase the Hystrix timeout to 60s (per service)
######hystrix.command.<serviceName>.execution.isolation.thread.timeoutInMilliseconds: 60000
######--hystrix.command.<service name>RibbonCommand.<property name> = <value>

__Zull timeout settings__
* zuul.host.connect-timeout-millis=6000
* zuul.host.socket-timeout-millis=6000
* zuul.trace-request-body=true



## NON PCF

* service.discovery.host=localhost:8089
* eureka.instance.hostname=localhost:8090
* eureka.client.service-url.defaultZone=https://${service.discovery.host}/eureka/
* eureka.instance.status-page-url=https://${eureka.instance.hostname}/actuator/info
* eureka.instance.health-check-url=https://${eureka.instance.hostname}/actuator/health
* eureka.instance.home-page-url=https://${eureka.instance.hostname}/
* ribbon.IsSecure=true


#REST application (Microservice)

__custom properties__
* config.host=<config server host name>

__spring properties__
* server.port=8091
* spring.application.name=

__spring cloud properties__
* management.endpoints.web.exposure.include=refresh,info,health,env
* info.app.name=soiemsconnectivity-machine
* info.app.description=This server provides the actual rest service. try /getAccounts
* info.app.version=1.0.0
* spring.cloud.config.uri=https://${config.host}/config
* management.security.enabled=false





# Discoveryy


## Inside PCF

__Custom properties__
* eureka.instance.hostname=

__spring properties__
* server.port=8089
* spring.application.name=Service-Discovery-Eureka-server

__exposed in /actuator/info__
* info.app.name=servicediscovery-eureka-machine
* info.app.description=This server provides the service registry.
* info.app.version=1.0.0

__Eureka settins__
* eureka.client.service-url.defaultZone=https://${eureka.instance.hostname}/eureka/
* eureka.instance.status-page-url=https://${eureka.instance.hostname}/actuator/info
* eureka.instance.health-check-url=https://${eureka.instance.hostname}/actuator/health
* ribbon.IsSecure=true
* eureka.client.register-with-eureka=true
* eureka.client.fetch-registry=true

#eureka.instance.preferIpAddress

