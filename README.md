# flex-error
Sample app to reproduce the error

- Deploy the app. 

# deployment
```
mvn clean gcloud:deploy -Dmodule=default -Dgcloud.gcloud_project=flex-error -Dgcloud.version=1 -Dgcloud.gcloud_directory=${google-cloud-sdk-path} -Dgcloud.verbosity=debug -Dgcloud.log_level=debug -Dgcloud.log_http
```