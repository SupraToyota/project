TASK 1 {

    where{
        com.official_dealer.demo.controller.DealerController : createOffer(): 49
        com.official_dealer.demo.service.DealerOfferService : createOffer(): 34
    }

    problems{
        trim undefind
    }

}





psql -U postgres
\c car_official
GRANT ALL ON SCHEMA public TO official_dealer_auto;
GRANT CREATE ON SCHEMA public TO official_dealer_auto;
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO official_dealer_auto;



curl -u login:password http://localhost:8080/api/dealer/...



http://localhost:8080/swagger-ui/index.html
curl -u login:password http://localhost:8080/api/dealer/...


