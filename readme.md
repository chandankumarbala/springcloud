http://localhost:8086/cloudprops/default

/{application}/{profile}[/{label}]
/cloudprops/default/master

/{application}-{profile}.yml
/{label}/{application}-{profile}.yml

/{application}-{profile}.properties
/cloudprops-default.properties
http://localhost:8086/config/cloudprops-default.properties

/{label}/{application}-{profile}.properties
/master/cloudprops-default.properties ---works


In which the {label} placeholder refers to a Git branch, {application} to the client’s application name and the {profile} to the client’s current active application profile.
