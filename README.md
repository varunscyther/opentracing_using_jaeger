# opentracing_using_jaeger
Open tracing poc using Jaeger

Pre-requisites
1. Download the Jaeger 
    - https://www.jaegertracing.io/ 

Steps to run :
1. Start the Jaeger server
2. Build the project using "gradle clean build"
3. Run the application

Steps to test:
1. Hit the application URL i.e. http://localhost:9010/hello
2. Verify the traces in Jaeger via below link
    - http://localhost:16686/search
