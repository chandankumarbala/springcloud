# Configuration Server 
 Base path `http://localhost:8086/config` 

1)In which the {label} placeholder refers to a Git branch, {application} to the client’s application name and the {profile} to the client’s current active application profile.

http://localhost:8086/cloudprops/default
http://localhost:8086/config/master/cloudprops-default.properties
http://localhost:8086/config/cloudprops-default.properties

/{application}/{profile}[/{label}]
/cloudprops/default/master
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/cloudprops-default.properties
/{label}/{application}-{profile}.properties



# Rest Service provider 
Rest Server `http://localhost:8087`
Actuator `http://localhost:8087/actuator` provides health,info,env,refresh
`http://localhost:8087/actuator/info` show server details and exposed service url 


Refresh data using  
`curl -X POST \
  http://localhost:8087/actuator/refresh`
  
  
# Eureka Srever (Discovery service)
Web console `http://localhost:8089`

  
# Load balancer / Gateway service (JUUL server) 
JUUL server `http://localhost:8090/actuator` provides `http://localhost:8090/actuator/routes` which show all servericed location by the load balancer.






