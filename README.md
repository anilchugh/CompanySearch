# CompanySearch Application

## Build application 
mvn clean install

## Start up application
mvn spring-boot:run

## Testing

Sample curl request to search for active company : 

curl --location 'http://localhost:8080/www.company.com/search?isActive=true' \
--header 'x-api-key: 4W3j7cr3fC67DeP1NXvWw2fZaOpzfLYHaSjIutPV' \
--header 'Content-Type: application/json' \
--data '{
"companyName" : "COMPANIESBIZ LTD",
"companyNumber": "NI641677"
}'

Sample curl to search for dissolved company :

curl --location 'http://localhost:8080/www.company.com/search' \
--header 'x-api-key: 4W3j7cr3fC67DeP1NXvWw2fZaOpzfLYHaSjIutPV' \
--header 'Content-Type: application/json' \
--data '{
"companyName" : "COMPANIES4SALE LTD",
"companyNumber": "13796938"

}'

