
CRUD Application
-----------
Spring boot, Jpa, Mysql
----
<h6>Requirements:\
    a) Mysql
</h6>

<h6>When Application starts it will save some initial data to tables</h6>


 Item api:
 
 1) Get All items:
 
    Request: http://localhost:8080/item/list\
    Response:\
     [{"id":1,"name":"soap","stocks":1000,"unitPrice":10.5,"description":"Baby Soap"},{"id":2,"name":"Tooth Brush","stocks":500,"unitPrice":45.5,"description":"Tooth Brush"},{"id":3,"name":"Shirt","stocks":100,"unitPrice":1500.0,"description":"Shirt"},{"id":4,"name":"Office Bag","stocks":400,"unitPrice":10000.0,"description":"Office Bag"},{"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}]
    
 2) Get Item by Id:
    
    Request: http://localhost:8080/item/5\
    Response:\
     {"id":5,"name":"Bottle","stocks":800,"unitPrice":450.5,"description":"Bottle"}
    
 3) Add a Item:
  
    Request:\ 
       url:\
        http://localhost:8080/item/add\
       type:\
        POST\
       request Header:\
        Content-Type:application/json\
       body:\
        {"name":"sanitizer",
         "stocks":"40",
         "unitPrice":"80.0",
         "description":"Sanitizer"
        }
        
    Response:\
        Item Added Successfully !
        
 4)  Update a name and description of give item id:
  
     Request:\ 
        url:\
         http://localhost:8080/item/update/4\
        type:\
         PUT\
        request Header:\
         Content-Type:application/json\
        body:\
         {"name":"Office Bag imported from US",
          "description":"Office Bag imported from US"
         }
         
     Response:\
         Item Updated Successfully !
 
 5) Delete Item of give item id:
  
     Request:\ 
        url:\
         http://localhost:8080/item/delete/3\
        type:\
         DELETE\
        request Header:\
         Content-Type:application/json\
         
     Response:\
         Item with given Id is deleted Successfully !
             
-----
Order Api

1) Single Order:\

    Request:\ 
        url:\
         http://localhost:8080/order\
        type:\
         POST\
        request Header:\
         Content-Type:application/json\
        body:\
         {"customer":{"id":"1"},
          "itemOrdered": {"item":{"id":"1"},"quantity":"10"},
         "type":"SINGLE"
        }
         
    Response:\
        SUCCESS
    